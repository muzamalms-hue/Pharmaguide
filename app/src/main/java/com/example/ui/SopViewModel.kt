package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.data.AppDatabase
import com.example.data.SopEntity
import com.example.data.SopRepository
import com.example.data.ContactInquiryEntity
import com.example.data.UserMonographEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

enum class MenuCategory(val displayName: String) {
    HOME("Home"),
    QUALITY_CONTROL("Quality Control"),
    QUALITY_ASSURANCE("Quality Assurance"),
    MICROBIOLOGY("Microbiology"),
    PRODUCTION("Production"),
    SOPS("SOPs"),
    VALIDATION("Validation"),
    GMP("GMP"),
    AUDIT("Audit"),
    DOCUMENTS("Documents"),
    ASK("Ask"),
    USP_COLUMNS("USP"),
    VIDEOS("Videos"),
    CALCULATORS("Calculators"),
    CONTACT("Contact Us")
}

class SopViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: SopRepository

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _selectedDepartments = MutableStateFlow<Set<String>>(
        setOf("SOPs", "Quality Control", "Microlab", "Quality Assurance", "Production", "Warehouse", "Validation", "GMP", "Audit", "Documents")
    )
    val selectedDepartments = _selectedDepartments.asStateFlow()

    private val _currentCategory = MutableStateFlow(MenuCategory.HOME)
    val currentCategory = _currentCategory.asStateFlow()

    private val _selectedSubsections = MutableStateFlow<Set<String>>(emptySet())
    val selectedSubsections = _selectedSubsections.asStateFlow()

    private val _currentUserRole = MutableStateFlow("Analyst") // Default role
    val currentUserRole = _currentUserRole.asStateFlow()

    private val _selectedSopId = MutableStateFlow<Int?>(null)
    val selectedSopId = _selectedSopId.asStateFlow()

    init {
        val database = AppDatabase.getDatabase(application)
        repository = SopRepository(database.sopDao())
        
        // Ensure prepopulation runs in co-routine
        viewModelScope.launch {
            repository.checkAndPrepopulate()
        }
    }

    val contactInquiries: StateFlow<List<ContactInquiryEntity>> = repository.getAllContactInquiries()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    val userMonographs: StateFlow<List<UserMonographEntity>> = repository.getAllUserMonographs()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun uploadUserMonograph(
        productName: String,
        activeIngredient: String,
        dosageForm: String,
        pf: String,
        lgsCode: String,
        brand: String,
        testType: String,
        comments: String,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch {
            val monograph = UserMonographEntity(
                productName = productName.uppercase().trim(),
                activeIngredient = activeIngredient.trim(),
                dosageForm = dosageForm.trim(),
                pf = pf.trim(),
                lgsCode = lgsCode.uppercase().trim(),
                brand = brand.trim(),
                testType = testType.trim(),
                comments = comments.trim()
            )
            repository.insertUserMonograph(monograph)
            onSuccess()
        }
    }

    fun deleteUserMonograph(id: Int) {
        viewModelScope.launch {
            repository.deleteUserMonograph(id)
        }
    }

    fun insertUserMonographs(monographs: List<UserMonographEntity>, onSuccess: () -> Unit = {}) {
        viewModelScope.launch {
            repository.insertUserMonographs(monographs)
            onSuccess()
        }
    }

    fun submitContactInquiry(
        fullName: String,
        email: String,
        contactNumber: String,
        subject: String,
        message: String,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch {
            val inquiry = ContactInquiryEntity(
                fullName = fullName,
                email = email,
                contactNumber = contactNumber,
                subject = subject,
                message = message
            )
            repository.insertContactInquiry(inquiry)
            onSuccess()
        }
    }

    // Reactive SOP stream combining search and department filters
    val sops: StateFlow<List<SopEntity>> = combine(
        _searchQuery,
        _selectedDepartments
    ) { query, depts ->
        Pair(query, depts.toList())
    }.flatMapLatest { (query, depts) ->
        repository.searchSops(query, depts)
    }.combine(_selectedSubsections) { sopsList, subsections ->
        if (subsections.isEmpty()) {
            sopsList
        } else {
            sopsList.filter { subsections.contains(it.section) }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    // Current selected SOP detail flow
    val selectedSop: StateFlow<SopEntity?> = _selectedSopId.flatMapLatest { id ->
        if (id == null) {
            MutableStateFlow(null)
        } else {
            repository.getSopById(id)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = null
    )

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun selectCategory(category: MenuCategory) {
        _currentCategory.value = category
        _selectedSopId.value = null
        when (category) {
            MenuCategory.HOME -> {
                _selectedDepartments.value = setOf("SOPs", "Quality Control", "Microlab", "Quality Assurance", "Production", "Warehouse", "Validation", "GMP", "Audit", "Documents")
            }
            MenuCategory.QUALITY_CONTROL -> _selectedDepartments.value = setOf("Quality Control")
            MenuCategory.QUALITY_ASSURANCE -> _selectedDepartments.value = setOf("Quality Assurance")
            MenuCategory.MICROBIOLOGY -> _selectedDepartments.value = setOf("Microlab")
            MenuCategory.PRODUCTION -> _selectedDepartments.value = setOf("Production")
            MenuCategory.SOPS -> {
                _selectedDepartments.value = setOf("SOPs")
            }
            MenuCategory.VALIDATION -> _selectedDepartments.value = setOf("Validation")
            MenuCategory.GMP -> _selectedDepartments.value = setOf("GMP")
            MenuCategory.AUDIT -> _selectedDepartments.value = setOf("Audit")
            MenuCategory.DOCUMENTS -> _selectedDepartments.value = setOf("Documents")
            else -> {
                _selectedDepartments.value = emptySet()
            }
        }
        _selectedSubsections.value = emptySet()
    }

    fun toggleDepartment(department: String) {
        val current = _selectedDepartments.value.toMutableSet()
        if (current.contains(department)) {
            current.remove(department)
        } else {
            current.add(department)
        }
        _selectedDepartments.value = current
    }

    fun selectAllDepartments() {
        _selectedDepartments.value = setOf("SOPs", "Quality Control", "Microlab", "Quality Assurance", "Production", "Warehouse", "Validation", "GMP", "Audit", "Documents")
        _selectedSubsections.value = emptySet()
    }

    fun clearAllDepartments() {
        _selectedDepartments.value = emptySet()
        _selectedSubsections.value = emptySet()
    }

    fun toggleSubsection(subsection: String) {
        val current = _selectedSubsections.value.toMutableSet()
        if (current.contains(subsection)) {
            current.remove(subsection)
        } else {
            current.add(subsection)
        }
        _selectedSubsections.value = current
    }

    fun selectUserRole(role: String) {
        _currentUserRole.value = role
    }

    fun selectSop(id: Int?) {
        _selectedSopId.value = id
    }

    fun toggleBookmark(id: Int, isBookmarked: Boolean) {
        viewModelScope.launch {
            repository.updateBookmark(id, isBookmarked)
        }
    }

    fun signOffSop(id: Int) {
        viewModelScope.launch {
            repository.signOffSop(id, _currentUserRole.value, System.currentTimeMillis())
        }
    }

    fun checkRolePermission(requiredRole: String): Boolean {
        return true
    }

    class Factory(private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SopViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return SopViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}

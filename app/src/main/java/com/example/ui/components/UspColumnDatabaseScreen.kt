package com.example.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.UspColumn
import com.example.data.UspColumnData
import com.example.data.UspMonographData
import com.example.data.UspProductMonograph
import com.example.data.MonographTestColumn
import com.example.data.UserMonographEntity
import com.example.ui.SopViewModel
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.platform.LocalContext
import java.io.BufferedReader
import java.io.InputStreamReader
import org.json.JSONArray
import org.json.JSONObject
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.ui.viewinterop.AndroidView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UspColumnDatabaseScreen(
    viewModel: SopViewModel,
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableStateOf(2) } // Default to the brand new USP Monograph tab
    val tabTitles = listOf("L-Codes", "Product Columns", "USP Monograph", "Web Portal")

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = {
                        Text(
                            text = title,
                            fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Normal,
                            fontSize = 11.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    icon = {
                        val icon = when (index) {
                            0 -> Icons.Default.ViewColumn
                            1 -> Icons.Default.Search
                            2 -> Icons.Default.Book
                            3 -> Icons.Default.Language
                            else -> Icons.Default.Book
                        }
                        Icon(icon, contentDescription = null)
                    },
                    modifier = Modifier.testTag("usp_tab_$index")
                )
            }
        }

        Box(modifier = Modifier.weight(1f)) {
            when (selectedTab) {
                0 -> LCodesDirectoryView()
                1 -> ProductMonographsView()
                2 -> UspMonographsTabView(viewModel = viewModel)
                3 -> UspWebPortalView()
            }
        }
    }
}

@Composable
fun UspWebPortalView(modifier: Modifier = Modifier) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true
                settings.allowFileAccess = true
                settings.allowContentAccess = true
                settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
                
                webViewClient = WebViewClient()
                loadUrl("file:///android_asset/web/index.html")
            }
        },
        modifier = modifier.fillMaxSize()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LCodesDirectoryView() {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategoryFilter by remember { mutableStateOf("All") }
    var expandedColumnCode by remember { mutableStateOf<String?>(null) }
    
    // Equivalent finder state
    var selectedLCodeForEquivalents by remember { mutableStateOf("L1") }

    val categories = listOf("All", "C18/C8", "Silica", "Polar/Cyano", "Polymeric/Ion Exch", "Phenyl")

    val filteredColumns = remember(searchQuery, selectedCategoryFilter) {
        UspColumnData.columns.filter { col ->
            val matchesSearch = col.code.contains(searchQuery, ignoreCase = true) ||
                    col.name.contains(searchQuery, ignoreCase = true) ||
                    col.description.contains(searchQuery, ignoreCase = true) ||
                    col.popularBrands.any { it.contains(searchQuery, ignoreCase = true) } ||
                    col.typicalApplications.any { it.contains(searchQuery, ignoreCase = true) }

            val matchesCategory = when (selectedCategoryFilter) {
                "All" -> true
                "C18/C8" -> col.code == "L1" || col.code == "L7" || col.code == "L43"
                "Silica" -> col.code == "L3"
                "Polar/Cyano" -> col.code == "L8" || col.code == "L10" || col.code == "L20"
                "Polymeric/Ion Exch" -> col.code == "L9"
                "Phenyl" -> col.code == "L11" || col.code == "L60"
                else -> true
            }

            matchesSearch && matchesCategory
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Hero banner section
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "USP Icon",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "USP Column Classifications (L-Codes)",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Browse official USP L-Codes to review chemistry, pH boundaries, particle limits, and standard industry brands to optimize chromatography methods.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.82f)
                )
            }
        }

        // Live Search Input Box
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .testTag("usp_column_search"),
            placeholder = { Text("Search L-Code (e.g. L1), chemistry, or brand...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search icon") },
            trailingIcon = if (searchQuery.isNotEmpty()) {
                {
                    IconButton(onClick = { searchQuery = "" }) {
                        Icon(Icons.Default.Clear, contentDescription = "Clear search")
                    }
                }
            } else null,
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Horizontal Category Filters List
        ScrollableTabRow(
            selectedTabIndex = categories.indexOf(selectedCategoryFilter).coerceAtLeast(0),
            edgePadding = 16.dp,
            containerColor = Color.Transparent,
            divider = {},
            indicator = {}
        ) {
            categories.forEach { category ->
                val isSelected = selectedCategoryFilter == category
                FilterChip(
                    selected = isSelected,
                    onClick = { selectedCategoryFilter = category },
                    label = { Text(category) },
                    modifier = Modifier.padding(end = 8.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Equivalence Finder Tool Section (Collapsed/Interactive Card)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.45f)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CompareArrows,
                        contentDescription = "Compare",
                        tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "HPLC Column Equivalence Finder",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Select a USP code to find interchangeable commercial alternatives:",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.8f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                
                // Select list of L codes
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    listOf("L1", "L3", "L7", "L10", "L11", "L60").forEach { lcode ->
                        val isSelected = selectedLCodeForEquivalents == lcode
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(8.dp))
                                .background(
                                    if (isSelected) MaterialTheme.colorScheme.secondary
                                    else MaterialTheme.colorScheme.surface
                                )
                                .clickable { selectedLCodeForEquivalents = lcode }
                                .padding(vertical = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = lcode,
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = if (isSelected) MaterialTheme.colorScheme.onSecondary
                                else MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }

                val currentEquivalentColumn = UspColumnData.columns.find { it.code == selectedLCodeForEquivalents }
                if (currentEquivalentColumn != null) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider(color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.1f))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Equivalent Brands for ${currentEquivalentColumn.code} (${currentEquivalentColumn.name}):",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = currentEquivalentColumn.popularBrands.joinToString("   •   "),
                        style = MaterialTheme.typography.bodySmall,
                        fontFamily = FontFamily.Monospace,
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Main List of Columns
        if (filteredColumns.isEmpty()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.SearchOff,
                        contentDescription = "No Results",
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.outline
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "No column matching '$searchQuery' found.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(bottom = 24.dp)
            ) {
                items(filteredColumns) { column ->
                    val isExpanded = expandedColumnCode == column.code
                    
                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 6.dp)
                            .clickable {
                                expandedColumnCode = if (isExpanded) null else column.code
                            },
                        colors = CardDefaults.elevatedCardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            // Row with L-Code Badge and Phase Name
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(MaterialTheme.colorScheme.primaryContainer)
                                        .padding(horizontal = 12.dp, vertical = 6.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = column.code,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Black,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = column.name,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "Class: ${column.packingMaterial.split(" on ").first()}",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                                    )
                                }
                                Icon(
                                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                    contentDescription = "Expand details",
                                    tint = MaterialTheme.colorScheme.outline
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = column.description,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                            )

                            AnimatedVisibility(
                                visible = isExpanded,
                                enter = expandVertically() + fadeIn(),
                                exit = shrinkVertically() + fadeOut()
                            ) {
                                Column {
                                    Spacer(modifier = Modifier.height(12.dp))
                                    Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.4f))
                                    Spacer(modifier = Modifier.height(12.dp))

                                    // Specifications Grid
                                    Text(
                                        text = "Technical Specifications",
                                        style = MaterialTheme.typography.labelLarge,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        SpecItem(
                                            label = "Carbon Load",
                                            value = column.carbonLoadRange,
                                            modifier = Modifier.weight(1f)
                                        )
                                        SpecItem(
                                            label = "pH Limits",
                                            value = column.phRange,
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        SpecItem(
                                            label = "Max Temp",
                                            value = column.maxTemp,
                                            modifier = Modifier.weight(1f)
                                        )
                                        SpecItem(
                                            label = "Particle Sizes",
                                            value = column.particleSizes,
                                            modifier = Modifier.weight(1f)
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(16.dp))

                                    // Applications
                                    Text(
                                        text = "Typical GMP Applications",
                                        style = MaterialTheme.typography.labelLarge,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    column.typicalApplications.forEach { app ->
                                        Row(
                                            verticalAlignment = Alignment.Top,
                                            modifier = Modifier.padding(vertical = 2.dp)
                                        ) {
                                            Text(
                                                text = "•",
                                                modifier = Modifier.width(16.dp),
                                                fontWeight = FontWeight.Bold,
                                                color = MaterialTheme.colorScheme.primary
                                            )
                                            Text(
                                                text = app,
                                                style = MaterialTheme.typography.bodySmall,
                                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                                            )
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(16.dp))

                                    // Popular Brand Equivalents
                                    Text(
                                        text = "Standard Brand Equivalents",
                                        style = MaterialTheme.typography.labelLarge,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.secondary
                                    )
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(
                                        text = column.popularBrands.joinToString(", "),
                                        style = MaterialTheme.typography.bodySmall,
                                        fontFamily = FontFamily.Monospace,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductMonographsView() {
    val isDark = isSystemInDarkTheme()
    
    // USP Red Accent Color (Vibrant pink/red in dark mode, Deep burgundy in light mode)
    val uspColor = if (isDark) Color(0xFFFF8A80) else Color(0xFF800000)
    val cardBgColor = if (isDark) Color(0xFF800000).copy(alpha = 0.15f) else Color(0xFF800000).copy(alpha = 0.05f)
    val searchIconTint = if (isDark) Color(0xFFFF8A80) else Color(0xFF800000)
    
    // Table Theme-Aware Colors
    val tableHeaderBg = if (isDark) Color(0xFF1B5E20) else Color(0xFFE8F5E9)
    val tableHeaderTextColor = if (isDark) Color(0xFFC8E6C9) else Color(0xFF2E7D32)
    val tableRowEvenBg = if (isDark) MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f) else Color.White
    val tableRowOddBg = if (isDark) MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f) else Color(0xFFF9F9F9)
    val tableBorderColor = if (isDark) MaterialTheme.colorScheme.outlineVariant else Color.LightGray
    val lgsCodeLinkColor = if (isDark) Color(0xFF64B5F6) else Color(0xFF1565C0)
    val tableCellTextColor = MaterialTheme.colorScheme.onSurface

    var searchQuery by remember { mutableStateOf("") }
    var expandedMonographIndex by remember { mutableStateOf<Int?>(null) }

    // Filter monographs based on search query
    val filteredMonographs = remember(searchQuery) {
        UspMonographData.monographs.filter { monograph ->
            monograph.productName.contains(searchQuery, ignoreCase = true) ||
                    monograph.activeIngredient.contains(searchQuery, ignoreCase = true) ||
                    monograph.dosageForm.contains(searchQuery, ignoreCase = true) ||
                    monograph.columnsUsed.any { test ->
                        test.brand.contains(searchQuery, ignoreCase = true) ||
                                test.lgsCode.contains(searchQuery, ignoreCase = true) ||
                                test.testType.contains(searchQuery, ignoreCase = true) ||
                                test.comments.contains(searchQuery, ignoreCase = true)
                    }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // USP Search Banner
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = cardBgColor
            ),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, uspColor.copy(alpha = 0.4f))
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // USP-like stylized icon/badge
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(uspColor)
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "USP",
                            color = if (isDark) Color.Black else Color.White,
                            fontWeight = FontWeight.Black,
                            fontSize = 12.sp,
                            fontFamily = FontFamily.Serif
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "USP Product Column Search",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = uspColor
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Search specific active ingredients (e.g., Ibuprofen, Paracetamol) to cross-verify column brands, dimensions, and pharmacopoeial test conditions designated by official USP monographs.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.85f)
                )
            }
        }

        // Live Search Input Box
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .testTag("monograph_search_box"),
            placeholder = { Text("Search by drug name or form (e.g., Ibuprofen, Tablets)...") },
            leadingIcon = { Icon(Icons.Default.Science, contentDescription = "Science Icon", tint = searchIconTint) },
            trailingIcon = if (searchQuery.isNotEmpty()) {
                {
                    IconButton(onClick = { searchQuery = "" }) {
                        Icon(Icons.Default.Clear, contentDescription = "Clear search")
                    }
                }
            } else null,
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = uspColor,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Main List of Monographs
        if (filteredMonographs.isEmpty()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.SearchOff,
                        contentDescription = "No Results",
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.outline
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "No monograph matching '$searchQuery' found.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(bottom = 24.dp)
            ) {
                items(filteredMonographs) { monograph ->
                    val index = UspMonographData.monographs.indexOf(monograph)
                    val isExpanded = expandedMonographIndex == index || filteredMonographs.size == 1

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .clickable {
                                expandedMonographIndex = if (expandedMonographIndex == index) null else index
                            },
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
                    ) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            // Monograph Header
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(uspColor.copy(alpha = 0.08f))
                                    .padding(horizontal = 14.dp, vertical = 12.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = monograph.productName,
                                            style = MaterialTheme.typography.titleSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = uspColor,
                                            lineHeight = 18.sp
                                        )
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(top = 2.dp)
                                        ) {
                                            SuggestionChip(
                                                onClick = { },
                                                label = { Text(monograph.dosageForm, fontSize = 10.sp) },
                                                modifier = Modifier.height(20.dp)
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text(
                                                text = "Active: ${monograph.activeIngredient}",
                                                style = MaterialTheme.typography.bodySmall,
                                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                                                fontWeight = FontWeight.Medium
                                            )
                                        }
                                    }
                                    Icon(
                                        imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                        contentDescription = "Expand",
                                        tint = uspColor
                                    )
                                }
                            }

                            // Table Content with Animation
                            AnimatedVisibility(
                                visible = isExpanded,
                                enter = expandVertically() + fadeIn(),
                                exit = shrinkVertically() + fadeOut()
                            ) {
                                Column(modifier = Modifier.padding(10.dp)) {
                                    // Scrollable horizontal grid table to look exactly like the web screenshot!
                                    val scrollState = rememberScrollState()
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .border(1.dp, tableBorderColor)
                                            .horizontalScroll(scrollState)
                                    ) {
                                        // Table Header
                                        Row(
                                            modifier = Modifier
                                                .background(tableHeaderBg) // Light/Dark Green tint exactly like screenshot!
                                                .padding(vertical = 8.dp)
                                        ) {
                                            TableHeaderCell("PF", width = 70.dp, textColor = tableHeaderTextColor)
                                            TableHeaderCell("LGS#", width = 70.dp, textColor = tableHeaderTextColor)
                                            TableHeaderCell("Column Brand", width = 160.dp, textColor = tableHeaderTextColor)
                                            TableHeaderCell("Type Of Test", width = 180.dp, textColor = tableHeaderTextColor)
                                            TableHeaderCell("Comments", width = 280.dp, textColor = tableHeaderTextColor)
                                        }

                                        Divider(color = tableBorderColor)

                                        // Table Rows
                                        monograph.columnsUsed.forEachIndexed { rowIndex, rowData ->
                                            val bg = if (rowIndex % 2 == 0) tableRowEvenBg else tableRowOddBg
                                            Row(
                                                modifier = Modifier
                                                    .background(bg)
                                                    .padding(vertical = 8.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                TableCell(rowData.pf, width = 70.dp, textColor = tableCellTextColor)
                                                // Make LGS Code highly visible and bold
                                                Box(
                                                    modifier = Modifier
                                                        .width(70.dp)
                                                        .padding(horizontal = 4.dp),
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    Text(
                                                        text = rowData.lgsCode,
                                                        fontWeight = FontWeight.Bold,
                                                        color = lgsCodeLinkColor, // Hyperlink blue
                                                        style = MaterialTheme.typography.bodySmall,
                                                        textAlign = TextAlign.Center
                                                    )
                                                }
                                                TableCell(rowData.brand, width = 160.dp, textColor = tableCellTextColor, isBold = rowData.brand != "None Cited")
                                                TableCell(rowData.testType, width = 180.dp, textColor = tableCellTextColor)
                                                TableCell(rowData.comments, width = 280.dp, textColor = tableCellTextColor)
                                            }
                                            if (rowIndex < monograph.columnsUsed.size - 1) {
                                                Divider(color = tableBorderColor.copy(alpha = 0.5f))
                                            }
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "* Scroll horizontally to view complete columns of the USP database grid.",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                                        modifier = Modifier.padding(start = 4.dp, top = 4.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TableHeaderCell(
    text: String,
    width: androidx.compose.ui.unit.Dp = 100.dp,
    textColor: Color = MaterialTheme.colorScheme.onSecondaryContainer
) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium,
        fontWeight = FontWeight.Black,
        color = textColor,
        modifier = Modifier
            .width(width)
            .padding(horizontal = 8.dp),
        textAlign = TextAlign.Left,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun TableCell(
    text: String,
    width: androidx.compose.ui.unit.Dp = 100.dp,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    isBold: Boolean = false
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall,
        fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal,
        color = textColor,
        modifier = Modifier
            .width(width)
            .padding(horizontal = 8.dp),
        textAlign = TextAlign.Left
    )
}

@Composable
fun SpecItem(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

private fun parseMonographs(text: String): List<UserMonographEntity> {
    val trimmed = text.trim()
    if (trimmed.isEmpty()) return emptyList()

    if (trimmed.startsWith("[") || trimmed.startsWith("{")) {
        // Parse as JSON!
        try {
            val list = mutableListOf<UserMonographEntity>()
            if (trimmed.startsWith("[")) {
                val array = JSONArray(trimmed)
                for (i in 0 until array.length()) {
                    val obj = array.getJSONObject(i)
                    parseJsonObject(obj, list)
                }
            } else {
                val obj = JSONObject(trimmed)
                parseJsonObject(obj, list)
            }
            return list
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    
    // Otherwise, try parsing as CSV!
    try {
        val list = mutableListOf<UserMonographEntity>()
        val lines = trimmed.split("\n")
        var isHeader = true
        for (line in lines) {
            val trimmedLine = line.trim()
            if (trimmedLine.isEmpty()) continue
            
            // Check if it's a header line
            if (isHeader && (trimmedLine.contains("productName", ignoreCase = true) || trimmedLine.contains("activeIngredient", ignoreCase = true))) {
                isHeader = false
                continue
            }
            isHeader = false
            
            // Split CSV line correctly supporting potential quotes or just commas/pipes
            val delimiter = if (trimmedLine.contains("|")) "|" else ","
            val parts = if (delimiter == "|") {
                trimmedLine.split("|")
            } else {
                splitCsvLine(trimmedLine)
            }
            
            if (parts.size >= 3) {
                val productName = parts.getOrNull(0)?.trim() ?: ""
                val activeIngredient = parts.getOrNull(1)?.trim() ?: ""
                val dosageForm = parts.getOrNull(2)?.trim() ?: ""
                val pf = parts.getOrNull(3)?.trim() ?: "48(1)"
                val lgsCode = parts.getOrNull(4)?.trim() ?: "L1"
                val brand = parts.getOrNull(5)?.trim() ?: "Phenomenex Luna C18"
                val testType = parts.getOrNull(6)?.trim() ?: "Assay"
                val comments = parts.getOrNull(7)?.trim() ?: ""
                
                if (productName.isNotEmpty()) {
                    list.add(
                        UserMonographEntity(
                            productName = productName.uppercase().trim(),
                            activeIngredient = activeIngredient.trim(),
                            dosageForm = dosageForm.trim(),
                            pf = pf.trim(),
                            lgsCode = lgsCode.uppercase().trim(),
                            brand = brand.trim(),
                            testType = testType.trim(),
                            comments = comments.trim()
                        )
                    )
                }
            }
        }
        return list
    } catch (e: Exception) {
        e.printStackTrace()
    }
    
    return emptyList()
}

private fun parseJsonObject(obj: JSONObject, list: MutableList<UserMonographEntity>) {
    val productName = obj.optString("productName").ifEmpty { obj.optString("product_name").ifEmpty { "" } }
    val activeIngredient = obj.optString("activeIngredient").ifEmpty { obj.optString("active_ingredient").ifEmpty { "" } }
    val dosageForm = obj.optString("dosageForm").ifEmpty { obj.optString("dosage_form").ifEmpty { "" } }
    
    if (productName.isBlank()) return
    
    if (obj.has("columnsUsed") || obj.has("columns_used") || obj.has("columns")) {
        val colsArray = obj.optJSONArray("columnsUsed") ?: obj.optJSONArray("columns_used") ?: obj.optJSONArray("columns")
        if (colsArray != null) {
            for (j in 0 until colsArray.length()) {
                val colObj = colsArray.getJSONObject(j)
                list.add(
                    UserMonographEntity(
                        productName = productName.uppercase().trim(),
                        activeIngredient = activeIngredient.trim(),
                        dosageForm = dosageForm.trim(),
                        pf = colObj.optString("pf", "48(1)"),
                        lgsCode = colObj.optString("lgsCode", colObj.optString("lgs_code", "L1")),
                        brand = colObj.optString("brand", "Phenomenex Luna C18"),
                        testType = colObj.optString("testType", colObj.optString("test_type", "Assay")),
                        comments = colObj.optString("comments", "")
                    )
                )
            }
        }
    } else {
        // Flat format
        list.add(
            UserMonographEntity(
                productName = productName.uppercase().trim(),
                activeIngredient = activeIngredient.trim(),
                dosageForm = dosageForm.trim(),
                pf = obj.optString("pf", "48(1)"),
                lgsCode = obj.optString("lgsCode", obj.optString("lgs_code", "L1")),
                brand = obj.optString("brand", "Phenomenex Luna C18"),
                testType = obj.optString("testType", obj.optString("test_type", "Assay")),
                comments = obj.optString("comments", "")
            )
        )
    }
}

private fun splitCsvLine(line: String): List<String> {
    val result = mutableListOf<String>()
    var curVal = StringBuilder()
    var inQuotes = false
    for (ch in line.toCharArray()) {
        if (ch == '\"') {
            inQuotes = !inQuotes
        } else if (ch == ',') {
            if (inQuotes) {
                curVal.append(ch)
            } else {
                result.add(curVal.toString())
                curVal = StringBuilder()
            }
        } else {
            curVal.append(ch)
        }
    }
    result.add(curVal.toString())
    return result
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UspMonographsTabView(
    viewModel: SopViewModel
) {
    val isDark = isSystemInDarkTheme()
    val uspColor = if (isDark) Color(0xFFFF8A80) else Color(0xFF800000)
    val cardBgColor = if (isDark) Color(0xFF800000).copy(alpha = 0.15f) else Color(0xFF800000).copy(alpha = 0.05f)
    val searchIconTint = if (isDark) Color(0xFFFF8A80) else Color(0xFF800000)
    val tableHeaderBg = if (isDark) Color(0xFF1B5E20) else Color(0xFFE8F5E9)
    val tableHeaderTextColor = if (isDark) Color(0xFFC8E6C9) else Color(0xFF2E7D32)
    val tableRowEvenBg = if (isDark) MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f) else Color.White
    val tableRowOddBg = if (isDark) MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f) else Color(0xFFF9F9F9)
    val tableBorderColor = if (isDark) MaterialTheme.colorScheme.outlineVariant else Color.LightGray
    val lgsCodeLinkColor = if (isDark) Color(0xFF64B5F6) else Color(0xFF1565C0)
    val tableCellTextColor = MaterialTheme.colorScheme.onSurface

    val userMonographs by viewModel.userMonographs.collectAsState()

    var searchQuery by remember { mutableStateOf("") }
    var showUploadForm by remember { mutableStateOf(false) }
    var uploadModeTab by remember { mutableStateOf(0) } // 0 = File upload, 1 = Paste Text
    var pasteInputText by remember { mutableStateOf("") }
    var showFormatInstructions by remember { mutableStateOf(false) }
    var importStatusMessage by remember { mutableStateOf("") }
    var importStatusIsError by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            try {
                val contentResolver = context.contentResolver
                val inputStream = contentResolver.openInputStream(it)
                val text = inputStream?.bufferedReader()?.use { reader -> reader.readText() }
                if (text != null) {
                    val parsed = parseMonographs(text)
                    if (parsed.isNotEmpty()) {
                        viewModel.insertUserMonographs(parsed) {
                            importStatusMessage = "Successfully imported ${parsed.size} monograph entries!"
                            importStatusIsError = false
                        }
                    } else {
                        importStatusMessage = "Error: No monographs found or invalid format. Please check instructions."
                        importStatusIsError = true
                    }
                } else {
                    importStatusMessage = "Error: Failed to read file content."
                    importStatusIsError = true
                }
            } catch (e: Exception) {
                importStatusMessage = "Error parsing file: ${e.localizedMessage}"
                importStatusIsError = true
            }
        }
    }

    // Expand states
    var expandedIndex by remember { mutableStateOf<Int?>(null) }

    val combinedMonographs = remember(userMonographs, searchQuery) {
        val list = mutableListOf<UspProductMonograph>()
        list.addAll(UspMonographData.monographs)

        val groupedUser = userMonographs.groupBy { it.productName.uppercase().trim() }
        groupedUser.forEach { (prodName, entities) ->
            val cols = entities.map { ent ->
                MonographTestColumn(
                    pf = ent.pf,
                    lgsCode = ent.lgsCode,
                    brand = ent.brand,
                    testType = ent.testType,
                    comments = ent.comments
                )
            }
            val existingIndex = list.indexOfFirst { it.productName.uppercase().trim() == prodName }
            if (existingIndex != -1) {
                val existing = list[existingIndex]
                list[existingIndex] = existing.copy(columnsUsed = existing.columnsUsed + cols)
            } else {
                list.add(
                    UspProductMonograph(
                        productName = prodName,
                        activeIngredient = entities.first().activeIngredient,
                        dosageForm = entities.first().dosageForm,
                        columnsUsed = cols
                    )
                )
            }
        }

        list.filter { mono ->
            mono.productName.contains(searchQuery, ignoreCase = true) ||
            mono.activeIngredient.contains(searchQuery, ignoreCase = true) ||
            mono.dosageForm.contains(searchQuery, ignoreCase = true) ||
            mono.columnsUsed.any { col ->
                col.brand.contains(searchQuery, ignoreCase = true) ||
                col.lgsCode.contains(searchQuery, ignoreCase = true) ||
                col.testType.contains(searchQuery, ignoreCase = true) ||
                col.comments.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        // Hero Card
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(containerColor = cardBgColor),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, uspColor.copy(alpha = 0.4f))
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(uspColor)
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = "USP",
                                color = if (isDark) Color.Black else Color.White,
                                fontWeight = FontWeight.Black,
                                fontSize = 12.sp,
                                fontFamily = FontFamily.Serif
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "USP Monograph Explorer",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = uspColor
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Search official USP 48 – NF 43 monographs (covering letters A to E, from Abacavir to Ezetimibe) or import/upload complete monograph database files (JSON/CSV) persistently.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.85f)
                    )
                }
            }
        }

        // Toggle Upload Form Button
        item {
            ElevatedButton(
                onClick = { showUploadForm = !showUploadForm },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .testTag("toggle_upload_form_button"),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = if (showUploadForm) MaterialTheme.colorScheme.surfaceVariant else uspColor,
                    contentColor = if (showUploadForm) MaterialTheme.colorScheme.onSurfaceVariant else if (isDark) Color.Black else Color.White
                )
            ) {
                Icon(
                    imageVector = if (showUploadForm) Icons.Default.Close else Icons.Default.Upload,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (showUploadForm) "Close Import Panel" else "Import / Upload Complete Monographs",
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        // Upload Form Card (Animated expand)
        item {
            AnimatedVisibility(
                visible = showUploadForm,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Import Complete Monographs",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = uspColor
                            )
                            IconButton(onClick = { showFormatInstructions = !showFormatInstructions }) {
                                Icon(
                                    imageVector = if (showFormatInstructions) Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown,
                                    contentDescription = "Format Guide",
                                    tint = uspColor
                                )
                            }
                        }

                        // Collapsible Formatting Guidelines
                        AnimatedVisibility(visible = showFormatInstructions) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp)
                                    .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                                    .padding(10.dp)
                            ) {
                                Text(
                                    text = "Supported Formats Guide",
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "JSON Format Example:",
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    text = "[\n  {\n    \"productName\": \"Ibuprofen Tablets\",\n    \"activeIngredient\": \"Ibuprofen\",\n    \"dosageForm\": \"Tablets\",\n    \"pf\": \"48(1)\",\n    \"lgsCode\": \"L1\",\n    \"brand\": \"Luna C18\",\n    \"testType\": \"Assay\",\n    \"comments\": \"4.6x150\"\n  }\n]",
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 10.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "CSV / Pipe-Delimited Format Example (First row can be headers):",
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    text = "productName,activeIngredient,dosageForm,pf,lgsCode,brand,testType,comments\nIbuprofen Tablets,Ibuprofen,Tablets,48(1),L1,Luna C18,Assay,4.6x150",
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 10.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Sub-Tabs for File Picker vs Text Paste
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Button(
                                onClick = { uploadModeTab = 0 },
                                modifier = Modifier.weight(1f),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (uploadModeTab == 0) uspColor else MaterialTheme.colorScheme.surfaceVariant,
                                    contentColor = if (uploadModeTab == 0) (if (isDark) Color.Black else Color.White) else MaterialTheme.colorScheme.onSurfaceVariant
                                ),
                                shape = RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
                            ) {
                                Text("Upload File", fontSize = 12.sp)
                            }
                            Button(
                                onClick = { uploadModeTab = 1 },
                                modifier = Modifier.weight(1f),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (uploadModeTab == 1) uspColor else MaterialTheme.colorScheme.surfaceVariant,
                                    contentColor = if (uploadModeTab == 1) (if (isDark) Color.Black else Color.White) else MaterialTheme.colorScheme.onSurfaceVariant
                                ),
                                shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                            ) {
                                Text("Paste Text", fontSize = 12.sp)
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        if (uploadModeTab == 0) {
                            // File Upload View
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { filePickerLauncher.launch("*/*") },
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.15f)),
                                border = BorderStroke(1.5.dp, uspColor.copy(alpha = 0.5f)),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(24.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.InsertDriveFile,
                                        contentDescription = "Select File",
                                        tint = uspColor,
                                        modifier = Modifier.size(40.dp)
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "Browse & Select JSON or CSV File",
                                        fontWeight = FontWeight.Bold,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "Tap to pick a file containing complete monographs.",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        } else {
                            // Paste Text View
                            OutlinedTextField(
                                value = pasteInputText,
                                onValueChange = { pasteInputText = it },
                                label = { Text("Paste JSON Array or CSV lines here") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp)
                                    .testTag("paste_monographs_field"),
                                placeholder = { Text("Paste monograph database details...") },
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = uspColor,
                                    unfocusedBorderColor = MaterialTheme.colorScheme.outline
                                ),
                                maxLines = 10
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(
                                onClick = {
                                    if (pasteInputText.isBlank()) {
                                        importStatusMessage = "Error: Text field is empty."
                                        importStatusIsError = true
                                    } else {
                                        val parsed = parseMonographs(pasteInputText)
                                        if (parsed.isNotEmpty()) {
                                            viewModel.insertUserMonographs(parsed) {
                                                importStatusMessage = "Successfully imported ${parsed.size} monograph entries!"
                                                importStatusIsError = false
                                                pasteInputText = ""
                                            }
                                        } else {
                                            importStatusMessage = "Error: Invalid format or no valid monographs found."
                                            importStatusIsError = true
                                        }
                                    }
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("import_pasted_button"),
                                colors = ButtonDefaults.buttonColors(containerColor = uspColor)
                            ) {
                                Text("Parse & Import", color = if (isDark) Color.Black else Color.White)
                            }
                        }

                        // Display status message if any
                        if (importStatusMessage.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(
                                        if (importStatusIsError) MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.2f)
                                        else Color(0xFF2E7D32).copy(alpha = 0.1f),
                                        RoundedCornerShape(6.dp)
                                    )
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = if (importStatusIsError) Icons.Default.Error else Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    tint = if (importStatusIsError) MaterialTheme.colorScheme.error else Color(0xFF2E7D32)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = importStatusMessage,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold,
                                    color = if (importStatusIsError) MaterialTheme.colorScheme.error else Color(0xFF2E7D32)
                                )
                            }
                        }
                    }
                }
            }
        }

        // Search Bar
        item {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .testTag("usp_tab_search_box"),
                placeholder = { Text("Search USP 48 - NF 43 monographs...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = searchIconTint) },
                trailingIcon = if (searchQuery.isNotEmpty()) {
                    {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(Icons.Default.Clear, contentDescription = null)
                        }
                    }
                } else null,
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = uspColor,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline
                )
            )
        }

        // Combined Search Results header
        item {
            Text(
                text = "Monographs Found: ${combinedMonographs.size}",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
            )
        }

        if (combinedMonographs.isEmpty()) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.SearchOff,
                        contentDescription = "Not Found",
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "No monographs found matching '$searchQuery'",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f),
                        textAlign = TextAlign.Center
                    )
                }
            }
        } else {
            items(combinedMonographs.size) { index ->
                val monograph = combinedMonographs[index]
                val isExpanded = expandedIndex == index

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 6.dp)
                        .clickable { expandedIndex = if (isExpanded) null else index },
                    shape = RoundedCornerShape(10.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(uspColor.copy(alpha = 0.08f))
                                .padding(horizontal = 14.dp, vertical = 12.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = monograph.productName,
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = uspColor,
                                        lineHeight = 18.sp
                                    )
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.padding(top = 2.dp)
                                    ) {
                                        SuggestionChip(
                                            onClick = { },
                                            label = { Text(monograph.dosageForm, fontSize = 10.sp) },
                                            modifier = Modifier.height(20.dp)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = "Active: ${monograph.activeIngredient}",
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                                            fontWeight = FontWeight.Medium
                                        )
                                    }
                                }
                                Icon(
                                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                    contentDescription = null,
                                    tint = uspColor
                                )
                            }
                        }

                        AnimatedVisibility(
                            visible = isExpanded,
                            enter = expandVertically() + fadeIn(),
                            exit = shrinkVertically() + fadeOut()
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                val scrollState = rememberScrollState()
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .border(1.dp, tableBorderColor)
                                        .horizontalScroll(scrollState)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .background(tableHeaderBg)
                                            .padding(vertical = 8.dp)
                                    ) {
                                        TableHeaderCell("PF", width = 70.dp, textColor = tableHeaderTextColor)
                                        TableHeaderCell("LGS#", width = 70.dp, textColor = tableHeaderTextColor)
                                        TableHeaderCell("Column Brand", width = 160.dp, textColor = tableHeaderTextColor)
                                        TableHeaderCell("Type Of Test", width = 180.dp, textColor = tableHeaderTextColor)
                                        TableHeaderCell("Comments", width = 280.dp, textColor = tableHeaderTextColor)
                                    }

                                    Divider(color = tableBorderColor)

                                    monograph.columnsUsed.forEachIndexed { rowIndex, rowData ->
                                        val bg = if (rowIndex % 2 == 0) tableRowEvenBg else tableRowOddBg
                                        Row(
                                            modifier = Modifier
                                                .background(bg)
                                                .padding(vertical = 8.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            TableCell(rowData.pf, width = 70.dp, textColor = tableCellTextColor)
                                            Box(
                                                modifier = Modifier
                                                    .width(70.dp)
                                                    .padding(horizontal = 4.dp),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(
                                                    text = rowData.lgsCode,
                                                    fontWeight = FontWeight.Bold,
                                                    color = lgsCodeLinkColor,
                                                    style = MaterialTheme.typography.bodySmall,
                                                    textAlign = TextAlign.Center
                                                )
                                            }
                                            TableCell(rowData.brand, width = 160.dp, textColor = tableCellTextColor, isBold = rowData.brand != "None Cited")
                                            TableCell(rowData.testType, width = 180.dp, textColor = tableCellTextColor)
                                            TableCell(rowData.comments, width = 280.dp, textColor = tableCellTextColor)
                                        }
                                        if (rowIndex < monograph.columnsUsed.size - 1) {
                                            Divider(color = tableBorderColor.copy(alpha = 0.5f))
                                        }
                                    }
                                }

                                // Delete user-uploaded individual columns if any match user-uploaded items
                                val customMatches = userMonographs.filter { 
                                    it.productName.uppercase().trim() == monograph.productName.uppercase().trim() 
                                }
                                if (customMatches.isNotEmpty()) {
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "Custom Uploaded Columns:",
                                        style = MaterialTheme.typography.labelMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = uspColor
                                    )
                                    customMatches.forEach { customCol ->
                                        Card(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(vertical = 4.dp),
                                            colors = CardDefaults.cardColors(
                                                containerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.1f)
                                            ),
                                            border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.error.copy(alpha = 0.3f))
                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(8.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text(
                                                        text = "PF: ${customCol.pf} | LGS: ${customCol.lgsCode} | Brand: ${customCol.brand}",
                                                        style = MaterialTheme.typography.bodySmall,
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                    Text(
                                                        text = "Test: ${customCol.testType} | Comments: ${customCol.comments}",
                                                        style = MaterialTheme.typography.labelSmall,
                                                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                                                    )
                                                }
                                                IconButton(
                                                    onClick = { viewModel.deleteUserMonograph(customCol.id) }
                                                ) {
                                                    Icon(
                                                        imageVector = Icons.Default.Delete,
                                                        contentDescription = "Delete column",
                                                        tint = MaterialTheme.colorScheme.error
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

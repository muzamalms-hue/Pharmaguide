package com.example.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.components.SopDetailView
import com.example.ui.components.SopFilterSidebar
import com.example.ui.components.SopList
import com.example.ui.components.SopHomeDashboard
import com.example.ui.components.PharmaAskSection
import com.example.ui.components.PharmaVideosSection
import com.example.ui.components.PharmaCalculatorsSection
import com.example.ui.components.PharmaContactSection
import com.example.ui.components.UspColumnDatabaseScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SopDashboard(
    viewModel: SopViewModel,
    modifier: Modifier = Modifier
) {
    val selectedSopId by viewModel.selectedSopId.collectAsState()
    val currentCategory by viewModel.currentCategory.collectAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val width = maxWidth

        if (width > 850.dp) {
            // Expanded / Landscape Tablet Layout: Permanent Sidebar + List + Detail side-by-side
            Row(modifier = Modifier.fillMaxSize()) {
                // Permanent Sidebar Left (Dark-themed website menu)
                SopFilterSidebar(
                    viewModel = viewModel,
                    modifier = Modifier
                        .width(300.dp)
                        .fillMaxHeight()
                        .shadow(1.dp)
                )

                // Divider line
                Spacer(
                    modifier = Modifier
                        .width(1.dp)
                        .fillMaxHeight()
                        .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f))
                )

                // Multi-pane content depending on state
                Row(modifier = Modifier.weight(1f).fillMaxHeight()) {
                    // Center Content block: List or Special Screen
                    Box(
                        modifier = Modifier
                            .width(380.dp)
                            .fillMaxHeight()
                    ) {
                        MainContentPanel(
                            viewModel = viewModel,
                            currentCategory = currentCategory,
                            onSopClick = { viewModel.selectSop(it.id) },
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    // Divider line
                    Spacer(
                        modifier = Modifier
                            .width(1.dp)
                            .fillMaxHeight()
                            .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f))
                )

                    // SOP Detail Right Pane
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    ) {
                        SopDetailView(viewModel = viewModel)
                    }
                }
            }
        } else if (width > 600.dp) {
            // Medium screen (smaller tablet/foldable): Sidebar + Main content split
            Row(modifier = Modifier.fillMaxSize()) {
                SopFilterSidebar(
                    viewModel = viewModel,
                    modifier = Modifier
                        .width(260.dp)
                        .fillMaxHeight()
                        .shadow(1.dp)
                )

                Spacer(
                    modifier = Modifier
                        .width(1.dp)
                        .fillMaxHeight()
                        .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f))
                )

                // Multi-state main panel depending on if an SOP is active
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    if (selectedSopId == null) {
                        MainContentPanel(
                            viewModel = viewModel,
                            currentCategory = currentCategory,
                            onSopClick = { viewModel.selectSop(it.id) },
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        SopDetailView(
                            viewModel = viewModel,
                            onBackClick = { viewModel.selectSop(null) }
                        )
                    }
                }
            }
        } else {
            // Compact screen (Mobile): Single panel with sliding drawer for filters
            ModalNavigationDrawer(
                drawerState = drawerState,
                gesturesEnabled = true,
                drawerContent = {
                    ModalDrawerSheet(
                        drawerContainerColor = Color(0xFF1E1E24), // Dark background matching sidebar
                        modifier = Modifier.width(300.dp)
                    ) {
                        SopFilterSidebar(
                            viewModel = viewModel,
                            onCloseSidebar = { scope.launch { drawerState.close() } }
                        )
                    }
                },
                modifier = Modifier.testTag("mobile_navigation_drawer")
            ) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .size(30.dp)
                                            .background(Color(0xFF2E7D32), androidx.compose.foundation.shape.CircleShape)
                                            .border(2.dp, Color(0xFFFFB300), androidx.compose.foundation.shape.CircleShape),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "+",
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 15.sp
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = if (selectedSopId != null) "SOP Reader" else currentCategory.displayName,
                                        fontWeight = FontWeight.Bold,
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                }
                            },
                            navigationIcon = {
                                if (selectedSopId != null) {
                                    IconButton(onClick = { viewModel.selectSop(null) }) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                            contentDescription = "Back to List"
                                        )
                                    }
                                } else if (currentCategory != MenuCategory.HOME) {
                                    IconButton(onClick = { viewModel.selectCategory(MenuCategory.HOME) }) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                            contentDescription = "Back to Home"
                                        )
                                    }
                                } else {
                                    IconButton(
                                        onClick = { scope.launch { drawerState.open() } },
                                        modifier = Modifier.testTag("hamburger_menu_button")
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Menu,
                                            contentDescription = "Open Menu"
                                        )
                                    }
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.surface,
                                titleContentColor = MaterialTheme.colorScheme.onSurface
                            ),
                            modifier = Modifier.shadow(1.dp)
                        )
                    },
                    floatingActionButton = {
                        // Floating action button to open drawer if home/list is visible on mobile
                        if (selectedSopId == null && currentCategory == MenuCategory.HOME) {
                            FloatingActionButton(
                                onClick = { scope.launch { drawerState.open() } },
                                containerColor = Color(0xFF2E7D32),
                                contentColor = Color.White,
                                modifier = Modifier.testTag("floating_filter_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Open Sidebar"
                                )
                            }
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        if (selectedSopId == null) {
                            MainContentPanel(
                                viewModel = viewModel,
                                currentCategory = currentCategory,
                                onSopClick = { viewModel.selectSop(it.id) },
                                modifier = Modifier.fillMaxSize()
                            )
                        } else {
                            SopDetailView(
                                viewModel = viewModel,
                                onBackClick = { viewModel.selectSop(null) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainContentPanel(
    viewModel: SopViewModel,
    currentCategory: MenuCategory,
    onSopClick: (com.example.data.SopEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    when (currentCategory) {
        MenuCategory.HOME -> {
            SopHomeDashboard(
                viewModel = viewModel,
                onSopClick = onSopClick,
                modifier = modifier
            )
        }
        MenuCategory.ASK -> {
            PharmaAskSection(
                viewModel = viewModel,
                modifier = modifier
            )
        }
        MenuCategory.VIDEOS -> {
            PharmaVideosSection(
                viewModel = viewModel,
                modifier = modifier
            )
        }
        MenuCategory.CALCULATORS -> {
            PharmaCalculatorsSection(
                viewModel = viewModel,
                modifier = modifier
            )
        }
        MenuCategory.USP_COLUMNS -> {
            UspColumnDatabaseScreen(
                viewModel = viewModel,
                modifier = modifier
            )
        }
        MenuCategory.CONTACT -> {
            PharmaContactSection(
                viewModel = viewModel,
                modifier = modifier
            )
        }
        else -> {
            SopList(
                viewModel = viewModel,
                onSopClick = onSopClick,
                modifier = modifier
            )
        }
    }
}

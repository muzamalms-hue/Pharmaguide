package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.SopEntity
import com.example.ui.MenuCategory
import com.example.ui.SopViewModel

data class CategoryGridItem(
    val category: MenuCategory,
    val label: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val color: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SopHomeDashboard(
    viewModel: SopViewModel,
    onSopClick: (SopEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val sops by viewModel.sops.collectAsState()
    val scope = rememberCoroutineScope()

    val categories = listOf(
        CategoryGridItem(MenuCategory.QUALITY_CONTROL, "Quality Control", Icons.Default.Science, Color(0xFF2E7D32)),
        CategoryGridItem(MenuCategory.QUALITY_ASSURANCE, "Quality Assurance", Icons.Default.AssignmentTurnedIn, Color(0xFF1976D2)),
        CategoryGridItem(MenuCategory.MICROBIOLOGY, "Microbiology", Icons.Default.DeviceHub, Color(0xFF7B1FA2)),
        CategoryGridItem(MenuCategory.PRODUCTION, "Production", Icons.Default.Build, Color(0xFFE65100)),
        CategoryGridItem(MenuCategory.SOPS, "SOPs List", Icons.Default.List, Color(0xFF00796B)),
        CategoryGridItem(MenuCategory.VALIDATION, "Validation", Icons.Default.CheckCircle, Color(0xFF0097A7)),
        CategoryGridItem(MenuCategory.GMP, "GMP Guide", Icons.Default.Lock, Color(0xFF455A64)),
        CategoryGridItem(MenuCategory.AUDIT, "Audits", Icons.Default.Assessment, Color(0xFF303F9F)),
        CategoryGridItem(MenuCategory.USP_COLUMNS, "USP", Icons.Default.ViewColumn, Color(0xFF5D4037)),
        CategoryGridItem(MenuCategory.VIDEOS, "SOP Videos", Icons.Default.PlayCircle, Color(0xFFC62828)),
        CategoryGridItem(MenuCategory.CALCULATORS, "Calculators", Icons.Default.Calculate, Color(0xFFF57F17)),
        CategoryGridItem(MenuCategory.CONTACT, "Contact Us", Icons.Default.Phone, Color(0xFF00ACC1))
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 1. HERO BANNER
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.linearGradient(
                                colors = listOf(Color(0xFF1B5E20), Color(0xFF388E3C))
                            )
                        )
                        .padding(16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column {
                        Surface(
                            color = Color(0xFFFFD54F),
                            shape = RoundedCornerShape(4.dp),
                            modifier = Modifier.padding(bottom = 6.dp)
                        ) {
                            Text(
                                "CGMP REGULATORY RESOURCE",
                                color = Color.Black,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                        Text(
                            text = "Pharmaceutical Guidelines & SOPs",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "Access standard procedures, validation templates & regulatory checkers.",
                            color = Color.White.copy(alpha = 0.85f),
                            fontSize = 11.sp,
                            lineHeight = 15.sp
                        )
                    }
                }
            }
        }

        // REAL-TIME SEARCH BAR
        item {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { viewModel.setSearchQuery(it) },
                placeholder = { Text("Search SOPs, codes, procedures...", fontSize = 14.sp) },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("home_search_bar"),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search icon",
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { viewModel.setSearchQuery("") }) {
                            Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")
                        }
                    }
                },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant,
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface
                ),
                shape = RoundedCornerShape(12.dp)
            )
        }

        // 2. GRID TITLE & 12 CATEGORIES GRID (Only shown when not searching)
        if (searchQuery.isEmpty()) {
            item {
                Text(
                    text = "Explore Departments & Services",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            item {
                // Jetpack Compose Column chunk to render a 3x4 layout for the grid
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val chunked = categories.chunked(3)
                    chunked.forEach { rowItems ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            rowItems.forEach { item ->
                                Card(
                                    shape = RoundedCornerShape(12.dp),
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.06f)),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.surface
                                    ),
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(96.dp)
                                        .clickable { viewModel.selectCategory(item.category) }
                                        .testTag("home_category_button_${item.category.name}"),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(8.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(36.dp)
                                                .background(item.color.copy(alpha = 0.12f), CircleShape),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(
                                                imageVector = item.icon,
                                                contentDescription = item.label,
                                                tint = item.color,
                                                modifier = Modifier.size(20.dp)
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Text(
                                            text = item.label,
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 11.sp,
                                            textAlign = TextAlign.Center,
                                            maxLines = 1,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // 4. LATEST GUIDELINES / SEARCH RESULTS
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (searchQuery.isNotEmpty()) "Search Results for \"$searchQuery\"" else "Latest Regulatory Updates",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.weight(1f).padding(end = 8.dp)
                )
                if (searchQuery.isNotEmpty()) {
                    Text(
                        text = "${sops.size} found",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        if (sops.isEmpty()) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp).fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(imageVector = Icons.Default.Info, contentDescription = null, tint = Color.Gray)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text("No matching guidelines or SOPs found.", fontSize = 12.sp, color = Color.Gray)
                    }
                }
            }
        } else {
            val displayList = if (searchQuery.isNotEmpty()) sops else sops.take(4) // Show all search results or top 4 updates
            items(displayList) { sop ->
                Card(
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f)),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSopClick(sop) }
                        .testTag("home_sop_item_${sop.id}"),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .background(Color(0xFF2E7D32).copy(alpha = 0.1f), RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = sop.code.takeLast(3),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF2E7D32)
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = sop.department,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = sop.title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                maxLines = 1
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Code: ${sop.code} | Effective: ${sop.effectiveDate}",
                                fontSize = 11.sp,
                                color = Color.Gray
                              )
                        }
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "Open",
                            tint = Color.LightGray
                        )
                    }
                }
            }
        }

        // 5. DISCOUNT PROMO BANNER (Pharmaguideline Calculators Promo - Only shown when not searching)
        if (searchQuery.isEmpty()) {
            item {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp)
                        .clickable { viewModel.selectCategory(MenuCategory.CALCULATORS) }
                        .testTag("home_promo_banner")
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(Color(0xFFD84315), Color(0xFFFF8F00))
                                )
                            )
                            .padding(12.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Pharma Compliance Calculators",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Molarity, dilutions, ESD ignition safety, HPLC column compliance & flow scaling.",
                                    color = Color.White.copy(alpha = 0.9f),
                                    fontSize = 10.sp,
                                    lineHeight = 13.sp
                                )
                            }
                            Surface(
                                color = Color.White,
                                shape = RoundedCornerShape(20.dp)
                            ) {
                                Text(
                                    text = "Open Tools",
                                    color = Color(0xFFD84315),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

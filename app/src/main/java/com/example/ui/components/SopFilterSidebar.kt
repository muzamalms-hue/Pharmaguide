package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.MenuCategory
import com.example.ui.SopViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SopFilterSidebar(
    viewModel: SopViewModel,
    modifier: Modifier = Modifier,
    onCloseSidebar: (() -> Unit)? = null
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val currentCategory by viewModel.currentCategory.collectAsState()
    val currentRole by viewModel.currentUserRole.collectAsState()
    val sops by viewModel.sops.collectAsState()

    var dropdownExpanded by remember { mutableStateOf(false) }
    val rolesList = listOf("Analyst", "Operator", "QA Officer", "Warehouse Executive", "Administrator")

    // Stats calculations
    val totalCount = sops.size
    val bookmarkedCount = sops.count { it.isBookmarked }
    val signedOffCount = sops.count { it.isSignedOff }

    // Map categories to standard icons
    val menuItems = listOf(
        MenuCategory.HOME to Icons.Default.Home,
        MenuCategory.QUALITY_CONTROL to Icons.Default.Science,
        MenuCategory.QUALITY_ASSURANCE to Icons.Default.AssignmentTurnedIn,
        MenuCategory.MICROBIOLOGY to Icons.Default.DeviceHub,
        MenuCategory.PRODUCTION to Icons.Default.Build,
        MenuCategory.SOPS to Icons.Default.List,
        MenuCategory.VALIDATION to Icons.Default.CheckCircle,
        MenuCategory.GMP to Icons.Default.Lock,
        MenuCategory.AUDIT to Icons.Default.Assessment,
        MenuCategory.USP_COLUMNS to Icons.Default.ViewColumn,
        MenuCategory.VIDEOS to Icons.Default.PlayArrow,
        MenuCategory.CALCULATORS to Icons.Default.Calculate,
        MenuCategory.CONTACT to Icons.Default.Phone
    )

    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(Color(0xFF1E1E24)) // Dark background from website
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 1. BRAND HEADER (Pharmaguideline style)
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Left Curved Pharmaceutical styled logo representation (Green & Yellow)
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .background(Color(0xFF2E7D32), CircleShape)
                            .border(3.dp, Color(0xFFFFB300), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "+",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Pharma SOP Portal",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(0xFF1B5E20) // Deep green brand color
                    )
                    
                    if (onCloseSidebar != null) {
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(onClick = onCloseSidebar) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close Sidebar",
                                tint = Color(0xFF1B5E20)
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(14.dp))
                
                // 2. SEARCH BAR ("ENHANCED BY Google" style with blue search button)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .border(1.dp, Color.LightGray, RoundedCornerShape(6.dp))
                        .background(Color.White, RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search icon",
                        tint = Color.Gray,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Box(modifier = Modifier.weight(1f)) {
                        if (searchQuery.isEmpty()) {
                            Text(
                                text = "ENHANCED BY Google",
                                color = Color.LightGray,
                                fontSize = 13.sp
                            )
                        }
                        BasicTextField(
                            value = searchQuery,
                            onValueChange = { viewModel.setSearchQuery(it) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("sidebar_search_input"),
                            singleLine = true,
                            textStyle = TextStyle(color = Color.Black, fontSize = 13.sp)
                        )
                    }
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { viewModel.setSearchQuery("") }, modifier = Modifier.size(24.dp)) {
                            Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear", tint = Color.Gray)
                        }
                    }
                    // Blue square search button next to it
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .background(Color(0xFF2196F3), RoundedCornerShape(4.dp))
                            .clickable { /* Trigger search */ }
                            .testTag("sidebar_search_button"),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Button",
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }

        // 3. VERTICAL CATEGORY MENU (Charcoal Black menu with white links)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            menuItems.forEach { (category, icon) ->
                val isSelected = currentCategory == category
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(
                            if (isSelected) Color(0xFF2E7D32).copy(alpha = 0.2f) else Color.Transparent
                        )
                        .clickable {
                            viewModel.selectCategory(category)
                            onCloseSidebar?.invoke()
                        }
                        .padding(vertical = 12.dp, horizontal = 12.dp)
                        .testTag("menu_item_${category.name}"),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = category.displayName,
                        tint = if (isSelected) Color(0xFF4CAF50) else Color.White.copy(alpha = 0.8f),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = category.displayName,
                        color = if (isSelected) Color.White else Color.White.copy(alpha = 0.9f),
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        fontSize = 14.sp
                    )
                    
                    if (isSelected) {
                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .background(Color(0xFF4CAF50), CircleShape)
                        )
                    }
                }
            }
        }

        // 4. SIMULATOR & METRICS (Bottom Section on Dark grey background card)
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF25252D)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Role & Access Simulator",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF81C784)
                )

                // Role switcher dropdown
                ExposedDropdownMenuBox(
                    expanded = dropdownExpanded,
                    onExpandedChange = { dropdownExpanded = it },
                    modifier = Modifier.fillMaxWidth().testTag("role_dropdown_container")
                ) {
                    OutlinedTextField(
                        value = currentRole,
                        onValueChange = {},
                        readOnly = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFF1E1E24),
                            unfocusedContainerColor = Color(0xFF1E1E24),
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedBorderColor = Color(0xFF2E7D32),
                            unfocusedBorderColor = Color.White.copy(alpha = 0.2f)
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = if (currentRole == "Administrator") Icons.Default.SupervisorAccount else Icons.Default.Person,
                                contentDescription = "Role Icon",
                                tint = Color.LightGray
                            )
                        },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = dropdownExpanded) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor()
                            .testTag("role_selector_field"),
                        textStyle = TextStyle(fontSize = 12.sp)
                    )
                    ExposedDropdownMenu(
                        expanded = dropdownExpanded,
                        onDismissRequest = { dropdownExpanded = false },
                        modifier = Modifier.background(Color(0xFF25252D))
                    ) {
                        rolesList.forEach { role ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = role,
                                        color = Color.White,
                                        fontWeight = if (role == currentRole) FontWeight.Bold else FontWeight.Normal
                                    )
                                },
                                onClick = {
                                    viewModel.selectUserRole(role)
                                    dropdownExpanded = false
                                }
                            )
                        }
                    }
                }

                Divider(color = Color.White.copy(alpha = 0.08f))

                // Stats rows
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Total SOPs/Docs", fontSize = 11.sp, color = Color.LightGray)
                    Text("$totalCount", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("My Bookmarks", fontSize = 11.sp, color = Color.LightGray)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Bookmark,
                            contentDescription = null,
                            tint = Color(0xFFFFB300),
                            modifier = Modifier.size(10.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("$bookmarkedCount", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Signed-offs", fontSize = 11.sp, color = Color.LightGray)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.AssignmentTurnedIn,
                            contentDescription = null,
                            tint = Color(0xFF81C784),
                            modifier = Modifier.size(10.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("$signedOffCount", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

// Simple local replica of basic text field to avoid material dependency glitches
@Composable
fun BasicTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    singleLine: Boolean = false,
    textStyle: androidx.compose.ui.text.TextStyle = androidx.compose.ui.text.TextStyle.Default
) {
    androidx.compose.foundation.text.BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        singleLine = singleLine,
        textStyle = textStyle
    )
}

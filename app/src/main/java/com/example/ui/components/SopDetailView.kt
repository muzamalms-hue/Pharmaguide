package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AssignmentTurnedIn
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Gavel
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.SopEntity
import com.example.ui.SopViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun SopDetailView(
    viewModel: SopViewModel,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null
) {
    val sop by viewModel.selectedSop.collectAsState()
    val currentRole by viewModel.currentUserRole.collectAsState()

    if (sop == null) {
        SopDetailLandingState()
    } else {
        val currentSop = sop!!
        val hasAccess = viewModel.checkRolePermission(currentSop.roleRequired)

        if (!hasAccess) {
            SopDetailLockedState(
                sop = currentSop,
                currentRole = currentRole,
                onRoleSwitch = { viewModel.selectUserRole(currentSop.roleRequired) },
                onBackClick = onBackClick
            )
        } else {
            SopDetailDocument(
                sop = currentSop,
                onBookmarkToggle = { viewModel.toggleBookmark(currentSop.id, !currentSop.isBookmarked) },
                onSignOffClick = { viewModel.signOffSop(currentSop.id) },
                onBackClick = onBackClick
            )
        }
    }
}

@Composable
fun SopDetailLandingState() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Surface(
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f),
                shape = CircleShape,
                modifier = Modifier.size(96.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.Description,
                        contentDescription = "Standard Operating Procedure Document",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
            Text(
                text = "Standard Operating Procedures (SOP)",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = "Select an SOP from the directory listing to view full GXP documentation, review revision histories, and electronically sign-off on reading mandates.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun SopDetailLockedState(
    sop: SopEntity,
    currentRole: String,
    onRoleSwitch: () -> Unit,
    onBackClick: (() -> Unit)?
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .verticalScroll(rememberScrollState())
        ) {
            if (onBackClick != null) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                    IconButton(onClick = onBackClick) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back to list")
                    }
                }
            }

            Surface(
                color = Color(0xFFFFF3E0),
                shape = CircleShape,
                modifier = Modifier.size(80.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Access Restricted",
                        tint = Color(0xFFE65100),
                        modifier = Modifier.size(36.dp)
                    )
                }
            }

            Text(
                text = "Access Restricted",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFE65100)
            )

            Text(
                text = "Security Clearance Authorization Required",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.SemiBold
            )

            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                        Text("Document Code:", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                        Text(sop.code, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodySmall)
                    }
                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                        Text("Target Department:", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                        Text(sop.department, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodySmall)
                    }
                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                        Text("Required Clearance:", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                        Text(sop.roleRequired, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodySmall)
                    }
                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                        Text("Your Current Role:", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                        Text(currentRole, fontWeight = FontWeight.Bold, color = Color(0xFFE65100), style = MaterialTheme.typography.bodySmall)
                    }
                }
            }

            Text(
                text = "Under Good Manufacturing Practice (GMP) standards, SOP procedures are strictly limited to authorized personnel with corresponding functional clearance. All unauthorized access attempts are registered in the system audit logs.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Demo Shortcut
            Button(
                onClick = onRoleSwitch,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                modifier = Modifier.fillMaxWidth().testTag("bypass_lock_button")
            ) {
                Icon(imageVector = Icons.Default.Shield, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Simulate Role Shift to ${sop.roleRequired}")
            }
        }
    }
}

@Composable
fun SopDetailDocument(
    sop: SopEntity,
    onBookmarkToggle: () -> Unit,
    onSignOffClick: () -> Unit,
    onBackClick: (() -> Unit)?
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .testTag("sop_detail_document")
    ) {
        // Document Control Top Bar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.04f))
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            if (onBackClick != null) {
                IconButton(onClick = onBackClick, modifier = Modifier.testTag("sop_detail_back_button")) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back to list")
                }
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = sop.code,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "STATUS: EFFECTIVE",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2E7D32)
                )
            }

            // Bookmark
            IconButton(onClick = onBookmarkToggle, modifier = Modifier.testTag("sop_detail_bookmark_button")) {
                Icon(
                    imageVector = if (sop.isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                    contentDescription = "Bookmark SOP",
                    tint = if (sop.isBookmarked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
                )
            }
        }

        Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))

        // Document Body
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scrollState)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Document Header Box (GXP Style)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.15f), RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                Column {
                    // Document Title
                    Text(
                        text = sop.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(16.dp)
                    )

                    Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.15f))

                    // GXP Metadata Matrix
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .border(0.5.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f))
                                .padding(10.dp)
                        ) {
                            Text("DEPARTMENT", fontSize = 8.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
                            Text(sop.department, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.onSurface)
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .border(0.5.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f))
                                .padding(10.dp)
                        ) {
                            Text("SECTION", fontSize = 8.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
                            Text(sop.section, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
                        }
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .border(0.5.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f))
                                .padding(10.dp)
                        ) {
                            Text("VERSION", fontSize = 8.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
                            Text("V${sop.version} (GMP)", fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.onSurface)
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .border(0.5.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f))
                                .padding(10.dp)
                        ) {
                            Text("EFFECTIVE DATE", fontSize = 8.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
                            Text(sop.effectiveDate, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.onSurface)
                        }
                    }
                }
            }

            // GXP Section 1: Objective
            GxpSection(title = "1.0 OBJECTIVE", testTag = "gxp_objective") {
                Text(
                    text = sop.objective,
                    style = MaterialTheme.typography.bodyMedium,
                    lineHeight = 20.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            // GXP Section 2: Scope
            GxpSection(title = "2.0 SCOPE", testTag = "gxp_scope") {
                Text(
                    text = sop.scope,
                    style = MaterialTheme.typography.bodyMedium,
                    lineHeight = 20.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            // GXP Section 3: Responsibility
            GxpSection(title = "3.0 RESPONSIBILITY & KEY PERSONNEL", testTag = "gxp_responsibility") {
                Text(
                    text = sop.responsibility,
                    style = MaterialTheme.typography.bodyMedium,
                    lineHeight = 20.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            // GXP Section 4: Detailed Procedure (Step-by-step)
            GxpSection(title = "4.0 PROCEDURAL METHODOLOGY", testTag = "gxp_procedure") {
                val steps = sop.procedure.split(";").filter { it.trim().isNotEmpty() }
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    steps.forEachIndexed { index, step ->
                        Row(modifier = Modifier.fillMaxWidth()) {
                            // Step Number Badge
                            Surface(
                                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f),
                                contentColor = MaterialTheme.colorScheme.primary,
                                shape = CircleShape,
                                modifier = Modifier.size(24.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(
                                        text = "${index + 1}",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = step.trim(),
                                style = MaterialTheme.typography.bodyMedium,
                                lineHeight = 20.sp,
                                color = MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }

            // GXP Section 5: Safety & Environmental Precautions
            GxpSection(title = "5.0 SAFETY & ENVIRONMENTAL PRECAUTIONS", testTag = "gxp_safety") {
                val precautions = sop.safetyPrecautions.split(";").filter { it.trim().isNotEmpty() }
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.15f)),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.error.copy(alpha = 0.2f))
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = "Safety Alert",
                                tint = MaterialTheme.colorScheme.error,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "CRITICAL SAFETY NOTICES",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                        precautions.forEach { prec ->
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Text(text = "•", color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(horizontal = 4.dp))
                                Text(
                                    text = prec.trim(),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                                    lineHeight = 16.sp,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }
                }
            }

            // GXP Section 6: Operational Frequency
            GxpSection(title = "6.0 RE-VERIFICATION FREQUENCY", testTag = "gxp_frequency") {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Gavel,
                        contentDescription = "Standard Frequency",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = sop.frequency,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))

            // 21 CFR Part 11 Electronic Signature Sign-off Box
            ElectronicSignOffBlock(
                sop = sop,
                onSignOffClick = onSignOffClick
            )
        }
    }
}

@Composable
fun GxpSection(
    title: String,
    testTag: String,
    content: @Composable () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .testTag(testTag)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            letterSpacing = 1.sp
        )
        content()
    }
}

@Composable
fun ElectronicSignOffBlock(
    sop: SopEntity,
    onSignOffClick: () -> Unit
) {
    if (sop.isSignedOff) {
        val signOffDate = if (sop.signOffTimestamp != null) {
            val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss (zzz)", Locale.getDefault())
            df.format(Date(sop.signOffTimestamp))
        } else {
            "N/A"
        }

        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, Color(0xFF81C784).copy(alpha = 0.5f)),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("sign_off_completed_card")
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Success check",
                        tint = Color(0xFF2E7D32),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "21 CFR Part 11 Electronic Read Sign-Off",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1B5E20)
                    )
                }

                Divider(color = Color(0xFF2E7D32).copy(alpha = 0.15f))

                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = "Signee Authority: ${sop.signOffBy ?: "N/A"}",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF1B5E20)
                    )
                    Text(
                        text = "Timestamp: $signOffDate",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF1B5E20).copy(alpha = 0.8f)
                    )
                }

                Text(
                    text = "Electronic Signature Mandate: By signing off on this portal, you verify that you have thoroughly read, understood, and agree to strictly comply with all provisions, calibration protocols, and security bounds described in this SOP. This constitutes an official document signature in accordance with 21 CFR Part 11 regulations.",
                    fontSize = 9.sp,
                    lineHeight = 13.sp,
                    color = Color(0xFF1B5E20).copy(alpha = 0.7f),
                    textAlign = TextAlign.Justify
                )
            }
        }
    } else {
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("sign_off_action_card")
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Security,
                        contentDescription = "Regulatory Compliance",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "21 CFR Part 11 Electronic Sign-Off Required",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                Text(
                    text = "Before executing tasks under this procedure, you must sign off to certify that you have read and understood the steps. This will place a persistent green marker on your records database.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    lineHeight = 16.sp
                )

                Button(
                    onClick = onSignOffClick,
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("sign_off_confirm_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.AssignmentTurnedIn,
                        contentDescription = "Signature Sign Off",
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Acknowledge & Sign Off Document")
                }
            }
        }
    }
}

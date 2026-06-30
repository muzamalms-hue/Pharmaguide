package com.example.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.SopViewModel
import com.example.data.ContactInquiryEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// ==========================================
// 1. ASK SECTION (Pharma AI Q&A Assistant)
// ==========================================

data class ChatMessage(
    val sender: String, // "User" or "AI"
    val content: String,
    val timestamp: Long = System.currentTimeMillis()
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PharmaAskSection(
    viewModel: SopViewModel,
    modifier: Modifier = Modifier
) {
    var queryText by remember { mutableStateOf("") }
    val chatMessages = remember {
        mutableStateListOf(
            ChatMessage("AI", "Welcome to the Pharma SOP Portal Compliance Assistant. I can help answer questions regarding QC calibration, QA audits, Sterile gowning, OOS, and FDA GMP compliance. Select a preset question below or ask anything!")
        )
    }
    var isTyping by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    val suggestions = listOf(
        "What is the difference between QA and QC?",
        "What are the phases of an OOS Investigation?",
        "Explain the cleanroom gowning sequence.",
        "How is the FEFO policy enforced in warehouse?"
    )

    fun handleSend(text: String) {
        if (text.isBlank()) return
        chatMessages.add(ChatMessage("User", text))
        queryText = ""
        isTyping = true

        scope.launch {
            delay(1500) // Mock typing latency
            val response = when {
                text.contains("QA", ignoreCase = true) && text.contains("QC", ignoreCase = true) -> {
                    "**Quality Assurance (QA)** is process-oriented and focuses on preventing defects through design, audits, standard procedures, and system oversight (GMP compliance).\n\n**Quality Control (QC)** is product-oriented and focuses on detecting defects through physical and chemical laboratory testing of raw materials, intermediates, and final drug batches."
                }
                text.contains("OOS", ignoreCase = true) || text.contains("specification", ignoreCase = true) -> {
                    "An **Out of Specification (OOS)** investigation follows a strict 2-step process:\n\n1. **Phase I (Laboratory Investigation)**: Initiated immediately by analyst and supervisor. Inspects dilution preparation, standard solution expiry, instrument calibration, and calculations before sample disposal.\n2. **Phase II (Full Investigation)**: If laboratory error is ruled out, evaluates the production process, and carries out duplicate re-testing by a second qualified analyst under QA authorization."
                }
                text.contains("gown", ignoreCase = true) || text.contains("sterile", ignoreCase = true) -> {
                    "According to WHO & FDA sterile guidelines, the aseptic gowning sequence is:\n1. Remove outer clothing/jewelry, wash hands and forearms for 2 mins.\n2. Enter gowning airlock, disinfect hands with 70% IPA.\n3. Put on hairnet and facial mask.\n4. Wear sterile safety goggles.\n5. Don sterile jumpsuit without touching floor/walls.\n6. Slip on knee-high boots.\n7. Disinfect hands, wear double sterile latex gloves, pulling cuffs over jumpsuit sleeves."
                }
                text.contains("FEFO", ignoreCase = true) || text.contains("warehouse", ignoreCase = true) -> {
                    "**First Expired, First Out (FEFO)** is the primary inventory policy in warehousing:\n\n- Material batches with the nearest expiry date are placed at the front of shelving systems.\n- Items are picked strictly by closest expiry date first, regardless of when they arrived.\n- This prevents degradation, stock expiration, and ensures patient safety by shipping the freshest batches within specification limits."
                }
                else -> {
                    "I have found relevant information regarding your query in the Pharma SOP Database. In accordance with current regulatory requirements (cGMP & 21 CFR Part 211), all procedures must be fully documented, validated by the Quality unit, and executed by qualified personnel. Let me know if you would like me to retrieve specific SOP guidelines!"
                }
            }
            chatMessages.add(ChatMessage("AI", response))
            isTyping = false
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Chat Header
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape,
                    modifier = Modifier.size(40.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.SupportAgent,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("Pharma SOP AI Q&A", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
                    Text("GMP & Regulatory Guidelines Advisor", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                }
            }
        }

        // Chat list
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .testTag("chat_messages_list"),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 4.dp)
        ) {
            items(chatMessages) { msg ->
                val isUser = msg.sender == "User"
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start
                ) {
                    Card(
                        shape = RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp,
                            bottomStart = if (isUser) 16.dp else 4.dp,
                            bottomEnd = if (isUser) 4.dp else 16.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isUser) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .testTag("chat_bubble_${msg.sender}")
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = if (isUser) "You" else "Compliance AI",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = if (isUser) MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f) else MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = msg.content,
                                style = MaterialTheme.typography.bodyMedium,
                                color = if (isUser) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }

            if (isTyping) {
                item {
                    Row(modifier = Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.Start) {
                        CircularProgressIndicator(modifier = Modifier.size(16.dp), strokeWidth = 2.dp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Advisor is typing...", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
                    }
                }
            }
        }

        // Preset questions chips list
        Text("Common Inquiries:", style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.SemiBold)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            LazyColumn(
                modifier = Modifier.height(80.dp).fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(suggestions) { sugg ->
                    Surface(
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { handleSend(sugg) }
                            .testTag("suggestion_chip_$sugg")
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(imageVector = Icons.Default.QuestionAnswer, contentDescription = null, modifier = Modifier.size(12.dp), tint = MaterialTheme.colorScheme.primary)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(sugg, fontSize = 11.sp, maxLines = 1, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
            }
        }

        // Input row
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = queryText,
                onValueChange = { queryText = it },
                placeholder = { Text("Type query here...") },
                modifier = Modifier
                    .weight(1f)
                    .testTag("chat_input_field"),
                shape = RoundedCornerShape(24.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.15f)
                ),
                maxLines = 2
            )
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(
                onClick = { handleSend(queryText) },
                enabled = queryText.isNotBlank() && !isTyping,
                modifier = Modifier
                    .background(
                        if (queryText.isNotBlank() && !isTyping) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                        CircleShape
                    )
                    .size(48.dp)
                    .testTag("chat_send_button")
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send",
                    tint = if (queryText.isNotBlank() && !isTyping) Color.White else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
                )
            }
        }
    }
}

// ==========================================
// 2. VIDEOS SECTION (SOP Video Training)
// ==========================================

data class SopVideo(
    val id: String,
    val title: String,
    val duration: String,
    val module: String,
    val author: String,
    val views: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PharmaVideosSection(
    viewModel: SopViewModel,
    modifier: Modifier = Modifier
) {
    val videos = listOf(
        SopVideo("vid_01", "HPLC Peak Integration & Troubleshooting", "12 mins", "Quality Control", "Dr. Sarah Jenkins", "1.2K views"),
        SopVideo("vid_02", "Grade A Cleanroom Aseptic Gowning Demonstration", "8 mins", "Production", "Senior Operator Ahmed", "3.4K views"),
        SopVideo("vid_03", "Environmental Monitoring Active Air Sampling Methods", "15 mins", "Microbiology", "Aisha Khan (Micro Lead)", "920 views"),
        SopVideo("vid_04", "How to Prepare for FDA Facility Inspections", "22 mins", "Audit & QA", "Mark Roberts (Lead Auditor)", "5.1K views"),
        SopVideo("vid_05", "Corrective Actions (CAPA) Root Cause Analysis Guide", "10 mins", "Quality Assurance", "Zoe Henderson", "2.1K views")
    )

    var playingVideo by remember { mutableStateOf<SopVideo?>(null) }
    var isPlaying by remember { mutableStateOf(false) }
    var playProgress by remember { mutableFloatStateOf(0.3f) }
    var mockTimeSec by remember { mutableIntStateOf(145) }

    LaunchedEffect(isPlaying) {
        if (isPlaying) {
            while (isPlaying) {
                delay(1000)
                mockTimeSec += 1
                playProgress = (playProgress + 0.01f).coerceAtMost(1.0f)
                if (playProgress >= 1.0f) {
                    isPlaying = false
                }
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Video Player Mockup if video is selected
        AnimatedVisibility(
            visible = playingVideo != null,
            enter = slideInVertically() + fadeIn(),
            exit = slideOutVertically() + fadeOut()
        ) {
            playingVideo?.let { video ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(4.dp)
                        .testTag("video_player_card"),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column {
                        // Simulated Screen Area
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .background(Color.Black),
                            contentAlignment = Alignment.Center
                        ) {
                            // Graphics representing animated flow
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.verticalGradient(
                                            colors = listOf(Color(0xFF2E7D32).copy(alpha = 0.4f), Color.Black)
                                        )
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Icon(
                                        imageVector = if (isPlaying) Icons.Default.PauseCircle else Icons.Default.PlayCircle,
                                        contentDescription = "Play Control",
                                        tint = Color.White,
                                        modifier = Modifier
                                            .size(64.dp)
                                            .clickable { isPlaying = !isPlaying }
                                            .testTag("player_play_pause_button")
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = if (isPlaying) "Playing: ${mockTimeSec / 60}:${String.format("%02d", mockTimeSec % 60)}" else "Paused",
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp
                                    )
                                }
                            }
                        }

                        // Playback Controls Row
                        Column(modifier = Modifier.padding(12.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = video.title,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    modifier = Modifier.weight(1f)
                                )
                                IconButton(onClick = { playingVideo = null; isPlaying = false }) {
                                    Icon(imageVector = Icons.Default.Close, contentDescription = "Close player")
                                }
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            LinearProgressIndicator(
                                progress = { playProgress },
                                modifier = Modifier.fillMaxWidth().height(4.dp),
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(imageVector = Icons.Default.Person, contentDescription = null, modifier = Modifier.size(16.dp), tint = MaterialTheme.colorScheme.primary)
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(video.author, fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                                }
                                Row {
                                    Badge(containerColor = MaterialTheme.colorScheme.primaryContainer) {
                                        Text(video.duration, fontSize = 10.sp)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // List of Video Cards
        Text(
            text = "Regulatory & Standard Video Modules",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        LazyColumn(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(videos) { video ->
                val isCurrent = video.id == playingVideo?.id
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            playingVideo = video
                            isPlaying = true
                            mockTimeSec = (30..150).random()
                            playProgress = mockTimeSec.toFloat() / 600f
                        }
                        .testTag("video_card_${video.id}"),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isCurrent) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.2f) else MaterialTheme.colorScheme.surface
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Simulated Thumbnail Box
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(
                                    Brush.linearGradient(
                                        colors = listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.secondary)
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null, tint = Color.White, modifier = Modifier.size(28.dp))
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Surface(
                                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                                shape = RoundedCornerShape(4.dp)
                            ) {
                                Text(
                                    text = video.module,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(video.title, fontWeight = FontWeight.Bold, fontSize = 13.sp, maxLines = 2)
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "By ${video.author} • ${video.views}",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                            )
                        }

                        Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null, tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f))
                    }
                }
            }
        }
    }
}

// ==========================================
// 3. COURSES SECTION (Regulatory Training)
// ==========================================

data class PharmaCourse(
    val id: String,
    val title: String,
    val enrolled: Boolean,
    val progress: Int, // Percentage: 0 to 100
    val modulesCount: Int,
    val cost: String
)

// ==========================================
// 4. PHARMACEUTICAL CALCULATORS SECTION
// ==========================================

enum class CalculatorType(val displayName: String, val description: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    NONE("None", "", Icons.Default.Calculate),
    MOLARITY("Molarity Calculator", "Calculate molar concentration from mass, volume, and molecular weight.", Icons.Default.Science),
    ACID_BASE_MOLARITY("Acid-Base Molarity", "Calculate molarity from density, assay purity, and molecular weight.", Icons.Default.WaterDrop),
    STOCK_DILUTION("Stock Dilution (C1V1 = C2V2)", "Calculate necessary volume or concentration for standard solutions.", Icons.Default.Opacity),
    RSD_CALCULATOR("RSD Calculator", "Calculate Mean, Standard Deviation (SD), and RSD % for HPLC chromatogram peak areas.", Icons.Default.Assessment),
    PRESSURE_TEMP_NOMOGRAPH("P-T Nomograph Tool", "Calculate boiling points at reduced pressures using standard Pressure-Temperature Nomograph relation.", Icons.Default.TrendingUp),
    VOLUME_CONVERTER("Volume Unit Converter", "Convert volume measurements (m³, hL, l, dL, mL, µL, gal, pt, oz, in³) with geometric references.", Icons.Default.GridView),
    PRESSURE_CONVERTER("Pressure Unit Converter", "Convert pressure values between bar, psi, kPa, hPa, MPa, Pa, kgf/cm², torr, atm, etc.", Icons.Default.Compress),
    MASS_CONVERTER("Mass/Weight Unit Converter", "Convert masses between t, kg, g, mg, µg, ng, pg, st, lb, oz, ct, amu.", Icons.Default.LineWeight),
    DENSITY_CONVERTER("Density Unit Converter", "Convert density values (g/mL, kg/L, g/m³, kg/m³, mg/m³).", Icons.Default.Opacity),
    LENGTH_CONVERTER("Length Unit Converter", "Convert lengths and distances (m, dm, cm, mm, µm, nm, Å, yd, ft, in).", Icons.Default.Straighten),
    HPLC_METHOD_TRANSFER("HPLC Method Transfer", "Calculate time/solvent savings and scale column parameter shifts under gradient or isocratic conditions.", Icons.Default.CompareArrows),
    ABSORBANCE_CONVERTER("Absorbance to Transmittance", "Convert spectrophotometric Absorbance (A) directly to Transmittance (T%) and vice versa.", Icons.Default.SyncAlt),
    TEMPERATURE_CONVERTER("Temperature Unit Converter", "Convert between Celsius (°C), Fahrenheit (°F), Kelvin (K), Rankine (°Ra), and Réaumur (°Re).", Icons.Default.Thermostat),
    THREE_VARIABLE_SOLVER("3-Variable Equation Solver", "Enter any 2 values for A, B, or C to automatically calculate the 3rd variable (A × B = C or A / B = C).", Icons.Default.Dialpad)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PharmaCalculatorsSection(
    viewModel: SopViewModel,
    modifier: Modifier = Modifier
) {
    var selectedCalc by remember { mutableStateOf(CalculatorType.NONE) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9)) // Warm grey lab background for custom look!
    ) {
        if (selectedCalc == CalculatorType.NONE) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Main Dashboard header - styled Red
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFC62828)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("PHARMACEUTICAL GUIDELINES", color = Color.White.copy(alpha = 0.8f), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text("Validation & Lab Calculators", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                                Text("Standard QC / QA & Engineering calculations with compliance limits.", color = Color.White.copy(alpha = 0.9f), fontSize = 12.sp)
                            }
                            Icon(
                                imageVector = Icons.Default.Calculate,
                                contentDescription = null,
                                tint = Color(0xFFFFD54F),
                                modifier = Modifier.size(48.dp)
                            )
                        }
                    }
                }

                Text(
                    text = "Select a Compliance Calculator",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )

                LazyColumn(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    val calcs = CalculatorType.values().filter { it != CalculatorType.NONE }
                    items(calcs) { calc ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { selectedCalc = calc }
                                .testTag("calculator_card_${calc.name}"),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.4f)),
                            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(14.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .background(Color(0xFFC62828).copy(alpha = 0.1f), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = calc.icon,
                                        contentDescription = calc.displayName,
                                        tint = Color(0xFFC62828)
                                    )
                                }
                                Spacer(modifier = Modifier.width(14.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(calc.displayName, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.Black)
                                    Text(calc.description, fontSize = 11.sp, color = Color.Gray, maxLines = 1)
                                }
                                Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null, tint = Color.LightGray)
                            }
                        }
                    }
                }
            }
        } else {
            // Render specific calculator
            if (selectedCalc == CalculatorType.MOLARITY || 
                selectedCalc == CalculatorType.ACID_BASE_MOLARITY || 
                selectedCalc == CalculatorType.STOCK_DILUTION) {
                
                AldrichChemistrySuite(
                    initialType = selectedCalc,
                    onBackClick = { selectedCalc = CalculatorType.NONE }
                )
            } else if (selectedCalc == CalculatorType.RSD_CALCULATOR) {
                RsdCalculatorSuite(
                    onBackClick = { selectedCalc = CalculatorType.NONE }
                )
            } else if (selectedCalc == CalculatorType.PRESSURE_TEMP_NOMOGRAPH) {
                PressureTempNomographSuite(
                    onBackClick = { selectedCalc = CalculatorType.NONE }
                )
            } else {
                // Render other individual calculators in a unified red theme!
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFF9F9F9))
                ) {
                    // 1. TOP HEADER (Aldrich Style Red Bar)
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color(0xFFC62828), // Authentic Aldrich Red
                        shadowElevation = 4.dp
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp, vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(onClick = { selectedCalc = CalculatorType.NONE }) {
                                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                            }
                            Spacer(modifier = Modifier.width(4.dp))
                            Column {
                                Text(
                                    text = selectedCalc.displayName,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 16.sp
                                )
                                Text(
                                    text = "Pharma Compliance Calculator",
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White.copy(alpha = 0.85f),
                                    fontSize = 11.sp
                                )
                            }
                        }
                    }

                    // 2. MAIN SCROLLABLE FORM
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Text(
                            text = selectedCalc.displayName,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFC62828),
                            modifier = Modifier.padding(bottom = 4.dp)
                        )

                        when (selectedCalc) {
                            CalculatorType.VOLUME_CONVERTER -> VolumeConverterWidget()
                            CalculatorType.PRESSURE_CONVERTER -> PressureConverterWidget()
                            CalculatorType.MASS_CONVERTER -> MassConverterWidget()
                            CalculatorType.DENSITY_CONVERTER -> DensityConverterWidget()
                            CalculatorType.LENGTH_CONVERTER -> LengthConverterWidget()
                            CalculatorType.HPLC_METHOD_TRANSFER -> HplcMethodTransferWidget()
                            CalculatorType.ABSORBANCE_CONVERTER -> AbsorbanceTransmittanceWidget()
                            CalculatorType.TEMPERATURE_CONVERTER -> TemperatureConverterWidget()
                            CalculatorType.THREE_VARIABLE_SOLVER -> ThreeVariableSolverWidget()
                            else -> {}
                        }
                    }
                }
            }
        }
    }
}

// =========================================================================
// ALDRICH CHEMISTRY SUITE COMPOSABLE (Unified Chemistry Calculators)
// =========================================================================

data class AcidBaseChemical(
    val name: String,
    val density: Double,          // g/mL
    val formulaWeight: Double,    // g/mol
    val weightPercent: Double,     // % w/w
    val equivalenceFactor: Int    // e.g. 2 for H2SO4, 3 for H3PO4
)

val chemicalList = listOf(
    AcidBaseChemical("Acetic Acid (Glacial)", 1.05, 60.05, 99.7, 1),
    AcidBaseChemical("Ammonium Hydroxide", 0.90, 35.05, 28.0, 1),
    AcidBaseChemical("Formic Acid", 1.22, 46.03, 88.0, 1),
    AcidBaseChemical("Hydrochloric Acid (HCl)", 1.19, 36.46, 37.0, 1),
    AcidBaseChemical("Hydrofluoric Acid (HF)", 1.15, 20.01, 49.0, 1),
    AcidBaseChemical("Nitric Acid (HNO3)", 1.42, 63.01, 70.0, 1),
    AcidBaseChemical("Perchloric Acid", 1.67, 100.46, 70.0, 1),
    AcidBaseChemical("Phosphoric Acid (H3PO4)", 1.685, 98.0, 85.0, 3),
    AcidBaseChemical("Potassium Hydroxide (KOH)", 1.45, 56.11, 45.0, 1),
    AcidBaseChemical("Sodium Hydroxide (NaOH)", 1.52, 40.0, 50.0, 1),
    AcidBaseChemical("Sulfuric Acid (H2SO4)", 1.84, 98.08, 96.0, 2)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AldrichChemistrySuite(
    initialType: CalculatorType,
    onBackClick: () -> Unit
) {
    // Determine active tab index from initialType
    var activeTab by remember {
        mutableStateOf(
            when (initialType) {
                CalculatorType.ACID_BASE_MOLARITY -> 0
                CalculatorType.MOLARITY -> 1
                CalculatorType.STOCK_DILUTION -> 2
                else -> 0
            }
        )
    }

    var showInfoDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9)) // Warm grey lab background
    ) {
        // 1. TOP HEADER (Aldrich Style Red Bar)
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFC62828), // Authentic Aldrich Red
            shadowElevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onBackClick) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    val headerTitle = when (activeTab) {
                        0 -> "Acid & Base Molarity"
                        1 -> "Molarity Calculator"
                        2 -> "Stock Dilution"
                        else -> "Calculator"
                    }
                    Column {
                        Text(
                            text = headerTitle,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "Chemistry Calculator",
                            fontWeight = FontWeight.Medium,
                            color = Color.White.copy(alpha = 0.85f),
                            fontSize = 11.sp
                        )
                    }
                }
                IconButton(onClick = { showInfoDialog = true }) {
                    Icon(imageVector = Icons.Default.Info, contentDescription = "Info", tint = Color.White)
                }
            }
        }

        // 2. MAIN SCROLLABLE FORM
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            when (activeTab) {
                0 -> AcidBaseMolarityTab()
                1 -> GeneralMolarityTab()
                2 -> StockDilutionTab()
            }
        }

        // 3. BOTTOM SIGMA-ALDRICH NAVIGATION BAR
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFE0E0E0),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Tab 0: Acid & Base
                TabItem(
                    title = "Acid & Base",
                    isActive = (activeTab == 0),
                    onClick = { activeTab = 0 },
                    modifier = Modifier.weight(1f)
                )
                // Tab 1: Molarity
                TabItem(
                    title = "Molarity",
                    isActive = (activeTab == 1),
                    onClick = { activeTab = 1 },
                    modifier = Modifier.weight(1f)
                )
                // Tab 2: Stock Dilution
                TabItem(
                    title = "Stock Dilution",
                    isActive = (activeTab == 2),
                    onClick = { activeTab = 2 },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

    if (showInfoDialog) {
        AlertDialog(
            onDismissRequest = { showInfoDialog = false },
            title = { Text("Chemistry Calculator Suite", fontWeight = FontWeight.Bold, color = Color.Black) },
            text = {
                Text(
                    "Standard pharmaceutical and chemical quality control calculations:\n\n" +
                    "• Acid & Base: Determine necessary volume of concentrated commercial chemical to achieve a desired target concentration.\n\n" +
                    "• General Molarity: Find solute mass required based on Molecular Weight (g/mol), Volume, and Target Concentration.\n\n" +
                    "• Stock Dilution: Standard C1V1 = C2V2 formulation for serial or direct dilutions.",
                    fontSize = 13.sp,
                    color = Color.DarkGray
                )
            },
            confirmButton = {
                TextButton(onClick = { showInfoDialog = false }) {
                    Text("OK", color = Color(0xFFC62828))
                }
            },
            containerColor = Color.White
        )
    }
}

@Composable
fun TabItem(
    title: String,
    isActive: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(54.dp)
            .background(if (isActive) Color(0xFF424242) else Color(0xFFEEEEEE)) // Dark grey active, light grey inactive
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            color = if (isActive) Color.White else Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun BasicTextFieldWithBorder(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = if (placeholder.isNotEmpty()) { { Text(placeholder, fontSize = 13.sp) } } else null,
        singleLine = true,
        keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(
            keyboardType = androidx.compose.ui.text.input.KeyboardType.Number
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFC62828),
            unfocusedBorderColor = Color.LightGray,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.height(48.dp),
        textStyle = androidx.compose.ui.text.TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium)
    )
}

@Composable
fun CompactUnitDropdown(
    selectedUnit: String,
    options: List<String>,
    onUnitSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Box {
        Surface(
            modifier = Modifier
                .width(85.dp)
                .height(48.dp)
                .clickable { expanded = true },
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color.LightGray),
            color = Color.White
        ) {
            Row(
                modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = selectedUnit, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint = Color(0xFFC62828), // Red dropdown triangle
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(Color.White)
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option, color = Color.Black, fontSize = 13.sp) },
                    onClick = {
                        onUnitSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun CalculatorRow(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    unitSelector: @Composable (() -> Unit)? = null,
    trailingLabel: String? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier.weight(1.1f).padding(end = 4.dp)
        )
        Row(
            modifier = Modifier.weight(1.3f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            BasicTextFieldWithBorder(
                value = value,
                onValueChange = onValueChange,
                placeholder = placeholder,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = if (unitSelector != null || trailingLabel != null) 6.dp else 0.dp)
            )
            if (unitSelector != null) {
                unitSelector()
            } else if (trailingLabel != null) {
                Box(
                    modifier = Modifier
                        .width(85.dp)
                        .height(48.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = trailingLabel,
                        fontSize = 13.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ChemicalSelectorRow(
    selectedChemicalName: String,
    onChemicalSelected: (AcidBaseChemical) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedButton(
            onClick = { showDialog = true },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White,
                contentColor = Color.DarkGray
            ),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (selectedChemicalName.isEmpty()) "Select acid or base" else selectedChemicalName,
                    fontSize = 14.sp,
                    color = if (selectedChemicalName.isEmpty()) Color.Gray else Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint = Color(0xFFC62828),
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Select acid or base", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 18.sp) },
            text = {
                Box(modifier = Modifier.fillMaxWidth().heightIn(max = 350.dp)) {
                    LazyColumn(modifier = Modifier.fillMaxWidth()) {
                        items(chemicalList) { chem ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        onChemicalSelected(chem)
                                        showDialog = false
                                    }
                                    .padding(vertical = 12.dp, horizontal = 4.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column(modifier = Modifier.weight(1f).padding(end = 8.dp)) {
                                    Text(text = chem.name, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                                    Text(
                                        text = "Density: ${chem.density} g/mL | FW: ${chem.formulaWeight} g/mol | ${chem.weightPercent}% w/w",
                                        fontSize = 11.sp,
                                        color = Color.Gray
                                    )
                                }
                                RadioButton(
                                    selected = (selectedChemicalName == chem.name),
                                    onClick = {
                                        onChemicalSelected(chem)
                                        showDialog = false
                                    },
                                    colors = RadioButtonDefaults.colors(selectedColor = Color(0xFFC62828))
                                )
                            }
                            Divider(color = Color.LightGray.copy(alpha = 0.4f))
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Close", color = Color(0xFFC62828), fontWeight = FontWeight.Bold)
                }
            },
            containerColor = Color.White
        )
    }
}

// =========================================================================
// TAB 1: ACID & BASE MOLARITY
// =========================================================================
@Composable
fun AcidBaseMolarityTab() {
    var selectedChemical by remember { mutableStateOf<AcidBaseChemical?>(null) }
    var density by remember { mutableStateOf("") }
    var formulaWeight by remember { mutableStateOf("") }
    var weightPercent by remember { mutableStateOf("") }
    var desiredVolume by remember { mutableStateOf("") }
    var desiredVolumeUnit by remember { mutableStateOf("mL") }
    var desiredConc by remember { mutableStateOf("") }
    var desiredConcUnit by remember { mutableStateOf("Molar") }
    
    var calcResult by remember { mutableStateOf<AcidBaseResult?>(null) }
    var calcError by remember { mutableStateOf<String?>(null) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            Text(
                text = "Acid & Base Molarity",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFC62828),
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }

        // Chemical Selector Dropdown
        item {
            ChemicalSelectorRow(
                selectedChemicalName = selectedChemical?.name ?: "",
                onChemicalSelected = { chem ->
                    selectedChemical = chem
                    density = chem.density.toString()
                    formulaWeight = chem.formulaWeight.toString()
                    weightPercent = chem.weightPercent.toString()
                }
            )
        }

        // Density Field
        item {
            CalculatorRow(
                label = "Density:",
                value = density,
                onValueChange = { density = it },
                trailingLabel = "g/mL"
            )
        }

        // Formula Weight Field
        item {
            CalculatorRow(
                label = "Formula weight:",
                value = formulaWeight,
                onValueChange = { formulaWeight = it },
                trailingLabel = "g/mol"
            )
        }

        // Weight Percentage Field
        item {
            CalculatorRow(
                label = "Weight percentage:",
                value = weightPercent,
                onValueChange = { weightPercent = it },
                trailingLabel = "% w/w"
            )
        }

        // Desired Final Volume Field
        item {
            CalculatorRow(
                label = "Desired final volume:",
                value = desiredVolume,
                onValueChange = { desiredVolume = it },
                unitSelector = {
                    CompactUnitDropdown(
                        selectedUnit = desiredVolumeUnit,
                        options = listOf("L", "mL", "µL"),
                        onUnitSelected = { desiredVolumeUnit = it }
                    )
                }
            )
        }

        // Desired Concentration Field
        item {
            CalculatorRow(
                label = "Desired concentration:",
                value = desiredConc,
                onValueChange = { desiredConc = it },
                unitSelector = {
                    CompactUnitDropdown(
                        selectedUnit = desiredConcUnit,
                        options = listOf("Molar", "Normal", "mM", "µM"),
                        onUnitSelected = { desiredConcUnit = it }
                    )
                }
            )
        }

        // Calculate Button
        item {
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    calcError = null
                    calcResult = null
                    
                    val dVal = density.toDoubleOrNull()
                    val fwVal = formulaWeight.toDoubleOrNull()
                    val wpVal = weightPercent.toDoubleOrNull()
                    val dvVal = desiredVolume.toDoubleOrNull()
                    val dcVal = desiredConc.toDoubleOrNull()

                    if (dVal == null || fwVal == null || wpVal == null || dvVal == null || dcVal == null ||
                        dVal <= 0 || fwVal <= 0 || wpVal <= 0 || dvVal <= 0 || dcVal <= 0) {
                        calcError = "Please enter valid numeric parameters greater than zero."
                        return@Button
                    }
                    if (wpVal > 100.0) {
                        calcError = "Weight percentage cannot exceed 100%!"
                        return@Button
                    }

                    // Calculate stock molarity: (Density * WP * 10) / FW
                    val stockMolarity = (dVal * wpVal * 10.0) / fwVal
                    
                    // Equivalence factor
                    val z = selectedChemical?.equivalenceFactor ?: 1
                    val stockNormality = stockMolarity * z

                    // Convert desired volume to Liters
                    val dvLiters = when (desiredVolumeUnit) {
                        "L" -> dvVal
                        "mL" -> dvVal * 0.001
                        "µL" -> dvVal * 0.000001
                        else -> dvVal * 0.001
                    }

                    // Convert desired concentration to Molar
                    val desiredMolar = when (desiredConcUnit) {
                        "Molar" -> dcVal
                        "Normal" -> dcVal / z
                        "mM" -> dcVal * 0.001
                        "µM" -> dcVal * 0.000001
                        else -> dcVal
                    }

                    if (desiredMolar > stockMolarity) {
                        calcError = "Desired concentration exceeds the stock chemical concentration (${String.format("%.3f", stockMolarity)} M)!"
                        return@Button
                    }

                    // C1V1 = C2V2 => V1 = (C2 * V2) / C1
                    val requiredStockLiters = (desiredMolar * dvLiters) / stockMolarity
                    val requiredStockML = requiredStockLiters * 1000.0
                    val diluentML = (dvLiters - requiredStockLiters) * 1000.0

                    calcResult = AcidBaseResult(
                        stockM = stockMolarity,
                        stockN = stockNormality,
                        requiredVML = requiredStockML,
                        diluentVML = if (diluentML > 0) diluentML else 0.0,
                        chemicalName = selectedChemical?.name ?: "Selected Chemical"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC62828)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Calculate", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }

        // Error Card
        calcError?.let {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFEBEE)),
                    border = BorderStroke(1.dp, Color(0xFFEF5350))
                ) {
                    Text(
                        text = it,
                        color = Color(0xFFC62828),
                        fontSize = 13.sp,
                        modifier = Modifier.padding(12.dp),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        // Success Result Card
        calcResult?.let { res ->
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color(0xFFC62828)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Calculation Result for ${res.chemicalName}:",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFC62828)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        
                        Divider(color = Color.LightGray.copy(alpha = 0.5f))
                        Spacer(modifier = Modifier.height(10.dp))

                        ResultMetricRow(label = "Stock Concentration:", value = "${String.format("%.4f", res.stockM)} M (${String.format("%.4f", res.stockN)} N)")
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        ResultHighlightBox(
                            title = "Required Volume of Chemical:",
                            value = if (res.requiredVML >= 0.1) {
                                "${String.format("%.4f", res.requiredVML)} mL"
                            } else {
                                "${String.format("%.2f", res.requiredVML * 1000.0)} µL"
                            }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        ResultHighlightBox(
                            title = "Volume of Diluent (Water/Solvent):",
                            value = "${String.format("%.3f", res.diluentVML)} mL"
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Instruction: Measure the required volume of stock chemical carefully, add to a flask, and make up to the desired final volume with your solvent.",
                            fontSize = 11.sp,
                            color = Color.Gray,
                            lineHeight = 15.sp
                        )
                    }
                }
            }
        }
    }
}

data class AcidBaseResult(
    val stockM: Double,
    val stockN: Double,
    val requiredVML: Double,
    val diluentVML: Double,
    val chemicalName: String
)

@Composable
fun ResultMetricRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, fontSize = 13.sp, color = Color.DarkGray, fontWeight = FontWeight.Medium)
        Text(text = value, fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ResultHighlightBox(title: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFBE9E7), RoundedCornerShape(6.dp))
            .padding(8.dp)
    ) {
        Text(text = title, fontSize = 11.sp, color = Color(0xFFD84315), fontWeight = FontWeight.Bold)
        Text(text = value, fontSize = 18.sp, color = Color(0xFFBF360C), fontWeight = FontWeight.ExtraBold)
    }
}

// =========================================================================
// TAB 2: GENERAL MOLARITY
// =========================================================================
@Composable
fun GeneralMolarityTab() {
    var formulaWeight by remember { mutableStateOf("") }
    var finalVolume by remember { mutableStateOf("") }
    var finalVolumeUnit by remember { mutableStateOf("L") }
    var targetConc by remember { mutableStateOf("") }
    var targetConcUnit by remember { mutableStateOf("M") }

    var calcResult by remember { mutableStateOf<GeneralMolarityResult?>(null) }
    var calcError by remember { mutableStateOf<String?>(null) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            Text(
                text = "General Molarity",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFC62828),
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }

        // Formula weight
        item {
            CalculatorRow(
                label = "Formula weight:",
                value = formulaWeight,
                onValueChange = { formulaWeight = it },
                trailingLabel = "g/mol"
            )
        }

        // Desired final volume
        item {
            CalculatorRow(
                label = "Desired final volume:",
                value = finalVolume,
                onValueChange = { finalVolume = it },
                unitSelector = {
                    CompactUnitDropdown(
                        selectedUnit = finalVolumeUnit,
                        options = listOf("L", "mL", "µL"),
                        onUnitSelected = { finalVolumeUnit = it }
                    )
                }
            )
        }

        // Desired concentration
        item {
            CalculatorRow(
                label = "Desired concentration:",
                value = targetConc,
                onValueChange = { targetConc = it },
                unitSelector = {
                    CompactUnitDropdown(
                        selectedUnit = targetConcUnit,
                        options = listOf("M", "mM", "µM", "nM"),
                        onUnitSelected = { targetConcUnit = it }
                    )
                }
            )
        }

        // Calculate Button
        item {
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    calcError = null
                    calcResult = null

                    val fwVal = formulaWeight.toDoubleOrNull()
                    val vVal = finalVolume.toDoubleOrNull()
                    val cVal = targetConc.toDoubleOrNull()

                    if (fwVal == null || vVal == null || cVal == null ||
                        fwVal <= 0 || vVal <= 0 || cVal <= 0) {
                        calcError = "Please enter valid parameters greater than zero."
                        return@Button
                    }

                    // Convert volume to liters
                    val vLiters = when (finalVolumeUnit) {
                        "L" -> vVal
                        "mL" -> vVal * 0.001
                        "µL" -> vVal * 0.000001
                        else -> vVal
                    }

                    // Convert concentration to Molar
                    val cMolar = when (targetConcUnit) {
                        "M" -> cVal
                        "mM" -> cVal * 0.001
                        "µM" -> cVal * 0.000001
                        "nM" -> cVal * 0.000000001
                        else -> cVal
                    }

                    // Mass (g) = Molar * Liters * FormulaWeight
                    val massGrams = cMolar * vLiters * fwVal

                    calcResult = GeneralMolarityResult(
                        massGrams = massGrams,
                        vLiters = vLiters,
                        cMolar = cMolar,
                        fw = fwVal
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC62828)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Calculate", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }

        // Error Card
        calcError?.let {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFEBEE)),
                    border = BorderStroke(1.dp, Color(0xFFEF5350))
                ) {
                    Text(
                        text = it,
                        color = Color(0xFFC62828),
                        fontSize = 13.sp,
                        modifier = Modifier.padding(12.dp),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        // Success Result Card
        calcResult?.let { res ->
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color(0xFFC62828)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Required Solute Mass:",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFC62828)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Divider(color = Color.LightGray.copy(alpha = 0.5f))
                        Spacer(modifier = Modifier.height(10.dp))

                        ResultHighlightBox(
                            title = "Mass (Grams):",
                            value = if (res.massGrams >= 0.1) {
                                "${String.format("%.4f", res.massGrams)} g"
                            } else {
                                "${String.format("%.2f", res.massGrams * 1000.0)} mg"
                            }
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        ResultMetricRow(label = "Molecular Weight:", value = "${res.fw} g/mol")
                        Spacer(modifier = Modifier.height(6.dp))
                        ResultMetricRow(label = "Volume:", value = "${String.format("%.6f", res.vLiters)} L")
                        Spacer(modifier = Modifier.height(6.dp))
                        ResultMetricRow(label = "Molarity:", value = "${String.format("%.6f", res.cMolar)} M")
                    }
                }
            }
        }
    }
}

data class GeneralMolarityResult(
    val massGrams: Double,
    val vLiters: Double,
    val cMolar: Double,
    val fw: Double
)

// =========================================================================
// TAB 3: STOCK SOLUTION DILUTION
// =========================================================================
@Composable
fun StockDilutionTab() {
    var stockConc by remember { mutableStateOf("") }
    var stockConcUnit by remember { mutableStateOf("M") }
    var finalVolume by remember { mutableStateOf("") }
    var finalVolumeUnit by remember { mutableStateOf("L") }
    var desiredConc by remember { mutableStateOf("") }
    var desiredConcUnit by remember { mutableStateOf("M") }

    var calcResult by remember { mutableStateOf<StockDilutionResult?>(null) }
    var calcError by remember { mutableStateOf<String?>(null) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            Text(
                text = "Stock Solution Dilution",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFC62828),
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }

        // Stock concentration
        item {
            CalculatorRow(
                label = "Stock concentration:",
                value = stockConc,
                onValueChange = { stockConc = it },
                unitSelector = {
                    CompactUnitDropdown(
                        selectedUnit = stockConcUnit,
                        options = listOf("M", "mM", "µM"),
                        onUnitSelected = { stockConcUnit = it }
                    )
                }
            )
        }

        // Desired final volume
        item {
            CalculatorRow(
                label = "Desired final volume:",
                value = finalVolume,
                onValueChange = { finalVolume = it },
                unitSelector = {
                    CompactUnitDropdown(
                        selectedUnit = finalVolumeUnit,
                        options = listOf("L", "mL", "µL"),
                        onUnitSelected = { finalVolumeUnit = it }
                    )
                }
            )
        }

        // Desired concentration
        item {
            CalculatorRow(
                label = "Desired concentration:",
                value = desiredConc,
                onValueChange = { desiredConc = it },
                unitSelector = {
                    CompactUnitDropdown(
                        selectedUnit = desiredConcUnit,
                        options = listOf("M", "mM", "µM"),
                        onUnitSelected = { desiredConcUnit = it }
                    )
                }
            )
        }

        // Calculate Button
        item {
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    calcError = null
                    calcResult = null

                    val c1Val = stockConc.toDoubleOrNull()
                    val v2Val = finalVolume.toDoubleOrNull()
                    val c2Val = desiredConc.toDoubleOrNull()

                    if (c1Val == null || v2Val == null || c2Val == null ||
                        c1Val <= 0 || v2Val <= 0 || c2Val <= 0) {
                        calcError = "Please enter valid numeric parameters greater than zero."
                        return@Button
                    }

                    // Convert C1 to standard unit (Molar)
                    val c1M = when (stockConcUnit) {
                        "M" -> c1Val
                        "mM" -> c1Val * 0.001
                        "µM" -> c1Val * 0.000001
                        else -> c1Val
                    }

                    // Convert C2 to standard unit (Molar)
                    val c2M = when (desiredConcUnit) {
                        "M" -> c2Val
                        "mM" -> c2Val * 0.001
                        "µM" -> c2Val * 0.000001
                        else -> c2Val
                    }

                    if (c2M > c1M) {
                        calcError = "Desired concentration cannot be greater than Stock concentration!"
                        return@Button
                    }

                    // Convert V2 to standard unit (mL)
                    val v2mL = when (finalVolumeUnit) {
                        "L" -> v2Val * 1000.0
                        "mL" -> v2Val
                        "µL" -> v2Val * 0.001
                        else -> v2Val
                    }

                    // V1 = (C2 * V2) / C1
                    val v1mL = (c2M * v2mL) / c1M
                    val diluentML = v2mL - v1mL

                    calcResult = StockDilutionResult(
                        v1mL = v1mL,
                        diluentML = if (diluentML > 0) diluentML else 0.0,
                        v2mL = v2mL,
                        c1M = c1M,
                        c2M = c2M
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC62828)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Calculate", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }

        // Error Card
        calcError?.let {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFEBEE)),
                    border = BorderStroke(1.dp, Color(0xFFEF5350))
                ) {
                    Text(
                        text = it,
                        color = Color(0xFFC62828),
                        fontSize = 13.sp,
                        modifier = Modifier.padding(12.dp),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        // Success Result Card
        calcResult?.let { res ->
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color(0xFFC62828)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Dilution Recipe:",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFC62828)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Divider(color = Color.LightGray.copy(alpha = 0.5f))
                        Spacer(modifier = Modifier.height(10.dp))

                        ResultHighlightBox(
                            title = "Required Volume of Stock (V1):",
                            value = if (res.v1mL >= 0.1) {
                                "${String.format("%.4f", res.v1mL)} mL"
                            } else {
                                "${String.format("%.2f", res.v1mL * 1000.0)} µL"
                            }
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        ResultHighlightBox(
                            title = "Volume of Diluent (Water/Solvent):",
                            value = "${String.format("%.3f", res.diluentML)} mL"
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Instruction: Measure the stock solution, add it to your diluent, and mix thoroughly to produce the desired final volume and concentration.",
                            fontSize = 11.sp,
                            color = Color.Gray,
                            lineHeight = 15.sp
                        )
                    }
                }
            }
        }
    }
}

data class StockDilutionResult(
    val v1mL: Double,
    val diluentML: Double,
    val v2mL: Double,
    val c1M: Double,
    val c2M: Double
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RsdCalculatorSuite(onBackClick: () -> Unit) {
    var injectionInputs by remember { mutableStateOf(listOf("", "", "", "", "", "")) }
    var showInfoDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9))
    ) {
        // 1. TOP HEADER (Aldrich Style Red Bar)
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFC62828), // Authentic Aldrich Red
            shadowElevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onBackClick) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Column {
                        Text(
                            text = "RSD Calculator",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "HPLC Peak Area Precision & Suitability",
                            fontWeight = FontWeight.Medium,
                            color = Color.White.copy(alpha = 0.85f),
                            fontSize = 11.sp
                        )
                    }
                }
                IconButton(onClick = { showInfoDialog = true }) {
                    Icon(imageVector = Icons.Default.Info, contentDescription = "Info", tint = Color.White)
                }
            }
        }

        // Info Dialog
        if (showInfoDialog) {
            AlertDialog(
                onDismissRequest = { showInfoDialog = false },
                title = { Text("HPLC Peak RSD Suitability", fontWeight = FontWeight.Bold, color = Color.Black) },
                text = {
                    Text(
                        "Relative Standard Deviation (RSD %) is a critical parameter in HPLC system suitability tests (SST):\n\n" +
                        "• Assay Replicates (usually n = 5 or 6):\n" +
                        "  USP standard limit is %RSD ≤ 2.0% (active drugs) or ≤ 1.0% (highly critical assays).\n\n" +
                        "• Sample/Standard Deviation:\n" +
                        "  Uses the sample standard deviation formula (divided by n-1).\n\n" +
                        "Enter replicate peak areas to monitor system suitability instantly.",
                        fontSize = 13.sp,
                        color = Color.DarkGray
                    )
                },
                confirmButton = {
                    TextButton(onClick = { showInfoDialog = false }) {
                        Text("Got it")
                    }
                }
            )
        }

        // 2. CONTENT
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Calculation Block
            item {
                val values = injectionInputs.mapNotNull { it.toDoubleOrNull() }
                val count = values.size
                var mean = 0.0
                var sd = 0.0
                var rsd = 0.0

                if (count >= 2) {
                    mean = values.average()
                    val sumOfSquares = values.sumOf { (it - mean) * (it - mean) }
                    val variance = sumOfSquares / (count - 1)
                    sd = kotlin.math.sqrt(variance)
                    rsd = if (mean != 0.0) (sd / mean) * 100.0 else 0.0
                }

                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.5f)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "SUITABILITY STATISTICS",
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Replicates (N)", fontSize = 11.sp, color = Color.Gray)
                                Text("$count", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFFC62828))
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Mean Area", fontSize = 11.sp, color = Color.Gray)
                                Text(
                                    text = if (count > 0) String.format("%,.2f", mean) else "—",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Std. Dev (SD)", fontSize = 11.sp, color = Color.Gray)
                                Text(
                                    text = if (count >= 2) String.format("%,.2f", sd) else "—",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.DarkGray
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Relative Std. Dev (%RSD)", fontSize = 11.sp, color = Color.Gray)
                                Text(
                                    text = if (count >= 2) String.format("%.3f %%", rsd) else "—",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (rsd <= 2.0 && count >= 2) Color(0xFF2E7D32) else if (count >= 2) Color(0xFFC62828) else Color.Gray
                                )
                            }
                        }

                        if (count >= 2) {
                            Spacer(modifier = Modifier.height(16.dp))
                            val passed = rsd <= 2.0
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = if (passed) Color(0xFFE8F5E9) else Color(0xFFFFEBEE),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = if (passed) Icons.Default.CheckCircle else Icons.Default.Warning,
                                        contentDescription = if (passed) "Pass" else "Fail",
                                        tint = if (passed) Color(0xFF2E7D32) else Color(0xFFC62828),
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(
                                        text = if (passed) {
                                            "SYSTEM SUITABLE: Peak precision meets USP criteria for drug assay suitability (%RSD ≤ 2.0%)."
                                        } else {
                                            "OUT OF SPECIFICATION: Precision fails USP suitability limit of 2.0% for drug assays."
                                        },
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (passed) Color(0xFF2E7D32) else Color(0xFFC62828),
                                        lineHeight = 14.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Input Fields List
            item {
                Text(
                    text = "Enter Replicate Chromatogram Areas:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }

            items(injectionInputs.size) { index ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.3f)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Injection #${index + 1}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = Color.DarkGray,
                            modifier = Modifier.weight(0.3f)
                        )
                        OutlinedTextField(
                            value = injectionInputs[index],
                            onValueChange = { newVal ->
                                val updated = injectionInputs.toMutableList()
                                updated[index] = newVal
                                injectionInputs = updated
                            },
                            placeholder = { Text("e.g. 1245089") },
                            modifier = Modifier
                                .weight(0.5f)
                                .testTag("rsd_input_field_$index"),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                focusedBorderColor = Color(0xFFC62828),
                                cursorColor = Color(0xFFC62828),
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White
                            )
                        )
                        IconButton(
                            onClick = {
                                if (injectionInputs.size > 2) {
                                    val updated = injectionInputs.toMutableList()
                                    updated.removeAt(index)
                                    injectionInputs = updated
                                }
                            },
                            modifier = Modifier.weight(0.2f)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete Replicate",
                                tint = Color.Gray.copy(alpha = 0.8f)
                            )
                        }
                    }
                }
            }

            // Controls
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {
                            val updated = injectionInputs.toMutableList()
                            updated.add("")
                            injectionInputs = updated
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                        modifier = Modifier.weight(1.5f)
                    ) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Add Injection", fontSize = 12.sp)
                    }

                    OutlinedButton(
                        onClick = {
                            injectionInputs = listOf("", "", "", "", "", "")
                        },
                        border = BorderStroke(1.dp, Color(0xFFC62828)),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFC62828)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Clear All", fontSize = 12.sp)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PressureTempNomographSuite(onBackClick: () -> Unit) {
    var mode by remember { mutableStateOf(1) } // 0: Calculate A, 1: Calculate B, 2: Calculate C
    var obsBPSource by remember { mutableStateOf("100.0") } // A
    var normalBPSource by remember { mutableStateOf("364.5") } // B
    var pressureSource by remember { mutableStateOf("0.0100") } // C

    var obsBPUnit by remember { mutableStateOf("°C") }
    var normalBPUnit by remember { mutableStateOf("°C") }
    var pressureUnit by remember { mutableStateOf("mmHg") }

    var showInfoDialog by remember { mutableStateOf(false) }

    // Convert units helper
    fun toCelsius(valStr: String, unit: String): Double? {
        val v = valStr.toDoubleOrNull() ?: return null
        return when (unit) {
            "°F" -> (v - 32.0) * 5.0 / 9.0
            "K" -> v - 273.15
            else -> v
        }
    }

    fun fromCelsius(v: Double, unit: String): Double {
        return when (unit) {
            "°F" -> (v * 9.0 / 5.0) + 32.0
            "K" -> v + 273.15
            else -> v
        }
    }

    fun tommHg(valStr: String, unit: String): Double? {
        val v = valStr.toDoubleOrNull() ?: return null
        return when (unit) {
            "Torr" -> v
            "mbar" -> v * 0.750062
            "atm" -> v * 760.0
            else -> v
        }
    }

    fun frommmHg(v: Double, unit: String): Double {
        return when (unit) {
            "Torr" -> v
            "mbar" -> v / 0.750062
            "atm" -> v / 760.0
            else -> v
        }
    }

    // Interactive Calculations based on formulas
    var calculatedA: Double? = null
    var calculatedB: Double? = null
    var calculatedC: Double? = null

    // Values in default units (°C and mmHg)
    val inputObsCelsius = toCelsius(obsBPSource, obsBPUnit)
    val inputNormalCelsius = toCelsius(normalBPSource, normalBPUnit)
    val inputPressuremmHg = tommHg(pressureSource, pressureUnit)

    // Calculate third value
    when (mode) {
        0 -> { // Calculate A (Observed BP)
            if (inputNormalCelsius != null && inputPressuremmHg != null && inputPressuremmHg > 0.0) {
                val tB_K = inputNormalCelsius + 273.15
                val logRatio = kotlin.math.log10(760.0 / inputPressuremmHg)
                val invTA = (1.0 / tB_K) + (2.277e-4 * logRatio)
                if (invTA > 0.0) {
                    val tA_C = (1.0 / invTA) - 273.15
                    calculatedA = fromCelsius(tA_C, obsBPUnit)
                }
            }
        }
        1 -> { // Calculate B (Normal BP)
            if (inputObsCelsius != null && inputPressuremmHg != null && inputPressuremmHg > 0.0) {
                val tA_K = inputObsCelsius + 273.15
                val logRatio = kotlin.math.log10(760.0 / inputPressuremmHg)
                val invTB = (1.0 / tA_K) - (2.277e-4 * logRatio)
                if (invTB > 0.0) {
                    val tB_C = (1.0 / invTB) - 273.15
                    calculatedB = fromCelsius(tB_C, normalBPUnit)
                }
            }
        }
        else -> { // Calculate C (Pressure)
            if (inputObsCelsius != null && inputNormalCelsius != null && inputObsCelsius < inputNormalCelsius) {
                val tA_K = inputObsCelsius + 273.15
                val tB_K = inputNormalCelsius + 273.15
                val diff = (1.0 / tA_K) - (1.0 / tB_K)
                if (diff > 0.0) {
                    val logRatio = diff / 2.277e-4
                    val p = 760.0 * java.lang.Math.pow(10.0, -logRatio)
                    calculatedC = frommmHg(p, pressureUnit)
                }
            }
        }
    }

    // Active displayed values for canvas drawing (must be in °C and mmHg)
    val drawObsBP = when (mode) {
        0 -> if (calculatedA != null) toCelsius(String.format("%.2f", calculatedA), obsBPUnit) ?: 100.0 else 100.0
        else -> inputObsCelsius ?: 100.0
    }
    val drawNormalBP = when (mode) {
        1 -> if (calculatedB != null) toCelsius(String.format("%.2f", calculatedB), normalBPUnit) ?: 364.5 else 364.5
        else -> inputNormalCelsius ?: 364.5
    }
    val drawPressure = when (mode) {
        2 -> if (calculatedC != null) tommHg(String.format("%.4f", calculatedC), pressureUnit) ?: 0.01 else 0.01
        else -> inputPressuremmHg ?: 0.01
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9))
    ) {
        // 1. TOP HEADER (Aldrich Style Red Bar)
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFC62828), // Authentic Aldrich Red
            shadowElevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onBackClick) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Column {
                        Text(
                            text = "P-T Nomograph Tool",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "Pressure-Temperature Boiling Point Correction",
                            fontWeight = FontWeight.Medium,
                            color = Color.White.copy(alpha = 0.85f),
                            fontSize = 11.sp
                        )
                    }
                }
                IconButton(onClick = { showInfoDialog = true }) {
                    Icon(imageVector = Icons.Default.Info, contentDescription = "Info", tint = Color.White)
                }
            }
        }

        // Info Dialog
        if (showInfoDialog) {
            AlertDialog(
                onDismissRequest = { showInfoDialog = false },
                title = { Text("Pressure-Temperature Nomograph", fontWeight = FontWeight.Bold, color = Color.Black) },
                text = {
                    Text(
                        "The Pressure-Temperature Nomograph estimates the boiling point of a liquid under vacuum (reduced pressure):\n\n" +
                        "• Scale A (Observed BP):\n" +
                        "  The actual boiling temperature observed under vacuum.\n\n" +
                        "• Scale B (Normal BP):\n" +
                        "  The corrected boiling temperature at 1 atmosphere (760 mmHg).\n\n" +
                        "• Scale C (Pressure 'P'):\n" +
                        "  The distillation pressure in mmHg, Torr, mbar, or atm.\n\n" +
                        "Select which parameter you want to calculate, enter the other two, and see the interactive nomograph chart update in real time.",
                        fontSize = 13.sp,
                        color = Color.DarkGray
                    )
                },
                confirmButton = {
                    TextButton(onClick = { showInfoDialog = false }) {
                        Text("Got it")
                    }
                }
            )
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Interactive Nomograph Canvas Diagram!
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.5f)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp)
                    ) {
                        Text(
                            text = "INTERACTIVE NOMOGRAPH DIAGRAM",
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth().padding(bottom = 6.dp)
                        )

                        // Compose Canvas
                        androidx.compose.foundation.Canvas(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                        ) {
                            val w = size.width
                            val h = size.height

                            // Define positions of three parallel scales
                            val xA = w * 0.15f
                            val xB = w * 0.50f
                            val xC = w * 0.85f

                            // Draw parallel scales vertical lines
                            val strokeWidth = 2.dp.toPx()
                            drawLine(Color.LightGray, start = androidx.compose.ui.geometry.Offset(xA, h * 0.05f), end = androidx.compose.ui.geometry.Offset(xA, h * 0.95f), strokeWidth = strokeWidth)
                            drawLine(Color.LightGray, start = androidx.compose.ui.geometry.Offset(xB, h * 0.05f), end = androidx.compose.ui.geometry.Offset(xB, h * 0.95f), strokeWidth = strokeWidth)
                            drawLine(Color.LightGray, start = androidx.compose.ui.geometry.Offset(xC, h * 0.05f), end = androidx.compose.ui.geometry.Offset(xC, h * 0.95f), strokeWidth = strokeWidth)

                            // Tick drawing function
                            fun drawTicks(x: Float, labelCount: Int, minVal: Double, maxVal: Double, isLog: Boolean = false) {
                                for (i in 0..labelCount) {
                                    val pct = i.toFloat() / labelCount
                                    val y = h * 0.95f - pct * (h * 0.90f)
                                    drawLine(
                                        color = Color.Gray,
                                        start = androidx.compose.ui.geometry.Offset(x - 5.dp.toPx(), y),
                                        end = androidx.compose.ui.geometry.Offset(x + 5.dp.toPx(), y),
                                        strokeWidth = 1.dp.toPx()
                                    )
                                }
                            }

                            // Scale A ticks: 0 to 400
                            drawTicks(xA, 4, 0.0, 400.0)
                            // Scale B ticks: 0 to 700
                            drawTicks(xB, 7, 0.0, 700.0)
                            // Scale C ticks: 0.01 to 760 (Logarithmic)
                            drawTicks(xC, 4, 0.01, 760.0, isLog = true)

                            // Calculate y positions for active values
                            val yA = h * 0.95f - ((drawObsBP.coerceIn(0.0, 400.0) / 400.0).toFloat() * (h * 0.90f))
                            val yB = h * 0.95f - ((drawNormalBP.coerceIn(0.0, 700.0) / 700.0).toFloat() * (h * 0.90f))

                            val pVal = drawPressure.coerceIn(0.01, 760.0)
                            val logP = kotlin.math.log10(pVal)
                            val logMin = kotlin.math.log10(0.01)
                            val logMax = kotlin.math.log10(760.0)
                            val pPct = ((logP - logMin) / (logMax - logMin)).toFloat()
                            val yC = h * 0.95f - (pPct * (h * 0.90f))

                            // Draw Nomograph intersecting line (pink color in user screenshot)
                            drawLine(
                                color = Color(0xFFFF4081), // Beautiful Pink line
                                start = androidx.compose.ui.geometry.Offset(xA, yA),
                                end = androidx.compose.ui.geometry.Offset(xC, yC),
                                strokeWidth = 3.dp.toPx()
                            )

                            // Draw circle nodes at intersections
                            drawCircle(color = Color(0xFFC62828), radius = 6.dp.toPx(), center = androidx.compose.ui.geometry.Offset(xA, yA))
                            drawCircle(color = Color(0xFFC62828), radius = 6.dp.toPx(), center = androidx.compose.ui.geometry.Offset(xB, yB))
                            drawCircle(color = Color(0xFFC62828), radius = 6.dp.toPx(), center = androidx.compose.ui.geometry.Offset(xC, yC))
                        }

                        // Labels row at the bottom of diagram
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Observed BP\n(Scale A)", fontSize = 10.sp, color = Color.Gray, textAlign = TextAlign.Center, modifier = Modifier.weight(1f))
                            Text("Normal BP\n(Scale B)", fontSize = 10.sp, color = Color.Gray, textAlign = TextAlign.Center, modifier = Modifier.weight(1f))
                            Text("Pressure\n(Scale C)", fontSize = 10.sp, color = Color.Gray, textAlign = TextAlign.Center, modifier = Modifier.weight(1f))
                        }
                    }
                }
            }

            // Calculation controls
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.5f)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Calculation Target Setting:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = Color.Gray
                        )

                        // Segmented target selection
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(38.dp)
                                .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                                .clip(RoundedCornerShape(8.dp))
                        ) {
                            // Target A
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .background(if (mode == 0) Color(0xFFC62828) else Color.Transparent)
                                    .clickable { mode = 0 }
                            ) {
                                Text("Calc A", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = if (mode == 0) Color.White else Color.DarkGray)
                            }
                            // Target B
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .background(if (mode == 1) Color(0xFFC62828) else Color.Transparent)
                                    .clickable { mode = 1 }
                            ) {
                                Text("Calc B", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = if (mode == 1) Color.White else Color.DarkGray)
                            }
                            // Target C
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .background(if (mode == 2) Color(0xFFC62828) else Color.Transparent)
                                    .clickable { mode = 2 }
                            ) {
                                Text("Calc C", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = if (mode == 2) Color.White else Color.DarkGray)
                            }
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        // FIELD A: Observed Boiling Point
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = if (mode == 0) Icons.Default.LockOpen else Icons.Default.Lock,
                                contentDescription = if (mode == 0) "Calculated Output" else "User Input",
                                tint = if (mode == 0) Color(0xFFC62828) else Color.Gray,
                                modifier = Modifier.size(18.dp)
                            )
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "A) Observed Boiling Point" + if (mode == 0) " (Calculated)" else "",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (mode == 0) Color(0xFFC62828) else Color.Black
                                )
                                OutlinedTextField(
                                    value = if (mode == 0) (calculatedA?.let { String.format("%.2f", it) } ?: "—") else obsBPSource,
                                    onValueChange = { if (mode != 0) obsBPSource = it },
                                    enabled = (mode != 0),
                                    placeholder = { Text("e.g. 100.0") },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .testTag("nomograph_input_A"),
                                    singleLine = true,
                                    colors = OutlinedTextFieldDefaults.colors(
                                        focusedBorderColor = Color(0xFFC62828),
                                        cursorColor = Color(0xFFC62828),
                                        disabledTextColor = Color(0xFF2E7D32),
                                        disabledBorderColor = Color(0xFF2E7D32).copy(alpha = 0.5f),
                                        disabledContainerColor = Color(0xFFE8F5E9).copy(alpha = 0.5f)
                                    )
                                )
                            }
                            // Unit A Dropdown
                            Box(modifier = Modifier.width(76.dp).padding(top = 16.dp)) {
                                var expanded by remember { mutableStateOf(false) }
                                OutlinedButton(
                                    onClick = { expanded = true },
                                    modifier = Modifier.fillMaxWidth().height(52.dp),
                                    shape = RoundedCornerShape(4.dp),
                                    border = BorderStroke(1.dp, Color.Gray),
                                    contentPadding = PaddingValues(0.dp)
                                ) {
                                    Text(obsBPUnit, fontSize = 12.sp, color = Color.DarkGray)
                                }
                                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                                    listOf("°C", "°F", "K").forEach { unit ->
                                        DropdownMenuItem(
                                            text = { Text(unit) },
                                            onClick = {
                                                obsBPUnit = unit
                                                expanded = false
                                            }
                                        )
                                    }
                                }
                            }
                        }

                        // FIELD B: Corrected Boiling Point at 1 atm
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = if (mode == 1) Icons.Default.LockOpen else Icons.Default.Lock,
                                contentDescription = if (mode == 1) "Calculated Output" else "User Input",
                                tint = if (mode == 1) Color(0xFFC62828) else Color.Gray,
                                modifier = Modifier.size(18.dp)
                            )
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "B) Normal BP Corrected at 1 atm" + if (mode == 1) " (Calculated)" else "",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (mode == 1) Color(0xFFC62828) else Color.Black
                                )
                                OutlinedTextField(
                                    value = if (mode == 1) (calculatedB?.let { String.format("%.2f", it) } ?: "—") else normalBPSource,
                                    onValueChange = { if (mode != 1) normalBPSource = it },
                                    enabled = (mode != 1),
                                    placeholder = { Text("e.g. 364.5") },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .testTag("nomograph_input_B"),
                                    singleLine = true,
                                    colors = OutlinedTextFieldDefaults.colors(
                                        focusedBorderColor = Color(0xFFC62828),
                                        cursorColor = Color(0xFFC62828),
                                        disabledTextColor = Color(0xFF2E7D32),
                                        disabledBorderColor = Color(0xFF2E7D32).copy(alpha = 0.5f),
                                        disabledContainerColor = Color(0xFFE8F5E9).copy(alpha = 0.5f)
                                    )
                                )
                            }
                            // Unit B Dropdown
                            Box(modifier = Modifier.width(76.dp).padding(top = 16.dp)) {
                                var expanded by remember { mutableStateOf(false) }
                                OutlinedButton(
                                    onClick = { expanded = true },
                                    modifier = Modifier.fillMaxWidth().height(52.dp),
                                    shape = RoundedCornerShape(4.dp),
                                    border = BorderStroke(1.dp, Color.Gray),
                                    contentPadding = PaddingValues(0.dp)
                                ) {
                                    Text(normalBPUnit, fontSize = 12.sp, color = Color.DarkGray)
                                }
                                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                                    listOf("°C", "°F", "K").forEach { unit ->
                                        DropdownMenuItem(
                                            text = { Text(unit) },
                                            onClick = {
                                                normalBPUnit = unit
                                                expanded = false
                                            }
                                        )
                                    }
                                }
                            }
                        }

                        // FIELD C: Pressure "P"
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = if (mode == 2) Icons.Default.LockOpen else Icons.Default.Lock,
                                contentDescription = if (mode == 2) "Calculated Output" else "User Input",
                                tint = if (mode == 2) Color(0xFFC62828) else Color.Gray,
                                modifier = Modifier.size(18.dp)
                            )
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "C) Pressure \"P\"" + if (mode == 2) " (Calculated)" else "",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (mode == 2) Color(0xFFC62828) else Color.Black
                                )
                                OutlinedTextField(
                                    value = if (mode == 2) (calculatedC?.let { if (it < 0.001) String.format("%.6f", it) else String.format("%.4f", it) } ?: "—") else pressureSource,
                                    onValueChange = { if (mode != 2) pressureSource = it },
                                    enabled = (mode != 2),
                                    placeholder = { Text("e.g. 0.0100") },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .testTag("nomograph_input_C"),
                                    singleLine = true,
                                    colors = OutlinedTextFieldDefaults.colors(
                                        focusedBorderColor = Color(0xFFC62828),
                                        cursorColor = Color(0xFFC62828),
                                        disabledTextColor = Color(0xFF2E7D32),
                                        disabledBorderColor = Color(0xFF2E7D32).copy(alpha = 0.5f),
                                        disabledContainerColor = Color(0xFFE8F5E9).copy(alpha = 0.5f)
                                    )
                                )
                            }
                            // Unit C Dropdown
                            Box(modifier = Modifier.width(76.dp).padding(top = 16.dp)) {
                                var expanded by remember { mutableStateOf(false) }
                                OutlinedButton(
                                    onClick = { expanded = true },
                                    modifier = Modifier.fillMaxWidth().height(52.dp),
                                    shape = RoundedCornerShape(4.dp),
                                    border = BorderStroke(1.dp, Color.Gray),
                                    contentPadding = PaddingValues(0.dp)
                                ) {
                                    Text(pressureUnit, fontSize = 12.sp, color = Color.DarkGray)
                                }
                                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                                    listOf("mmHg", "Torr", "mbar", "atm").forEach { unit ->
                                        DropdownMenuItem(
                                            text = { Text(unit) },
                                            onClick = {
                                                pressureUnit = unit
                                                expanded = false
                                            }
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

@Composable
fun VolumeConverterWidget() {
    var activeUnit by remember { mutableStateOf<String?>("L") }
    var activeValueStr by remember { mutableStateOf("1.0") }
    val activeValue = activeValueStr.toDoubleOrNull()

    val unitToBaseM3 = mapOf(
        "m3" to 1.0,
        "hL" to 0.1,
        "L" to 0.001,
        "dL" to 0.0001,
        "mL" to 1e-6,
        "uL" to 1e-9,
        "gal" to 0.003785411784,
        "pt" to 0.000473176473,
        "oz" to 2.95735295625e-5,
        "in3" to 1.6387064e-5
    )

    val labels = mapOf(
        "m3" to "m³ (cubic meter)",
        "hL" to "hL (hectoliter)",
        "L" to "l (liter)",
        "dL" to "dL (deciliter)",
        "mL" to "mL (milliliter)",
        "uL" to "µL (microliter)",
        "gal" to "gal (gallon (US liq.))",
        "pt" to "pt (pint (US liq.))",
        "oz" to "oz (fluid ounce (US))",
        "in3" to "in³ (cubic inch)"
    )

    val baseValueInM3 = activeValue?.let { it * unitToBaseM3[activeUnit]!! }

    Text(
        text = "Geometric References:\n• Cube: a³ (a = side length)\n• Rectangle: l × w × h\n• Sphere: 4/3 π r³\n• Cylinder: π r² h\n• Cone: 1/3 π r² h",
        fontSize = 11.sp,
        color = Color.Gray,
        lineHeight = 14.sp,
        modifier = Modifier.padding(bottom = 8.dp)
    )

    unitToBaseM3.keys.forEach { unitKey ->
        val displayValue = if (unitKey == activeUnit) {
            activeValueStr
        } else {
            baseValueInM3?.let { it / unitToBaseM3[unitKey]!! }?.let {
                if (it == 0.0) "0" else String.format("%.6g", it).trimEnd('0').trimEnd('.')
            } ?: ""
        }

        CalculatorRow(
            label = labels[unitKey] ?: "",
            value = displayValue,
            onValueChange = {
                activeUnit = unitKey
                activeValueStr = it
            },
            placeholder = "0.0",
            trailingLabel = unitKey
        )
    }
}

@Composable
fun PressureConverterWidget() {
    var activeUnit by remember { mutableStateOf<String?>("bar") }
    var activeValueStr by remember { mutableStateOf("1.0") }
    val activeValue = activeValueStr.toDoubleOrNull()

    val unitToBasePa = mapOf(
        "bar" to 100000.0,
        "psi" to 6894.757293168,
        "kPa" to 1000.0,
        "hPa" to 100.0,
        "MPa" to 1000000.0,
        "mbar" to 100.0,
        "Pa" to 1.0,
        "kgf_cm2" to 98066.5,
        "kgf_m2" to 9.80665,
        "N_m2" to 1.0,
        "kN_m2" to 1000.0,
        "MN_m2" to 1000000.0,
        "N_cm2" to 10000.0,
        "torr" to 133.322368421,
        "mH2O" to 9806.65,
        "atm" to 101325.0
    )

    val labels = mapOf(
        "bar" to "bar",
        "psi" to "psi (lb/in²)",
        "kPa" to "kPa (kilopascal)",
        "hPa" to "hPa (hectopascal)",
        "MPa" to "MPa (megapascal)",
        "mbar" to "mbar (millibar)",
        "Pa" to "Pa (pascal)",
        "kgf_cm2" to "kgf/cm²",
        "kgf_m2" to "kgf/m²",
        "N_m2" to "N/m²",
        "kN_m2" to "kN/m²",
        "MN_m2" to "MN/m²",
        "N_cm2" to "N/cm²",
        "torr" to "torr (mmHg)",
        "mH2O" to "mH₂O (meter water)",
        "atm" to "atm (atmosphere)"
    )

    val baseValueInPa = activeValue?.let { it * unitToBasePa[activeUnit]!! }

    Text(
        text = "Formula: Pressure = Force / Area\nType in any field to convert dynamically across all standard international pressure scales.",
        fontSize = 11.sp,
        color = Color.Gray,
        lineHeight = 14.sp,
        modifier = Modifier.padding(bottom = 8.dp)
    )

    unitToBasePa.keys.forEach { unitKey ->
        val displayValue = if (unitKey == activeUnit) {
            activeValueStr
        } else {
            baseValueInPa?.let { it / unitToBasePa[unitKey]!! }?.let {
                if (it == 0.0) "0" else String.format("%.6g", it).trimEnd('0').trimEnd('.')
            } ?: ""
        }

        CalculatorRow(
            label = labels[unitKey] ?: "",
            value = displayValue,
            onValueChange = {
                activeUnit = unitKey
                activeValueStr = it
            },
            placeholder = "0.0",
            trailingLabel = unitKey.replace("_", "/")
        )
    }
}

@Composable
fun MassConverterWidget() {
    var activeUnit by remember { mutableStateOf<String?>("kg") }
    var activeValueStr by remember { mutableStateOf("1.0") }
    val activeValue = activeValueStr.toDoubleOrNull()

    val unitToBaseG = mapOf(
        "t" to 1000000.0,
        "kg" to 1000.0,
        "g" to 1.0,
        "mg" to 0.001,
        "ug" to 1e-6,
        "ng" to 1e-9,
        "pg" to 1e-12,
        "st" to 6350.29318,
        "lb" to 453.59237,
        "oz" to 28.349523125,
        "ct" to 0.2,
        "amu" to 1.6605390666e-24
    )

    val labels = mapOf(
        "t" to "t (tonne)",
        "kg" to "kg (kilogram)",
        "g" to "g (gram)",
        "mg" to "mg (milligram)",
        "ug" to "µg (microgram)",
        "ng" to "ng (nanogram)",
        "pg" to "pg (picogram)",
        "st" to "st (stone)",
        "lb" to "lb (pound)",
        "oz" to "oz (ounce)",
        "ct" to "ct (carat)",
        "amu" to "amu/u"
    )

    val baseValueInG = activeValue?.let { it * unitToBaseG[activeUnit]!! }

    Text(
        text = "Gravity relation: Weight = Mass × 9.8 m/s²\nConvert between metric, imperial, carat, and subatomic mass scales instantly.",
        fontSize = 11.sp,
        color = Color.Gray,
        lineHeight = 14.sp,
        modifier = Modifier.padding(bottom = 8.dp)
    )

    unitToBaseG.keys.forEach { unitKey ->
        val displayValue = if (unitKey == activeUnit) {
            activeValueStr
        } else {
            baseValueInG?.let { it / unitToBaseG[unitKey]!! }?.let {
                if (it == 0.0) "0" else if (it < 1e-4 && it > 0.0) String.format("%.4e", it) else String.format("%.6g", it).trimEnd('0').trimEnd('.')
            } ?: ""
        }

        CalculatorRow(
            label = labels[unitKey] ?: "",
            value = displayValue,
            onValueChange = {
                activeUnit = unitKey
                activeValueStr = it
            },
            placeholder = "0.0",
            trailingLabel = unitKey
        )
    }
}

@Composable
fun DensityConverterWidget() {
    var activeUnit by remember { mutableStateOf<String?>("g_mL") }
    var activeValueStr by remember { mutableStateOf("1.0") }
    val activeValue = activeValueStr.toDoubleOrNull()

    val unitToBaseGmL = mapOf(
        "g_mL" to 1.0,
        "kg_L" to 1.0,
        "g_m3" to 1e-6,
        "kg_m3" to 0.001,
        "mg_m3" to 1e-9
    )

    val labels = mapOf(
        "g_mL" to "g/mL",
        "kg_L" to "kg/L",
        "g_m3" to "g/m³",
        "kg_m3" to "kg/m³",
        "mg_m3" to "mg/m³"
    )

    val baseValueInGmL = activeValue?.let { it * unitToBaseGmL[activeUnit]!! }

    Text(
        text = "Water has a reference density of 1,000 kg/m³ (1.0 g/mL) at standard temperature and pressure (STP).",
        fontSize = 11.sp,
        color = Color.Gray,
        lineHeight = 14.sp,
        modifier = Modifier.padding(bottom = 8.dp)
    )

    unitToBaseGmL.keys.forEach { unitKey ->
        val displayValue = if (unitKey == activeUnit) {
            activeValueStr
        } else {
            baseValueInGmL?.let { it / unitToBaseGmL[unitKey]!! }?.let {
                if (it == 0.0) "0" else String.format("%.6g", it).trimEnd('0').trimEnd('.')
            } ?: ""
        }

        CalculatorRow(
            label = labels[unitKey] ?: "",
            value = displayValue,
            onValueChange = {
                activeUnit = unitKey
                activeValueStr = it
            },
            placeholder = "0.0",
            trailingLabel = unitKey.replace("_", "/")
        )
    }
}

@Composable
fun LengthConverterWidget() {
    var activeUnit by remember { mutableStateOf<String?>("m") }
    var activeValueStr by remember { mutableStateOf("1.0") }
    val activeValue = activeValueStr.toDoubleOrNull()

    val unitToBaseM = mapOf(
        "m" to 1.0,
        "dm" to 0.1,
        "cm" to 0.01,
        "mm" to 0.001,
        "um" to 1e-6,
        "nm" to 1e-9,
        "ang" to 1e-10,
        "yd" to 0.9144,
        "ft" to 0.3048,
        "in" to 0.0254
    )

    val labels = mapOf(
        "m" to "m (meter)",
        "dm" to "dm (decimeter)",
        "cm" to "cm (centimeter)",
        "mm" to "mm (millimeter)",
        "um" to "µm (micrometer)",
        "nm" to "nm (nanometer)",
        "ang" to "Å (angstrom)",
        "yd" to "yd (yard)",
        "ft" to "ft (foot)",
        "in" to "in (inch)"
    )

    val baseValueInM = activeValue?.let { it * unitToBaseM[activeUnit]!! }

    Text(
        text = "Scale between metric, US customary, and micro/nano pharmaceutical structural lengths instantly.",
        fontSize = 11.sp,
        color = Color.Gray,
        lineHeight = 14.sp,
        modifier = Modifier.padding(bottom = 8.dp)
    )

    unitToBaseM.keys.forEach { unitKey ->
        val displayValue = if (unitKey == activeUnit) {
            activeValueStr
        } else {
            baseValueInM?.let { it / unitToBaseM[unitKey]!! }?.let {
                if (it == 0.0) "0" else String.format("%.6g", it).trimEnd('0').trimEnd('.')
            } ?: ""
        }

        CalculatorRow(
            label = labels[unitKey] ?: "",
            value = displayValue,
            onValueChange = {
                activeUnit = unitKey
                activeValueStr = it
            },
            placeholder = "0.0",
            trailingLabel = if (unitKey == "ang") "Å" else unitKey
        )
    }
}

@Composable
fun HplcMethodTransferWidget() {
    var selectedTab by remember { mutableStateOf(0) }

    var l1 by remember { mutableStateOf("15") }
    var l2 by remember { mutableStateOf("5") }
    var dc1 by remember { mutableStateOf("4.6") }
    var dc2 by remember { mutableStateOf("2.1") }
    var dp1 by remember { mutableStateOf("5") }
    var dp2 by remember { mutableStateOf("3") }
    var f1 by remember { mutableStateOf("1.00") }
    var v1 by remember { mutableStateOf("20") }
    var p1 by remember { mutableStateOf("1000") }
    var t1 by remember { mutableStateOf("30.00") }
    var teq1 by remember { mutableStateOf("17.44") }

    var fAdjustedInput by remember { mutableStateOf("") }

    TabRow(
        selectedTabIndex = selectedTab,
        containerColor = Color(0xFFF1F1F1),
        contentColor = Color(0xFFC62828),
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(8.dp))
    ) {
        Tab(selected = selectedTab == 0, onClick = { selectedTab = 0 }) {
            Text("Isocratic", modifier = Modifier.padding(vertical = 12.dp), fontWeight = FontWeight.Bold, fontSize = 12.sp)
        }
        Tab(selected = selectedTab == 1, onClick = { selectedTab = 1 }) {
            Text("Gradient", modifier = Modifier.padding(vertical = 12.dp), fontWeight = FontWeight.Bold, fontSize = 12.sp)
        }
        Tab(selected = selectedTab == 2, onClick = { selectedTab = 2 }) {
            Text("Support", modifier = Modifier.padding(vertical = 12.dp), fontWeight = FontWeight.Bold, fontSize = 12.sp)
        }
    }

    Spacer(modifier = Modifier.height(12.dp))

    if (selectedTab == 2) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.5f)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "HPLC Method Transfer Information",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFFC62828)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "The scaled gradient method is based on estimates of column volumes and is therefore only an approximation. " +
                           "More precise method scaling requires actual measured values of column volumes. Column volume is a function of " +
                           "particle size, particle structure, and column packing.\n\n" +
                           "If you have questions or comments about this tool, please use the contact form in the support hub below to share your feedback.",
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    color = Color.DarkGray
                )
            }
        }
    } else {
        val length1 = l1.toDoubleOrNull() ?: 1.0
        val length2 = l2.toDoubleOrNull() ?: 1.0
        val diam1 = dc1.toDoubleOrNull() ?: 1.0
        val diam2 = dc2.toDoubleOrNull() ?: 1.0
        val part1 = dp1.toDoubleOrNull() ?: 1.0
        val part2 = dp2.toDoubleOrNull() ?: 1.0
        val flow1 = f1.toDoubleOrNull() ?: 1.0
        val vol1 = v1.toDoubleOrNull() ?: 1.0
        val press1 = p1.toDoubleOrNull() ?: 1.0
        val time1 = t1.toDoubleOrNull() ?: 1.0
        val eq1 = teq1.toDoubleOrNull() ?: 1.0

        val flow2 = flow1 * (diam2 * diam2) / (diam1 * diam1) * (part1 / part2)
        val fAdjusted = fAdjustedInput.toDoubleOrNull() ?: flow2

        val vol2 = vol1 * (length2 / length1) * (diam2 * diam2) / (diam1 * diam1)

        val press2 = press1 * (length2 / length1) * ((part1 * part1) / (part2 * part2)) * (flow2 / flow1) * ((diam1 * diam1) / (diam2 * diam2))
        val pressAdj = press1 * (length2 / length1) * ((part1 * part1) / (part2 * part2)) * (fAdjusted / flow1) * ((diam1 * diam1) / (diam2 * diam2))

        val time2 = time1 * (length2 / length1) * ((diam2 * diam2) / (diam1 * diam1)) * (flow1 / flow2)
        val timeAdj = time1 * (length2 / length1) * ((diam2 * diam2) / (diam1 * diam1)) * (flow1 / fAdjusted)

        val eq2 = eq1 * (length2 / length1) * ((diam2 * diam2) / (diam1 * diam1)) * (flow1 / flow2)
        val eqAdj = eq1 * (length2 / length1) * ((diam2 * diam2) / (diam1 * diam1)) * (flow1 / fAdjusted)

        val timeSavedGeom = (time1 - time2).coerceAtLeast(0.0)
        val timeSavedAdj = (time1 - timeAdj).coerceAtLeast(0.0)

        val solventSavedGeom = ((flow1 * time1) - (flow2 * time2)).coerceAtLeast(0.0)
        val solventSavedAdj = ((flow1 * time1) - (fAdjusted * timeAdj)).coerceAtLeast(0.0)

        if (selectedTab == 1) {
            Text(
                text = "Note: Gradient step times scale proportionally to Column Volume changes. The segments below scale using the exact same parameters as the run time.",
                fontSize = 11.sp,
                color = Color.Gray,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text("Column Configuration", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color.Gray)
            
            CalculatorRow(label = "Orig Length L1:", value = l1, onValueChange = { l1 = it }, trailingLabel = "cm")
            CalculatorRow(label = "New Length L2:", value = l2, onValueChange = { l2 = it }, trailingLabel = "cm")
            CalculatorRow(label = "Orig Diam dc1:", value = dc1, onValueChange = { dc1 = it }, trailingLabel = "mm")
            CalculatorRow(label = "New Diam dc2:", value = dc2, onValueChange = { dc2 = it }, trailingLabel = "mm")
            CalculatorRow(label = "Orig dp1:", value = dp1, onValueChange = { dp1 = it }, trailingLabel = "µm")
            CalculatorRow(label = "New dp2:", value = dp2, onValueChange = { dp2 = it }, trailingLabel = "µm")

            Spacer(modifier = Modifier.height(4.dp))
            Text("Method Parameters", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color.Gray)

            CalculatorRow(label = "Orig Flow F1:", value = f1, onValueChange = { f1 = it }, trailingLabel = "mL/min")
            CalculatorRow(label = "Scaled Flow F2:", value = String.format("%.2f", flow2), onValueChange = {}, trailingLabel = "mL/min")
            CalculatorRow(label = "Adjusted Flow:", value = fAdjustedInput, onValueChange = { fAdjustedInput = it }, placeholder = String.format("%.2f", flow2), trailingLabel = "mL/min")
            
            CalculatorRow(label = "Orig Inj Vol V1:", value = v1, onValueChange = { v1 = it }, trailingLabel = "µL")
            CalculatorRow(label = "Scaled Inj Vol:", value = String.format("%.1f", vol2), onValueChange = {}, trailingLabel = "µL")

            CalculatorRow(label = "Orig Press P1:", value = p1, onValueChange = { p1 = it }, trailingLabel = "psi/bar")
            CalculatorRow(label = "Scaled Press P2:", value = String.format("%.1f", press2), onValueChange = {}, trailingLabel = "psi/bar")
            CalculatorRow(label = "Adjusted Press:", value = String.format("%.1f", pressAdj), onValueChange = {}, trailingLabel = "psi/bar")

            CalculatorRow(label = "Orig Run Time:", value = t1, onValueChange = { t1 = it }, trailingLabel = "min")
            CalculatorRow(label = "Scaled Time:", value = String.format("%.2f", time2), onValueChange = {}, trailingLabel = "min")
            CalculatorRow(label = "Adjusted Time:", value = String.format("%.2f", timeAdj), onValueChange = {}, trailingLabel = "min")

            CalculatorRow(label = "Orig Eq. Time:", value = teq1, onValueChange = { teq1 = it }, trailingLabel = "min")
            CalculatorRow(label = "Scaled Eq. Time:", value = String.format("%.2f", eq2), onValueChange = {}, trailingLabel = "min")
            CalculatorRow(label = "Adjusted Eq.:", value = String.format("%.2f", eqAdj), onValueChange = {}, trailingLabel = "min")

            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9)),
                border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.5f)),
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text("ESTIMATED SAVINGS SUMMARY", fontWeight = FontWeight.ExtraBold, fontSize = 11.sp, color = Color.Gray)

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("TIME SAVED (GEOMETRIC)", fontSize = 11.sp, color = Color.DarkGray)
                            Text(String.format("%.1f min", timeSavedGeom), fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFFC62828))
                        }
                        Column {
                            Text("TIME SAVED (ADJUSTED)", fontSize = 11.sp, color = Color.DarkGray)
                            Text(String.format("%.1f min", timeSavedAdj), fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFFC62828))
                        }
                    }

                    Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.LightGray.copy(alpha = 0.5f)))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("SOLVENT SAVED (GEOMETRIC)", fontSize = 11.sp, color = Color.DarkGray)
                            Text(String.format("%.1f mL", solventSavedGeom), fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFFC62828))
                        }
                        Column {
                            Text("SOLVENT SAVED (ADJUSTED)", fontSize = 11.sp, color = Color.DarkGray)
                            Text(String.format("%.1f mL", solventSavedAdj), fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFFC62828))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AbsorbanceTransmittanceWidget() {
    var absInput by remember { mutableStateOf("0.4") }
    var transInput by remember { mutableStateOf("39.8") }
    var activeInput by remember { mutableStateOf(0) }

    if (activeInput == 0) {
        val a = absInput.toDoubleOrNull()
        if (a != null) {
            val t = 100.0 * java.lang.Math.pow(10.0, -a)
            transInput = if (t == 0.0) "0" else String.format("%.2f", t).trimEnd('0').trimEnd('.')
        } else {
            transInput = ""
        }
    } else {
        val t = transInput.toDoubleOrNull()
        if (t != null && t > 0.0) {
            val a = 2.0 - kotlin.math.log10(t)
            absInput = String.format("%.3f", a).trimEnd('0').trimEnd('.')
        } else {
            absInput = ""
        }
    }

    Text(
        text = "Formula: A = -log₁₀(T) = log₁₀(100/T%)\nConvert spectrophotometric Absorbance directly to percentage Transmittance and vice versa.",
        fontSize = 11.sp,
        color = Color.Gray,
        lineHeight = 14.sp,
        modifier = Modifier.padding(bottom = 8.dp)
    )

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        CalculatorRow(
            label = "Absorbance (A):",
            value = absInput,
            onValueChange = {
                activeInput = 0
                absInput = it
            },
            placeholder = "0.0",
            trailingLabel = "A"
        )

        CalculatorRow(
            label = "Transmittance (T%):",
            value = transInput,
            onValueChange = {
                activeInput = 1
                transInput = it
            },
            placeholder = "0.0",
            trailingLabel = "%T"
        )
    }

    Spacer(modifier = Modifier.height(12.dp))

    Text(
        text = "Transmittance to Absorbance Reference Table:",
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        color = Color.Gray,
        modifier = Modifier.padding(bottom = 4.dp)
    )

    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9)),
        border = BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            val rows = listOf(
                "0.0 Abs" to "100.0% Transmittance",
                "0.1 Abs" to "79.4% Transmittance",
                "0.2 Abs" to "63.1% Transmittance",
                "0.3 Abs" to "50.1% Transmittance",
                "0.4 Abs" to "39.8% Transmittance",
                "0.5 Abs" to "31.6% Transmittance",
                "1.0 Abs" to "10.0% Transmittance",
                "2.0 Abs" to "1.0% Transmittance"
            )
            rows.forEach { (a, t) ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(a, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
                    Text(t, fontSize = 11.sp, color = Color.Gray)
                }
            }
        }
    }
}

@Composable
fun TemperatureConverterWidget() {
    var activeUnit by remember { mutableStateOf<String?>("C") }
    var activeValueStr by remember { mutableStateOf("25") }
    val activeValue = activeValueStr.toDoubleOrNull()

    val tempInC = activeValue?.let {
        when (activeUnit) {
            "C" -> it
            "F" -> (it - 32.0) * 5.0 / 9.0
            "K" -> it - 273.15
            "Ra" -> (it - 491.67) * 5.0 / 9.0
            "Re" -> it * 5.0 / 4.0
            else -> 0.0
        }
    }

    val labels = mapOf(
        "C" to "°C (Celsius)",
        "F" to "°F (Fahrenheit)",
        "K" to "K (Kelvin)",
        "Ra" to "°Ra (Rankine)",
        "Re" to "°Re (Réaumur)"
    )

    Text(
        text = "Type in any field to dynamically convert across Celsius, Fahrenheit, Kelvin, Rankine, and Réaumur thermodynamic temperature scales.",
        fontSize = 11.sp,
        color = Color.Gray,
        lineHeight = 14.sp,
        modifier = Modifier.padding(bottom = 8.dp)
    )

    labels.keys.forEach { unitKey ->
        val displayValue = if (unitKey == activeUnit) {
            activeValueStr
        } else {
            tempInC?.let {
                val converted = when (unitKey) {
                    "C" -> it
                    "F" -> it * 9.0 / 5.0 + 32.0
                    "K" -> it + 273.15
                    "Ra" -> (it + 273.15) * 9.0 / 5.0
                    "Re" -> it * 4.0 / 5.0
                    else -> 0.0
                }
                if (converted == 0.0) "0" else String.format("%.2f", converted).trimEnd('0').trimEnd('.')
            } ?: ""
        }

        CalculatorRow(
            label = labels[unitKey] ?: "",
            value = displayValue,
            onValueChange = {
                activeUnit = unitKey
                activeValueStr = it
            },
            placeholder = "0.0",
            trailingLabel = if (unitKey == "K") "K" else "°$unitKey"
        )
    }
}

@Composable
fun ThreeVariableSolverWidget() {
    var selectedRel by remember { mutableStateOf(0) }
    var aVal by remember { mutableStateOf("") }
    var bVal by remember { mutableStateOf("") }
    var cVal by remember { mutableStateOf("") }

    var lastEdited by remember { mutableStateOf(listOf<String>()) }

    fun onFieldEdit(fieldName: String, newValue: String) {
        when (fieldName) {
            "A" -> aVal = newValue
            "B" -> bVal = newValue
            "C" -> cVal = newValue
        }
        val currentList = lastEdited.toMutableList()
        currentList.remove(fieldName)
        currentList.add(fieldName)
        if (currentList.size > 2) {
            currentList.removeAt(0)
        }
        lastEdited = currentList
    }

    if (lastEdited.size == 2) {
        val inputs = lastEdited.toSet()
        val aDouble = aVal.toDoubleOrNull()
        val bDouble = bVal.toDoubleOrNull()
        val cDouble = cVal.toDoubleOrNull()

        if (selectedRel == 0) {
            if (inputs.contains("A") && inputs.contains("B") && aDouble != null && bDouble != null) {
                val c = aDouble * bDouble
                cVal = if (c == 0.0) "0" else String.format("%.6g", c).trimEnd('0').trimEnd('.')
            } else if (inputs.contains("A") && inputs.contains("C") && aDouble != null && cDouble != null) {
                if (aDouble != 0.0) {
                    val b = cDouble / aDouble
                    bVal = if (b == 0.0) "0" else String.format("%.6g", b).trimEnd('0').trimEnd('.')
                }
            } else if (inputs.contains("B") && inputs.contains("C") && bDouble != null && cDouble != null) {
                if (bDouble != 0.0) {
                    val a = cDouble / bDouble
                    aVal = if (a == 0.0) "0" else String.format("%.6g", a).trimEnd('0').trimEnd('.')
                }
            }
        } else {
            if (inputs.contains("A") && inputs.contains("B") && aDouble != null && bDouble != null) {
                if (bDouble != 0.0) {
                    val c = aDouble / bDouble
                    cVal = if (c == 0.0) "0" else String.format("%.6g", c).trimEnd('0').trimEnd('.')
                }
            } else if (inputs.contains("A") && inputs.contains("C") && aDouble != null && cDouble != null) {
                if (cDouble != 0.0) {
                    val b = aDouble / cDouble
                    bVal = if (b == 0.0) "0" else String.format("%.6g", b).trimEnd('0').trimEnd('.')
                }
            } else if (inputs.contains("B") && inputs.contains("C") && bDouble != null && cDouble != null) {
                val a = bDouble * cDouble
                aVal = if (a == 0.0) "0" else String.format("%.6g", a).trimEnd('0').trimEnd('.')
            }
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(
            text = "Relationship Solver: Enter any 2 values to automatically calculate the 3rd value.",
            fontSize = 11.sp,
            color = Color.Gray,
            lineHeight = 14.sp
        )

        TabRow(
            selectedTabIndex = selectedRel,
            containerColor = Color(0xFFF1F1F1),
            contentColor = Color(0xFFC62828),
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(8.dp))
        ) {
            Tab(selected = selectedRel == 0, onClick = {
                selectedRel = 0
                aVal = ""
                bVal = ""
                cVal = ""
                lastEdited = emptyList()
            }) {
                Text("A × B = C", modifier = Modifier.padding(vertical = 10.dp), fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }
            Tab(selected = selectedRel == 1, onClick = {
                selectedRel = 1
                aVal = ""
                bVal = ""
                cVal = ""
                lastEdited = emptyList()
            }) {
                Text("A / B = C", modifier = Modifier.padding(vertical = 10.dp), fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        CalculatorRow(
            label = "Value A" + if (lastEdited.size == 2 && !lastEdited.contains("A")) " (Computed):" else ":",
            value = aVal,
            onValueChange = { onFieldEdit("A", it) },
            placeholder = "0.0"
        )

        CalculatorRow(
            label = "Value B" + if (lastEdited.size == 2 && !lastEdited.contains("B")) " (Computed):" else ":",
            value = bVal,
            onValueChange = { onFieldEdit("B", it) },
            placeholder = "0.0"
        )

        CalculatorRow(
            label = "Value C" + if (lastEdited.size == 2 && !lastEdited.contains("C")) " (Computed):" else ":",
            value = cVal,
            onValueChange = { onFieldEdit("C", it) },
            placeholder = "0.0"
        )

        Button(
            onClick = {
                aVal = ""
                bVal = ""
                cVal = ""
                lastEdited = emptyList()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC62828)),
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        ) {
            Text("Clear / Reset", color = Color.White)
        }
    }
}

// ==========================================
// 5. CONTACT SECTION (Direct Message & Support Form)
// ==========================================

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PharmaContactDetailsForm(
    viewModel: SopViewModel,
    modifier: Modifier = Modifier
) {
    val uriHandler = androidx.compose.ui.platform.LocalUriHandler.current
    val contactInquiries by viewModel.contactInquiries.collectAsState()

    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var contactNumber by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var showSuccessDialog by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("contact_section_layout"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header
        item {
            Card(
                modifier = Modifier.fillMaxWidth().testTag("contact_header_card"),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.ContactMail,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Pharma SOP Support Hub",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Have questions, suggestions, or need customized SOP assistance? Reach out to us directly or fill out the contact form below.",
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                    )
                }
            }
        }

        // Contact links
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Email Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { uriHandler.openUri("mailto:muzamalms@gmail.com") }
                        .testTag("contact_email_card"),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Color(0xFFE3F2FD), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Email",
                                tint = Color(0xFF1976D2)
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Official Email Support", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                            Text("muzamalms@gmail.com", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                        }
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }

                // WhatsApp Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { uriHandler.openUri("https://whatsapp.com/channel/0029Vb7MWziGzzKLWWP2283I") }
                        .testTag("contact_whatsapp_card"),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Color(0xFFE8F5E9), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Chat,
                                contentDescription = "WhatsApp Channel",
                                tint = Color(0xFF2E7D32)
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("WhatsApp SOP Channel", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                            Text("Join our community channel for instant updates", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                        }
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }

                // YouTube Card
                Card(
                    modifier = Modifier.fillMaxWidth().testTag("contact_youtube_card"),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.6f)),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Color(0xFFFFEBEE), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayCircle,
                                contentDescription = "YouTube",
                                tint = Color(0xFFC62828)
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text("YouTube Channel", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                            Text("SOP Guidance & Training Videos", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                        }
                        Box(
                            modifier = Modifier
                                .background(Color(0xFFFFCDD2), RoundedCornerShape(12.dp))
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = "Coming Soon",
                                color = Color(0xFFB71C1C),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

        // Contact form
        item {
            Card(
                modifier = Modifier.fillMaxWidth().testTag("contact_form_card"),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Send a Direct Message",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    
                    OutlinedTextField(
                        value = fullName,
                        onValueChange = { fullName = it },
                        label = { Text("Full Name") },
                        placeholder = { Text("Enter your full name") },
                        modifier = Modifier.fillMaxWidth().testTag("contact_input_fullname"),
                        singleLine = true,
                        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) }
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email Address") },
                        placeholder = { Text("Enter your email address") },
                        modifier = Modifier.fillMaxWidth().testTag("contact_input_email"),
                        singleLine = true,
                        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) }
                    )

                    OutlinedTextField(
                        value = contactNumber,
                        onValueChange = { contactNumber = it },
                        label = { Text("Contact Number") },
                        placeholder = { Text("Enter your contact number") },
                        modifier = Modifier.fillMaxWidth().testTag("contact_input_phone"),
                        singleLine = true,
                        leadingIcon = { Icon(imageVector = Icons.Default.Phone, contentDescription = null) }
                    )

                    OutlinedTextField(
                        value = subject,
                        onValueChange = { subject = it },
                        label = { Text("Subject") },
                        placeholder = { Text("Enter the subject of inquiry") },
                        modifier = Modifier.fillMaxWidth().testTag("contact_input_subject"),
                        singleLine = true,
                        leadingIcon = { Icon(imageVector = Icons.Default.Label, contentDescription = null) }
                    )

                    OutlinedTextField(
                        value = message,
                        onValueChange = { message = it },
                        label = { Text("Message") },
                        placeholder = { Text("Describe your query or request in detail...") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .testTag("contact_input_message"),
                        maxLines = 5,
                        leadingIcon = { Icon(imageVector = Icons.Default.Message, contentDescription = null) }
                    )

                    if (showError) {
                        Text(
                            text = errorMessage,
                            color = MaterialTheme.colorScheme.error,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Button(
                        onClick = {
                            if (fullName.isBlank()) {
                                showError = true
                                errorMessage = "Please enter your full name."
                            } else if (email.isBlank() || !email.contains("@")) {
                                showError = true
                                errorMessage = "Please enter a valid email address."
                            } else if (contactNumber.isBlank()) {
                                showError = true
                                errorMessage = "Please enter your contact number."
                            } else if (subject.isBlank()) {
                                showError = true
                                errorMessage = "Please enter a subject."
                            } else if (message.isBlank()) {
                                showError = true
                                errorMessage = "Please enter your message."
                            } else {
                                showError = false
                                viewModel.submitContactInquiry(
                                    fullName = fullName,
                                    email = email,
                                    contactNumber = contactNumber,
                                    subject = subject,
                                    message = message,
                                    onSuccess = {
                                        fullName = ""
                                        email = ""
                                        contactNumber = ""
                                        subject = ""
                                        message = ""
                                        showSuccessDialog = true
                                    }
                                )
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .testTag("contact_submit_button"),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)) // Brand green button
                    ) {
                        Text("Submit Inquiry", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        // Inquiry History
        if (contactInquiries.isNotEmpty()) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Your Submitted Inquiries History (${contactInquiries.size})",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            
            items(contactInquiries) { inquiry ->
                Card(
                    modifier = Modifier.fillMaxWidth().testTag("contact_history_item_${inquiry.id}"),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = inquiry.subject,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            // Timestamp
                            val dateStr = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm", java.util.Locale.getDefault())
                                .format(java.util.Date(inquiry.timestamp))
                            Text(
                                text = dateStr,
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "From: ${inquiry.fullName} (${inquiry.email})",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                        )
                        if (inquiry.contactNumber.isNotEmpty()) {
                            Text(
                                text = "Phone: ${inquiry.contactNumber}",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                            )
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.1f)))
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = inquiry.message,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }

    if (showSuccessDialog) {
        AlertDialog(
            onDismissRequest = { showSuccessDialog = false },
            confirmButton = {
                TextButton(onClick = { showSuccessDialog = false }) {
                    Text("OK", color = Color(0xFF2E7D32))
                }
            },
            title = { Text("Inquiry Submitted", fontWeight = FontWeight.Bold) },
            text = { Text("Thank you for reaching out! Your contact request has been registered successfully inside the local database. We will review your message soon.") },
            icon = { Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null, tint = Color(0xFF2E7D32), modifier = Modifier.size(48.dp)) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PharmaContactSection(
    viewModel: SopViewModel,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
            contentColor = MaterialTheme.colorScheme.primary
        ) {
            Tab(
                selected = selectedTabIndex == 0,
                onClick = { selectedTabIndex = 0 },
                text = { Text("Ask AI Advisor", fontWeight = FontWeight.Bold) },
                icon = { Icon(Icons.Default.SupportAgent, contentDescription = "Ask Advisor") }
            )
            Tab(
                selected = selectedTabIndex == 1,
                onClick = { selectedTabIndex = 1 },
                text = { Text("Contact Support", fontWeight = FontWeight.Bold) },
                icon = { Icon(Icons.Default.ContactMail, contentDescription = "Contact Support") }
            )
        }

        if (selectedTabIndex == 0) {
            PharmaAskSection(
                viewModel = viewModel,
                modifier = Modifier.weight(1f)
            )
        } else {
            PharmaContactDetailsForm(
                viewModel = viewModel,
                modifier = Modifier.weight(1f)
            )
        }
    }
}


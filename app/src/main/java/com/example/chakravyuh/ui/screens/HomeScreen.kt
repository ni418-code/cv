package com.example.chakravyuh.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chakravyuh.data.model.CountdownTime
import com.example.chakravyuh.data.model.FaqItem
import com.example.chakravyuh.data.model.FrontierTheme
import com.example.chakravyuh.data.model.Partner
import com.example.chakravyuh.data.model.TimelineItem
import com.example.chakravyuh.ui.components.ChakraWheelView
import com.example.chakravyuh.ui.components.CountdownTimer
import com.example.chakravyuh.ui.theme.CyberNavyBg
import com.example.chakravyuh.ui.theme.CyberNavyBorder
import com.example.chakravyuh.ui.theme.CyberNavyBorderBright
import com.example.chakravyuh.ui.theme.CyberNavySurface
import com.example.chakravyuh.ui.theme.CyberNavySurfaceAlt
import com.example.chakravyuh.ui.theme.ElectricBlue
import com.example.chakravyuh.ui.theme.IceWhite
import com.example.chakravyuh.ui.theme.NeonCyan
import com.example.chakravyuh.ui.theme.SignalGold
import com.example.chakravyuh.ui.theme.SteelBlue
import com.example.chakravyuh.ui.theme.SteelDark

@Composable
fun HomeScreen(
    themes: List<FrontierTheme>,
    selectedTheme: FrontierTheme,
    countdown: CountdownTime,
    timeline: List<TimelineItem>,
    partners: List<Partner>,
    faqs: List<FaqItem>,
    onSelectTheme: (FrontierTheme) -> Unit,
    onEnterFrontier: (FrontierTheme) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CyberNavyBg)
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        // Hero Section
        HeroSection(
            countdown = countdown,
            onExploreClick = { onEnterFrontier(selectedTheme) }
        )

        // The Chakra Formation Section
        SectionHeader(
            eyebrow = "INTERACTIVE FIVE FRONTIERS",
            title = "The Chakra Formation",
            lead = "The five technology frontiers surround and converge upon the central rotating Chakra. Tap any node to view its battle cry, or enter to explore challenge tiers."
        )

        ChakraWheelView(
            themes = themes,
            selectedTheme = selectedTheme,
            onSelectTheme = onSelectTheme,
            onEnterFrontier = onEnterFrontier
        )

        // Why Participate / Mission Section
        SectionHeader(
            eyebrow = "THE MISSION",
            title = "Why Participate in Chakravyuh",
            lead = "Chakravyuh is designed for builders, researchers, and innovators ready to tackle authentic industry challenges."
        )

        MissionGrid()

        // Two-Day Timeline Section
        SectionHeader(
            eyebrow = "THE OPERATION",
            title = "Two-Day Timeline",
            lead = "High-level execution roadmap for the 27–28 October 2026 hackathon at VIT-AP University."
        )

        TimelineView(timeline = timeline)

        // Partners & Collaborators Section
        SectionHeader(
            eyebrow = "INSTITUTIONAL NETWORK",
            title = "Partners & Collaborators",
            lead = "Official collaborators and institutional partners supporting the Chakravyuh Cybershield Hackathon."
        )

        PartnersGrid(partners = partners)

        // Frequently Asked Questions Section
        SectionHeader(
            eyebrow = "EVENT INQUIRIES",
            title = "Frequently Asked Questions",
            lead = "Essential answers regarding team eligibility, registration schedule, and challenge architecture."
        )

        FaqAccordion(faqs = faqs)

        // Footer Information
        FooterSection()

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun HeroSection(
    countdown: CountdownTime,
    onExploreClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        // Kicker
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = NeonCyan,
                modifier = Modifier.size(14.dp)
            )
            Text(
                text = "VIT-AP UNIVERSITY PRESENTS",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp,
                color = NeonCyan
            )
        }

        Text(
            text = "CHAKRAVYUH",
            fontSize = 38.sp,
            fontWeight = FontWeight.ExtraBold,
            color = IceWhite,
            letterSpacing = (-0.5).sp,
            lineHeight = 42.sp
        )

        Text(
            text = "CYBERSHIELD HACKATHON",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = SteelBlue,
            letterSpacing = 1.sp
        )

        Text(
            text = "BUILD THE DEFENCE. BREAK THE LIMITS.",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = NeonCyan,
            letterSpacing = 0.5.sp
        )

        Text(
            text = "Two days. Five technology frontiers. Real-world challenges. Step inside the cyber defence arena to engineer resilient systems and compete for the ₹7,00,000 prize pool.",
            fontSize = 14.sp,
            color = SteelBlue,
            lineHeight = 22.sp
        )

        // CTA Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = onExploreClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = ElectricBlue,
                    contentColor = IceWhite
                ),
                shape = RoundedCornerShape(999.dp),
                modifier = Modifier
                    .weight(1f)
                    .testTag("hero_explore_themes_button")
            ) {
                Text(text = "EXPLORE THEMES", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
        }

        // Live Countdown Card
        CountdownTimer(countdown = countdown)

        // Event Facts Ribbon
        EventFactsStrip()
    }
}

@Composable
private fun EventFactsStrip() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .border(1.dp, CyberNavyBorder, RoundedCornerShape(14.dp)),
        colors = CardDefaults.cardColors(containerColor = CyberNavySurface.copy(alpha = 0.55f))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FactItem(label = "EVENT DATES", value = "27–28 Oct 2026")
                FactItem(label = "VENUE", value = "VIT-AP University")
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FactItem(label = "FORMAT", value = "Two-Day Offline")
                FactItem(label = "TOTAL PRIZE POOL", value = "₹7,00,000", isGold = true)
            }
        }
    }
}

@Composable
private fun FactItem(
    label: String,
    value: String,
    isGold: Boolean = false
) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(text = label, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = SteelBlue, letterSpacing = 0.8.sp)
        Text(text = value, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = if (isGold) SignalGold else IceWhite)
    }
}

@Composable
private fun SectionHeader(
    eyebrow: String,
    title: String,
    lead: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = eyebrow,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.8.sp,
            color = NeonCyan
        )
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = IceWhite
        )
        Text(
            text = lead,
            fontSize = 13.sp,
            color = SteelBlue,
            lineHeight = 20.sp
        )
    }
}

@Composable
private fun MissionGrid() {
    val items = listOf(
        Pair("Build Real Solutions", "Work on practical technology challenges drawn from actual industry and research problem spaces — not toy exercises."),
        Pair("Explore Emerging Tech", "Discover five distinct technical domains — from cyber-defence and blockchain to quantum computing and orbital systems."),
        Pair("Showcase Your Approach", "Demonstrate problem-solving, implementation, and technical reasoning to judges, mentors, and industry observers."),
        Pair("Compete & Collaborate", "Develop and present solutions during an intense two-day offline hackathon at VIT-AP University."),
        Pair("Defend What Matters", "Chakravyuh is a battle formation. Here, you defend digital infrastructure, financial systems, and critical networks."),
        Pair("₹7,00,000 Prize Pool", "Compete for a stated prize pool across Flagship, Medium, and Easy challenge tracks in every theme.")
    )

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        items.forEach { (title, desc) ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .border(1.dp, CyberNavyBorder, RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = CyberNavySurfaceAlt.copy(alpha = 0.8f))
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(text = title, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = IceWhite)
                    Text(text = desc, fontSize = 13.sp, color = SteelBlue, lineHeight = 18.sp)
                }
            }
        }
    }
}

@Composable
private fun TimelineView(timeline: List<TimelineItem>) {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        timeline.forEach { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .border(1.dp, CyberNavyBorder, RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = CyberNavySurface.copy(alpha = 0.85f))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${item.dayNumber} · ${item.dateText}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = IceWhite
                        )
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(999.dp))
                                .background(NeonCyan.copy(alpha = 0.1f))
                                .border(1.dp, NeonCyan.copy(alpha = 0.3f), RoundedCornerShape(999.dp))
                                .padding(horizontal = 8.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = item.phaseTag.uppercase(),
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = NeonCyan
                            )
                        }
                    }

                    Text(
                        text = item.title,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeonCyan
                    )

                    Text(
                        text = item.narrative,
                        fontSize = 13.sp,
                        color = SteelBlue,
                        lineHeight = 19.sp
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .border(1.dp, CyberNavyBorderBright.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                .background(CyberNavySurface.copy(alpha = 0.3f))
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Detailed hour-by-hour schedule: To be announced by the organising committee.",
                fontSize = 12.sp,
                color = SteelBlue,
                textAlign = TextAlign.Center
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun PartnersGrid(partners: List<Partner>) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        partners.forEach { partner ->
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(CyberNavySurface.copy(alpha = 0.65f))
                    .border(1.dp, CyberNavyBorder, RoundedCornerShape(8.dp))
                    .padding(horizontal = 14.dp, vertical = 10.dp)
            ) {
                Column {
                    Text(
                        text = partner.name,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = IceWhite
                    )
                    Text(
                        text = partner.role,
                        fontSize = 10.sp,
                        color = SteelBlue
                    )
                }
            }
        }
    }
}

@Composable
private fun FaqAccordion(faqs: List<FaqItem>) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        faqs.forEach { faq ->
            var expanded by remember { mutableStateOf(false) }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .border(
                        1.dp,
                        if (expanded) NeonCyan else CyberNavyBorder,
                        RoundedCornerShape(10.dp)
                    )
                    .clickable { expanded = !expanded }
                    .testTag("faq_${faq.id}"),
                colors = CardDefaults.cardColors(containerColor = CyberNavySurfaceAlt.copy(alpha = 0.8f))
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = faq.question,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = IceWhite,
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                            contentDescription = if (expanded) "Collapse" else "Expand",
                            tint = NeonCyan
                        )
                    }

                    AnimatedVisibility(visible = expanded) {
                        Text(
                            text = faq.answer,
                            fontSize = 13.sp,
                            color = SteelBlue,
                            lineHeight = 19.sp,
                            modifier = Modifier.padding(top = 10.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun FooterSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "CHAKRAVYUH: CYBERSHIELD HACKATHON",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = IceWhite,
            letterSpacing = 1.sp
        )
        Text(
            text = "© 2026 VIT-AP University · Powered by Unstop",
            fontSize = 11.sp,
            color = SteelDark
        )
    }
}

package com.example.chakravyuh.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chakravyuh.data.model.Challenge
import com.example.chakravyuh.data.model.ChallengeLevel
import com.example.chakravyuh.data.model.FrontierTheme
import com.example.chakravyuh.ui.components.ChallengeCard
import com.example.chakravyuh.ui.theme.CyberNavyBg
import com.example.chakravyuh.ui.theme.CyberNavyBorder
import com.example.chakravyuh.ui.theme.CyberNavyBorderBright
import com.example.chakravyuh.ui.theme.CyberNavySurface
import com.example.chakravyuh.ui.theme.ElectricBlue
import com.example.chakravyuh.ui.theme.IceWhite
import com.example.chakravyuh.ui.theme.NeonCyan
import com.example.chakravyuh.ui.theme.SteelBlue

@Composable
fun ThemeDetailScreen(
    theme: FrontierTheme,
    allThemes: List<FrontierTheme>,
    selectedLevel: ChallengeLevel,
    challenges: List<Challenge>,
    searchQuery: String,
    onBackToHome: () -> Unit,
    onSelectLevel: (ChallengeLevel) -> Unit,
    onSelectTheme: (FrontierTheme) -> Unit,
    onViewChallengeDetail: (Challenge) -> Unit,
    onToggleBookmark: (String) -> Unit,
    onSearchQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onBackToHome()
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(CyberNavyBg)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Return to Home Button
        item {
            Button(
                onClick = onBackToHome,
                colors = ButtonDefaults.buttonColors(
                    containerColor = CyberNavySurface.copy(alpha = 0.85f),
                    contentColor = NeonCyan
                ),
                shape = RoundedCornerShape(999.dp),
                modifier = Modifier
                    .border(1.dp, CyberNavyBorderBright, RoundedCornerShape(999.dp))
                    .testTag("back_to_home_button")
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "Return to Chakravyuh Home",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 6.dp)
                )
            }
        }

        // Theme Header Banner
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(CyberNavySurface.copy(alpha = 0.9f))
                    .border(1.dp, CyberNavyBorderBright, RoundedCornerShape(16.dp))
                    .padding(20.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "THEME ${theme.number} · ${theme.label}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp,
                        color = NeonCyan
                    )

                    Text(
                        text = theme.title,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = IceWhite,
                        lineHeight = 28.sp
                    )

                    // Battle Cry Quote Box
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(6.dp))
                            .background(NeonCyan.copy(alpha = 0.12f))
                            .border(1.dp, NeonCyan.copy(alpha = 0.4f), RoundedCornerShape(6.dp))
                            .padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = theme.motivationalQuote,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = IceWhite,
                            letterSpacing = 0.5.sp
                        )
                    }

                    Text(
                        text = theme.subtitle,
                        fontSize = 13.sp,
                        color = SteelBlue,
                        lineHeight = 20.sp
                    )
                }
            }
        }

        // Difficulty Tier Tabs (Flagship, Medium, Easy)
        item {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = "SELECT DIFFICULTY TIER",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = NeonCyan
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ChallengeLevel.values().forEach { level ->
                        val isSelected = selectedLevel == level
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(10.dp))
                                .background(
                                    if (isSelected) CyberNavySurfaceAlt else CyberNavySurface.copy(alpha = 0.6f)
                                )
                                .border(
                                    1.dp,
                                    if (isSelected) NeonCyan else CyberNavyBorder,
                                    RoundedCornerShape(10.dp)
                                )
                                .clickable { onSelectLevel(level) }
                                .padding(vertical = 12.dp, horizontal = 8.dp)
                                .testTag("level_tab_${level.name.lowercase()}"),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = level.tierNumber,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSelected) NeonCyan else SteelBlue
                                )
                                Text(
                                    text = level.displayName.uppercase(),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSelected) IceWhite else SteelBlue
                                )
                            }
                        }
                    }
                }
            }
        }

        // Search in Challenges
        item {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = onSearchQueryChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("challenges_search_input"),
                placeholder = { Text("Filter problem statements or tools...", color = SteelBlue, fontSize = 13.sp) },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = SteelBlue)
                },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = NeonCyan,
                    unfocusedBorderColor = CyberNavyBorder,
                    focusedTextColor = IceWhite,
                    unfocusedTextColor = IceWhite,
                    cursorColor = NeonCyan
                ),
                shape = RoundedCornerShape(10.dp)
            )
        }

        // Challenge Cards
        if (challenges.isEmpty()) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No challenges match your search.",
                        color = SteelBlue,
                        fontSize = 14.sp
                    )
                }
            }
        } else {
            items(challenges, key = { it.id }) { challenge ->
                ChallengeCard(
                    challenge = challenge,
                    onViewDetail = onViewChallengeDetail,
                    onToggleBookmark = onToggleBookmark
                )
            }
        }

        // Switch Frontier Strip
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "SWITCH FRONTIER",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = NeonCyan
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    allThemes.filter { it.id != theme.id }.forEach { otherTheme ->
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(CyberNavySurface.copy(alpha = 0.7f))
                                .border(1.dp, CyberNavyBorder, RoundedCornerShape(8.dp))
                                .clickable { onSelectTheme(otherTheme) }
                                .padding(horizontal = 14.dp, vertical = 10.dp)
                                .testTag("switch_to_${otherTheme.id}")
                        ) {
                            Column {
                                Text(
                                    text = "[${otherTheme.number}]",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = NeonCyan
                                )
                                Text(
                                    text = otherTheme.label,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = IceWhite
                                )
                            }
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

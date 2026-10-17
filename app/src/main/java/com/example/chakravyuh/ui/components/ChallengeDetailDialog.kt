package com.example.chakravyuh.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.chakravyuh.data.model.Challenge
import com.example.chakravyuh.data.model.ChallengeLevel
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChallengeDetailDialog(
    challenge: Challenge,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .border(1.dp, CyberNavyBorderBright, RoundedCornerShape(16.dp))
                .testTag("challenge_detail_dialog"),
            color = CyberNavySurfaceAlt
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = challenge.id,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = NeonCyan,
                                letterSpacing = 1.sp
                            )
                            val isFlagship = challenge.level == ChallengeLevel.FLAGSHIP
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(999.dp))
                                    .background(if (isFlagship) SignalGold.copy(alpha = 0.15f) else NeonCyan.copy(alpha = 0.1f))
                                    .border(1.dp, if (isFlagship) SignalGold.copy(alpha = 0.5f) else NeonCyan.copy(alpha = 0.4f), RoundedCornerShape(999.dp))
                                    .padding(horizontal = 8.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = challenge.level.displayName.uppercase(),
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isFlagship) SignalGold else IceWhite
                                )
                            }
                        }
                        Text(
                            text = challenge.title,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = IceWhite,
                            modifier = Modifier.padding(top = 4.dp),
                            lineHeight = 24.sp
                        )
                    }

                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier
                            .size(32.dp)
                            .testTag("close_spec_dialog")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = SteelBlue
                        )
                    }
                }

                HorizontalDivider(color = CyberNavyBorder)

                // Problem Statement
                SectionBlock(title = "PROBLEM STATEMENT") {
                    Text(text = challenge.summary, fontSize = 13.sp, color = SteelBlue, lineHeight = 20.sp)
                }

                // Real-World Context
                SectionBlock(title = "REAL-WORLD CONTEXT") {
                    Text(text = challenge.realWorldContext, fontSize = 13.sp, color = SteelBlue, lineHeight = 20.sp)
                }

                // Expected Deliverables
                SectionBlock(title = "EXPECTED DELIVERABLES") {
                    challenge.expectedOutcomes.forEach { item ->
                        BulletRow(text = item)
                    }
                }

                // Suggested Technologies
                SectionBlock(title = "SUGGESTED TECHNOLOGIES") {
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        challenge.suggestedTools.forEach { tool ->
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(CyberNavySurface)
                                    .border(1.dp, CyberNavyBorder, RoundedCornerShape(4.dp))
                                    .padding(horizontal = 8.dp, vertical = 3.dp)
                            ) {
                                Text(text = tool, fontSize = 11.sp, color = NeonCyan)
                            }
                        }
                    }
                }

                // Implementation Guidance
                SectionBlock(title = "IMPLEMENTATION GUIDANCE") {
                    challenge.implementationGuidance.forEach { item ->
                        BulletRow(text = item)
                    }
                }

                // Evaluation Criteria
                SectionBlock(title = "EVALUATION CRITERIA") {
                    challenge.evaluationCriteria.forEach { item ->
                        BulletRow(text = item)
                    }
                }

                HorizontalDivider(color = CyberNavyBorder)

                // Footer
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "STATUS: DRAFT SPECIFICATION",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = SignalGold
                    )
                    Button(
                        onClick = onDismiss,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ElectricBlue,
                            contentColor = IceWhite
                        ),
                        shape = RoundedCornerShape(999.dp)
                    ) {
                        Text(text = "Close Spec", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
private fun SectionBlock(
    title: String,
    content: @Composable () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text(
            text = title,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp,
            color = NeonCyan
        )
        content()
    }
}

@Composable
private fun BulletRow(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.Top
    ) {
        Text(text = "▪", color = NeonCyan, fontSize = 12.sp)
        Text(text = text, fontSize = 13.sp, color = SteelBlue, lineHeight = 18.sp)
    }
}

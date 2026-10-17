package com.example.chakravyuh.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun ChallengeCard(
    challenge: Challenge,
    onViewDetail: (Challenge) -> Unit,
    onToggleBookmark: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .border(1.dp, CyberNavyBorder, RoundedCornerShape(14.dp))
            .testTag("challenge_card_${challenge.id}"),
        colors = CardDefaults.cardColors(containerColor = CyberNavySurface.copy(alpha = 0.85f))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header with ID and Tier Pill
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = challenge.id,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeonCyan,
                        letterSpacing = 0.8.sp
                    )

                    val isFlagship = challenge.level == ChallengeLevel.FLAGSHIP
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(999.dp))
                            .background(
                                if (isFlagship) SignalGold.copy(alpha = 0.15f) else NeonCyan.copy(alpha = 0.1f)
                            )
                            .border(
                                1.dp,
                                if (isFlagship) SignalGold.copy(alpha = 0.4f) else NeonCyan.copy(alpha = 0.3f),
                                RoundedCornerShape(999.dp)
                            )
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

                // Bookmark icon
                IconButton(
                    onClick = { onToggleBookmark(challenge.id) },
                    modifier = Modifier
                        .size(32.dp)
                        .testTag("bookmark_btn_${challenge.id}")
                ) {
                    Icon(
                        imageVector = if (challenge.isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                        contentDescription = "Save Challenge",
                        tint = if (challenge.isBookmarked) SignalGold else SteelBlue
                    )
                }
            }

            // Title
            Text(
                text = challenge.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = IceWhite,
                lineHeight = 22.sp
            )

            // Summary
            Text(
                text = challenge.summary,
                fontSize = 13.sp,
                color = SteelBlue,
                lineHeight = 18.sp
            )

            // Suggested Tools Chips
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                challenge.suggestedTools.forEach { tool ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(CyberNavySurfaceAlt)
                            .border(1.dp, CyberNavyBorder, RoundedCornerShape(4.dp))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = tool,
                            fontSize = 10.sp,
                            color = SteelBlue
                        )
                    }
                }
            }

            // View Spec Button
            Button(
                onClick = { onViewDetail(challenge) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = ElectricBlue.copy(alpha = 0.85f),
                    contentColor = IceWhite
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
                    .testTag("view_spec_${challenge.id}")
            ) {
                Text(
                    text = "VIEW SPECIFICATION",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )
            }
        }
    }
}

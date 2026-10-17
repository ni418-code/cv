package com.example.chakravyuh.ui.screens

import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chakravyuh.data.model.Challenge
import com.example.chakravyuh.ui.components.ChallengeCard
import com.example.chakravyuh.ui.theme.CyberNavyBg
import com.example.chakravyuh.ui.theme.CyberNavyBorder
import com.example.chakravyuh.ui.theme.CyberNavyBorderBright
import com.example.chakravyuh.ui.theme.CyberNavySurface
import com.example.chakravyuh.ui.theme.IceWhite
import com.example.chakravyuh.ui.theme.NeonCyan
import com.example.chakravyuh.ui.theme.SignalGold
import com.example.chakravyuh.ui.theme.SteelBlue

@Composable
fun BookmarksScreen(
    challenges: List<Challenge>,
    onBackToHome: () -> Unit,
    onViewChallengeDetail: (Challenge) -> Unit,
    onToggleBookmark: (String) -> Unit,
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
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
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
                    .testTag("bookmarks_back_button")
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

        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Bookmark,
                    contentDescription = null,
                    tint = SignalGold,
                    modifier = Modifier.size(22.dp)
                )
                Text(
                    text = "Saved Challenge Statements",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = IceWhite
                )
            }
        }

        if (challenges.isEmpty()) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(CyberNavySurface.copy(alpha = 0.5f))
                        .border(1.dp, CyberNavyBorder, RoundedCornerShape(12.dp))
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "No saved challenges yet",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = IceWhite
                        )
                        Text(
                            text = "Explore the five frontiers and tap the bookmark icon on any challenge to save it here for quick review with your team.",
                            fontSize = 13.sp,
                            color = SteelBlue,
                            textAlign = TextAlign.Center
                        )
                    }
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

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

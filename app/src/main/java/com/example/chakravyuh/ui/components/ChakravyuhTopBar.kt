package com.example.chakravyuh.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chakravyuh.ui.theme.CyberNavyBg
import com.example.chakravyuh.ui.theme.CyberNavyBorder
import com.example.chakravyuh.ui.theme.CyberNavyBorderBright
import com.example.chakravyuh.ui.theme.CyberNavySurface
import com.example.chakravyuh.ui.theme.ElectricBlue
import com.example.chakravyuh.ui.theme.IceWhite
import com.example.chakravyuh.ui.theme.NeonCyan
import com.example.chakravyuh.ui.theme.SteelBlue
import com.example.chakravyuh.ui.viewmodel.AppDestination
import com.example.chakravyuh.ui.viewmodel.HomeSection

@Composable
fun ChakravyuhTopBar(
    currentDestination: AppDestination,
    activeSection: HomeSection,
    bookmarkCount: Int,
    onNavigateHome: (HomeSection) -> Unit,
    onNavigateBookmarks: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(CyberNavyBg.copy(alpha = 0.95f))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        // Main floating dock
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(999.dp))
                .background(CyberNavySurface.copy(alpha = 0.85f))
                .border(1.dp, CyberNavyBorderBright, RoundedCornerShape(999.dp))
                .padding(horizontal = 14.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Brand
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .testTag("brand_home_button")
                    .clickable { onNavigateHome(HomeSection.OVERVIEW) }
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(CyberNavyBg)
                        .border(1.dp, NeonCyan, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Shield,
                        contentDescription = "Chakravyuh Logo",
                        tint = NeonCyan,
                        modifier = Modifier.size(18.dp)
                    )
                }
                Text(
                    text = "CHAKRAVYUH",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = IceWhite
                )
            }

            // Bookmarks Action
            IconButton(
                onClick = onNavigateBookmarks,
                modifier = Modifier
                    .size(38.dp)
                    .testTag("bookmarks_nav_button")
            ) {
                BadgedBox(
                    badge = {
                        if (bookmarkCount > 0) {
                            Badge(
                                containerColor = ElectricBlue,
                                contentColor = IceWhite
                            ) {
                                Text(text = bookmarkCount.toString())
                            }
                        }
                    }
                ) {
                    Icon(
                        imageVector = if (currentDestination == AppDestination.BOOKMARKS) {
                            Icons.Default.Bookmark
                        } else {
                            Icons.Default.BookmarkBorder
                        },
                        contentDescription = "Saved Challenges",
                        tint = if (currentDestination == AppDestination.BOOKMARKS) NeonCyan else SteelBlue
                    )
                }
            }
        }

        // Section Tabs
        if (currentDestination == AppDestination.HOME) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                HomeSection.values().forEach { section ->
                    val isSelected = activeSection == section
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(999.dp))
                            .background(
                                if (isSelected) ElectricBlue else CyberNavySurface.copy(alpha = 0.5f)
                            )
                            .border(
                                1.dp,
                                if (isSelected) NeonCyan else CyberNavyBorder,
                                RoundedCornerShape(999.dp)
                            )
                            .clickable { onNavigateHome(section) }
                            .padding(horizontal = 14.dp, vertical = 6.dp)
                            .testTag("tab_${section.name.lowercase()}")
                    ) {
                        Text(
                            text = section.title,
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) IceWhite else SteelBlue
                        )
                    }
                }
            }
        }
    }
}

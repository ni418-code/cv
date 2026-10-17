package com.example.chakravyuh.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chakravyuh.data.model.FrontierTheme
import com.example.chakravyuh.ui.theme.CyberNavyBg
import com.example.chakravyuh.ui.theme.CyberNavyBorder
import com.example.chakravyuh.ui.theme.CyberNavyBorderBright
import com.example.chakravyuh.ui.theme.CyberNavySurface
import com.example.chakravyuh.ui.theme.ElectricBlue
import com.example.chakravyuh.ui.theme.IceWhite
import com.example.chakravyuh.ui.theme.NeonCyan
import com.example.chakravyuh.ui.theme.SignalGold
import com.example.chakravyuh.ui.theme.SteelBlue
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ChakraWheelView(
    themes: List<FrontierTheme>,
    selectedTheme: FrontierTheme,
    onSelectTheme: (FrontierTheme) -> Unit,
    onEnterFrontier: (FrontierTheme) -> Unit,
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "chakraRotation")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 40000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotationAngle"
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Constellation Arena
        BoxWithConstraints(
            modifier = Modifier
                .size(340.dp)
                .testTag("chakra_wheel_arena"),
            contentAlignment = Alignment.Center
        ) {
            val arenaSize = maxWidth
            val radius = arenaSize / 2 * 0.72f

            // Background geometric lines & radar circles
            Canvas(modifier = Modifier.fillMaxSize()) {
                val center = Offset(size.width / 2, size.height / 2)
                val r = radius.toPx()

                // Radar Circles
                drawCircle(
                    color = NeonCyan.copy(alpha = 0.25f),
                    radius = r * 0.45f,
                    center = center,
                    style = Stroke(width = 1.5f, pathEffect = PathEffect.dashPathEffect(floatArrayOf(8f, 8f)))
                )
                drawCircle(
                    color = NeonCyan.copy(alpha = 0.15f),
                    radius = r * 0.75f,
                    center = center,
                    style = Stroke(width = 1f, pathEffect = PathEffect.dashPathEffect(floatArrayOf(12f, 12f)))
                )
                drawCircle(
                    color = NeonCyan.copy(alpha = 0.35f),
                    radius = r,
                    center = center,
                    style = Stroke(width = 1.5f, pathEffect = PathEffect.dashPathEffect(floatArrayOf(6f, 6f)))
                )

                // 5-Point star coordinates:
                // 0: -90 deg (Top)
                // 1: -18 deg (Top-Right)
                // 2: 54 deg (Bottom-Right)
                // 3: 126 deg (Bottom-Left)
                // 4: 198 deg (Top-Left)
                val starAngles = listOf(-90.0, -18.0, 54.0, 126.0, 198.0)
                val starPoints = starAngles.map { deg ->
                    val rad = Math.toRadians(deg)
                    Offset(
                        x = center.x + (r * cos(rad)).toFloat(),
                        y = center.y + (r * sin(rad)).toFloat()
                    )
                }

                // Inward conduit lines to center
                starPoints.forEach { pt ->
                    drawLine(
                        color = NeonCyan.copy(alpha = 0.5f),
                        start = pt,
                        end = center,
                        strokeWidth = 1.5f,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(6f, 6f))
                    )
                }

                // Star polygon
                if (starPoints.size == 5) {
                    val order = listOf(0, 2, 4, 1, 3, 0)
                    for (i in 0 until order.size - 1) {
                        drawLine(
                            color = NeonCyan.copy(alpha = 0.6f),
                            start = starPoints[order[i]],
                            end = starPoints[order[i + 1]],
                            strokeWidth = 1.5f
                        )
                    }
                }
            }

            // Central Rotating Chakra Core Disc
            Box(
                modifier = Modifier
                    .size(92.dp)
                    .clip(CircleShape)
                    .background(CyberNavyBg)
                    .border(2.dp, NeonCyan, CircleShape)
                    .shadow(16.dp, CircleShape, spotColor = NeonCyan)
                    .testTag("chakra_center_core"),
                contentAlignment = Alignment.Center
            ) {
                // Rotating Chakra spokes
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .rotate(rotation)
                ) {
                    val center = Offset(size.width / 2, size.height / 2)
                    val spokeCount = 16
                    for (i in 0 until spokeCount) {
                        val rad = Math.toRadians((i * (360.0 / spokeCount)))
                        val end = Offset(
                            x = center.x + (size.width / 2 * 0.9f * cos(rad)).toFloat(),
                            y = center.y + (size.height / 2 * 0.9f * sin(rad)).toFloat()
                        )
                        drawLine(
                            color = NeonCyan.copy(alpha = if (i % 2 == 0) 0.8f else 0.4f),
                            start = center,
                            end = end,
                            strokeWidth = if (i % 2 == 0) 2.5f else 1.2f
                        )
                    }
                    drawCircle(color = CyberNavyBg, radius = size.width * 0.22f, center = center)
                    drawCircle(color = NeonCyan, radius = size.width * 0.12f, center = center)
                }
            }

            // 5 Theme Pointer Nodes
            val angles = listOf(-90.0, -18.0, 54.0, 126.0, 198.0)
            themes.take(5).forEachIndexed { index, theme ->
                val angleDeg = angles[index]
                val rad = Math.toRadians(angleDeg)
                val offsetX = (radius.value * cos(rad)).dp
                val offsetY = (radius.value * sin(rad)).dp
                val isSelected = selectedTheme.id == theme.id

                Box(
                    modifier = Modifier
                        .offset(x = offsetX, y = offsetY)
                        .size(68.dp)
                        .clip(CircleShape)
                        .background(if (isSelected) CyberNavySurface else CyberNavyBg)
                        .border(
                            width = if (isSelected) 2.5.dp else 1.5.dp,
                            color = if (isSelected) NeonCyan else theme.accentColor,
                            shape = CircleShape
                        )
                        .clickable { onSelectTheme(theme) }
                        .testTag("node_${theme.id}"),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "[${theme.number}]",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = NeonCyan
                        )
                        Text(
                            text = theme.label.split(" ").first(),
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = IceWhite,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        // Selected Theme Spotlight Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(CyberNavySurface.copy(alpha = 0.9f))
                .border(1.dp, CyberNavyBorderBright, RoundedCornerShape(16.dp))
                .padding(18.dp)
                .testTag("chakra_spotlight_card")
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "THEME ${selectedTheme.number} · ${selectedTheme.label}",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = NeonCyan
                )

                Text(
                    text = selectedTheme.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = IceWhite
                )

                // Battle Cry quote
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(6.dp))
                        .background(NeonCyan.copy(alpha = 0.1f))
                        .border(1.dp, NeonCyan.copy(alpha = 0.3f), RoundedCornerShape(6.dp))
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = selectedTheme.motivationalQuote,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = IceWhite,
                        letterSpacing = 0.5.sp
                    )
                }

                Text(
                    text = selectedTheme.subtitle,
                    fontSize = 13.sp,
                    color = SteelBlue,
                    lineHeight = 18.sp
                )

                Button(
                    onClick = { onEnterFrontier(selectedTheme) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ElectricBlue,
                        contentColor = IceWhite
                    ),
                    shape = RoundedCornerShape(999.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                        .testTag("enter_frontier_button")
                ) {
                    Text(text = "ENTER FRONTIER", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(16.dp)
                    )
                }
            }
        }
    }
}

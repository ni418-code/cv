package com.example.chakravyuh.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.chakravyuh.data.model.CountdownTime
import com.example.chakravyuh.ui.theme.CyberNavyBorder
import com.example.chakravyuh.ui.theme.CyberNavySurface
import com.example.chakravyuh.ui.theme.IceWhite
import com.example.chakravyuh.ui.theme.NeonCyan
import com.example.chakravyuh.ui.theme.SignalGold
import com.example.chakravyuh.ui.theme.SteelBlue

@Composable
fun CountdownTimer(
    countdown: CountdownTime,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(CyberNavySurface.copy(alpha = 0.65f))
            .border(1.dp, CyberNavyBorder, RoundedCornerShape(16.dp))
            .padding(16.dp)
            .testTag("countdown_timer_card"),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "HACKATHON DEPLOYMENT COUNTDOWN",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.2.sp,
            color = NeonCyan,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TimeBlock(value = String.format("%02d", countdown.days), label = "DAYS")
            Text(text = ":", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = NeonCyan)
            TimeBlock(value = String.format("%02d", countdown.hours), label = "HOURS")
            Text(text = ":", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = NeonCyan)
            TimeBlock(value = String.format("%02d", countdown.minutes), label = "MINS")
            Text(text = ":", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = NeonCyan)
            TimeBlock(value = String.format("%02d", countdown.seconds), label = "SECS", isAccent = true)
        }
    }
}

@Composable
private fun TimeBlock(
    value: String,
    label: String,
    isAccent: Boolean = false
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(62.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(CyberNavySurface)
                .border(
                    1.dp,
                    if (isAccent) NeonCyan.copy(alpha = 0.5f) else CyberNavyBorder,
                    RoundedCornerShape(8.dp)
                )
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = if (isAccent) SignalGold else IceWhite,
                textAlign = TextAlign.Center
            )
        }
        Text(
            text = label,
            fontSize = 9.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 0.5.sp,
            color = SteelBlue,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

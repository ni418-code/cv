package com.example.chakravyuh.data.model

import androidx.compose.ui.graphics.Color

enum class ChallengeLevel(val displayName: String, val tierNumber: String) {
    FLAGSHIP("Flagship", "01"),
    MEDIUM("Medium", "02"),
    EASY("Easy", "03")
}

data class FrontierTheme(
    val id: String,
    val number: String,
    val label: String,
    val title: String,
    val subtitle: String,
    val motivationalQuote: String,
    val assetImage: String,
    val accentColor: Color,
    val glowColor: Color
)

data class Challenge(
    val id: String,
    val themeId: String,
    val level: ChallengeLevel,
    val title: String,
    val summary: String,
    val realWorldContext: String,
    val expectedOutcomes: List<String>,
    val suggestedTools: List<String>,
    val implementationGuidance: List<String>,
    val evaluationCriteria: List<String>,
    val isBookmarked: Boolean = false
)

data class FaqItem(
    val id: String,
    val question: String,
    val answer: String
)

data class TimelineItem(
    val dayNumber: String,
    val dateText: String,
    val phaseTag: String,
    val title: String,
    val narrative: String
)

data class Partner(
    val name: String,
    val role: String
)

data class CountdownTime(
    val days: Long,
    val hours: Long,
    val minutes: Long,
    val seconds: Long
)

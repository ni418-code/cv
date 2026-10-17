package com.example.chakravyuh.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chakravyuh.data.model.Challenge
import com.example.chakravyuh.data.model.ChallengeLevel
import com.example.chakravyuh.data.model.CountdownTime
import com.example.chakravyuh.data.model.FrontierTheme
import com.example.chakravyuh.data.repository.ChakravyuhRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalDateTime
import java.time.Month

enum class AppDestination {
    HOME,
    THEME_DETAIL,
    BOOKMARKS
}

enum class HomeSection(val title: String) {
    OVERVIEW("Overview"),
    FRONTIERS("Frontiers"),
    MISSION("Mission"),
    TIMELINE("Timeline"),
    PARTNERS("Partners"),
    FAQ("FAQ")
}

data class ChakravyuhUiState(
    val selectedTheme: FrontierTheme,
    val selectedLevel: ChallengeLevel = ChallengeLevel.FLAGSHIP,
    val currentDestination: AppDestination = AppDestination.HOME,
    val activeHomeSection: HomeSection = HomeSection.OVERVIEW,
    val selectedChallenge: Challenge? = null,
    val searchQuery: String = "",
    val bookmarkedIds: Set<String> = emptySet(),
    val countdown: CountdownTime = CountdownTime(0, 0, 0, 0)
)

class ChakravyuhViewModel(
    val repository: ChakravyuhRepository = ChakravyuhRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        ChakravyuhUiState(selectedTheme = repository.themes.first())
    )
    val uiState: StateFlow<ChakravyuhUiState> = _uiState.asStateFlow()

    val filteredChallenges: StateFlow<List<Challenge>> = combine(
        _uiState,
        repository.bookmarkedIds
    ) { state, bookmarks ->
        var list = repository.challenges

        if (state.currentDestination == AppDestination.THEME_DETAIL) {
            list = list.filter { it.themeId == state.selectedTheme.id && it.level == state.selectedLevel }
        } else if (state.currentDestination == AppDestination.BOOKMARKS) {
            list = list.filter { bookmarks.contains(it.id) }
        }

        if (state.searchQuery.isNotBlank()) {
            val q = state.searchQuery.trim().lowercase()
            list = list.filter {
                it.title.lowercase().contains(q) ||
                it.summary.lowercase().contains(q) ||
                it.id.lowercase().contains(q) ||
                it.suggestedTools.any { tool -> tool.lowercase().contains(q) }
            }
        }

        list.map { challenge ->
            challenge.copy(isBookmarked = bookmarks.contains(challenge.id))
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init {
        startCountdownTicker()
        observeBookmarks()
    }

    private fun observeBookmarks() {
        viewModelScope.launch {
            repository.bookmarkedIds.collect { bookmarks ->
                _uiState.update { it.copy(bookmarkedIds = bookmarks) }
            }
        }
    }

    private fun startCountdownTicker() {
        viewModelScope.launch {
            val eventDate = LocalDateTime.of(2026, Month.OCTOBER, 27, 9, 0)
            while (true) {
                val now = LocalDateTime.now()
                val duration = if (now.isBefore(eventDate)) {
                    Duration.between(now, eventDate)
                } else {
                    Duration.ZERO
                }
                val days = duration.toDays()
                val hours = duration.toHours() % 24
                val minutes = duration.toMinutes() % 60
                val seconds = duration.seconds % 60

                _uiState.update {
                    it.copy(countdown = CountdownTime(days, hours, minutes, seconds))
                }
                delay(1000)
            }
        }
    }

    fun selectTheme(theme: FrontierTheme) {
        _uiState.update { it.copy(selectedTheme = theme) }
    }

    fun navigateToThemeDetail(theme: FrontierTheme) {
        _uiState.update {
            it.copy(
                selectedTheme = theme,
                currentDestination = AppDestination.THEME_DETAIL,
                selectedLevel = ChallengeLevel.FLAGSHIP
            )
        }
    }

    fun navigateToHome(section: HomeSection = HomeSection.OVERVIEW) {
        _uiState.update {
            it.copy(
                currentDestination = AppDestination.HOME,
                activeHomeSection = section
            )
        }
    }

    fun navigateToBookmarks() {
        _uiState.update {
            it.copy(currentDestination = AppDestination.BOOKMARKS)
        }
    }

    fun setLevel(level: ChallengeLevel) {
        _uiState.update { it.copy(selectedLevel = level) }
    }

    fun openChallengeDetail(challenge: Challenge) {
        _uiState.update { it.copy(selectedChallenge = challenge) }
    }

    fun closeChallengeDetail() {
        _uiState.update { it.copy(selectedChallenge = null) }
    }

    fun toggleBookmark(challengeId: String) {
        repository.toggleBookmark(challengeId)
    }

    fun updateSearchQuery(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }
}

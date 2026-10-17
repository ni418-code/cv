package com.example.chakravyuh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.chakravyuh.ui.components.ChallengeDetailDialog
import com.example.chakravyuh.ui.components.ChakravyuhTopBar
import com.example.chakravyuh.ui.screens.BookmarksScreen
import com.example.chakravyuh.ui.screens.HomeScreen
import com.example.chakravyuh.ui.screens.ThemeDetailScreen
import com.example.chakravyuh.ui.theme.ChakravyuhTheme
import com.example.chakravyuh.ui.viewmodel.AppDestination
import com.example.chakravyuh.ui.viewmodel.ChakravyuhViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: ChakravyuhViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ChakravyuhTheme {
                val uiState by viewModel.uiState.collectAsState()
                val filteredChallenges by viewModel.filteredChallenges.collectAsState()

                Scaffold(
                    contentWindowInsets = WindowInsets.safeDrawing,
                    topBar = {
                        ChakravyuhTopBar(
                            currentDestination = uiState.currentDestination,
                            activeSection = uiState.activeHomeSection,
                            bookmarkCount = uiState.bookmarkedIds.size,
                            onNavigateHome = { section -> viewModel.navigateToHome(section) },
                            onNavigateBookmarks = { viewModel.navigateToBookmarks() }
                        )
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        when (uiState.currentDestination) {
                            AppDestination.HOME -> {
                                HomeScreen(
                                    themes = viewModel.repository.themes,
                                    selectedTheme = uiState.selectedTheme,
                                    countdown = uiState.countdown,
                                    timeline = viewModel.repository.timeline,
                                    partners = viewModel.repository.partners,
                                    faqs = viewModel.repository.faqs,
                                    onSelectTheme = { theme -> viewModel.selectTheme(theme) },
                                    onEnterFrontier = { theme -> viewModel.navigateToThemeDetail(theme) }
                                )
                            }
                            AppDestination.THEME_DETAIL -> {
                                ThemeDetailScreen(
                                    theme = uiState.selectedTheme,
                                    allThemes = viewModel.repository.themes,
                                    selectedLevel = uiState.selectedLevel,
                                    challenges = filteredChallenges,
                                    searchQuery = uiState.searchQuery,
                                    onBackToHome = { viewModel.navigateToHome() },
                                    onSelectLevel = { level -> viewModel.setLevel(level) },
                                    onSelectTheme = { theme -> viewModel.selectTheme(theme) },
                                    onViewChallengeDetail = { challenge -> viewModel.openChallengeDetail(challenge) },
                                    onToggleBookmark = { id -> viewModel.toggleBookmark(id) },
                                    onSearchQueryChange = { q -> viewModel.updateSearchQuery(q) }
                                )
                            }
                            AppDestination.BOOKMARKS -> {
                                BookmarksScreen(
                                    challenges = filteredChallenges,
                                    onBackToHome = { viewModel.navigateToHome() },
                                    onViewChallengeDetail = { challenge -> viewModel.openChallengeDetail(challenge) },
                                    onToggleBookmark = { id -> viewModel.toggleBookmark(id) }
                                )
                            }
                        }

                        // Challenge Full Specification Dialog
                        uiState.selectedChallenge?.let { challenge ->
                            ChallengeDetailDialog(
                                challenge = challenge,
                                onDismiss = { viewModel.closeChallengeDetail() }
                            )
                        }
                    }
                }
            }
        }
    }
}

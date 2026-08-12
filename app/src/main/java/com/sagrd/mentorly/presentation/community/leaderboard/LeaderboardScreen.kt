package com.sagrd.mentorly.presentation.community.leaderboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.sagrd.mentorly.domain.model.community.LeaderboardEntry
import com.sagrd.mentorly.ui.theme.MentorlyTheme

@Composable
fun LeaderboardScreen(
    courseId: String,
    onBackClick: () -> Unit,
    onStudentClick: ((String) -> Unit)? = null,
    viewModel: LeaderboardViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(courseId) {
        viewModel.setCourseId(courseId)
    }

    LeaderboardContent(
        state = state,
        onEvent = viewModel::onEvent,
        onBackClick = onBackClick,
        onStudentClick = { studentId -> onStudentClick?.invoke(studentId) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeaderboardContent(
    state: LeaderboardUiState,
    onEvent: (LeaderboardUiEvent) -> Unit,
    onBackClick: () -> Unit,
    onStudentClick: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ranking del curso") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Atrás")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            if (state.ownPosition != null) {
                OwnPositionCard(entry = state.ownPosition)
            }

            OutlinedTextField(
                value = state.searchQuery,
                onValueChange = { onEvent(LeaderboardUiEvent.SearchChanged(it)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("Buscar en ranking...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                singleLine = true
            )

            if (state.isLoading && !state.isRefreshing) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else if (state.errorMessage != null) {
                ErrorView(
                    message = state.errorMessage,
                    onRetry = { onEvent(LeaderboardUiEvent.Load) }
                )
            } else if (state.entries.isEmpty() && !state.isLoading) {
                EmptyView(message = "Todavía no hay estudiantes visibles en el ranking.")
            } else {
                val filteredEntries = if (state.searchQuery.isBlank()) {
                    state.entries
                } else {
                    state.entries.filter { it.name.contains(state.searchQuery, ignoreCase = true) }
                }

                if (filteredEntries.isEmpty() && state.searchQuery.isNotBlank()) {
                    EmptyView(message = "No se encontraron estudiantes.")
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(filteredEntries) { entry ->
                            LeaderboardItem(
                                entry = entry,
                                isOwn = entry.studentId == state.ownPosition?.studentId,
                                onClick = { onStudentClick(entry.studentId) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun OwnPositionCard(entry: LeaderboardEntry) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Tu posición", style = MaterialTheme.typography.labelLarge)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "#${entry.position}",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = entry.name, style = MaterialTheme.typography.titleLarge)
                }
                Text(
                    text = "${entry.points} pts",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun LeaderboardItem(entry: LeaderboardEntry, isOwn: Boolean, onClick: () -> Unit) {
    val backgroundColor = when (entry.position) {
        1 -> Color(0xFFFFD700).copy(alpha = 0.1f) // Gold
        2 -> Color(0xFFC0C0C0).copy(alpha = 0.1f) // Silver
        3 -> Color(0xFFCD7F32).copy(alpha = 0.1f) // Bronze
        else -> MaterialTheme.colorScheme.surface
    }

    val borderStroke = if (isOwn) BorderStroke(2.dp, MaterialTheme.colorScheme.primary) else null

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        border = borderStroke,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.width(40.dp), contentAlignment = Alignment.Center) {
                if (entry.position <= 3) {
                    Icon(
                        imageVector = Icons.Default.EmojiEvents,
                        contentDescription = null,
                        tint = when (entry.position) {
                            1 -> Color(0xFFFFD700)
                            2 -> Color(0xFFC0C0C0)
                            else -> Color(0xFFCD7F32)
                        }
                    )
                } else {
                    Text(text = "${entry.position}", fontWeight = FontWeight.Bold)
                }
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                tint = if (isOwn) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline
            )
            
            Spacer(modifier = Modifier.width(12.dp))
            
            Text(
                text = entry.name,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = if (isOwn) FontWeight.Bold else FontWeight.Normal
            )
            
            Text(
                text = "${entry.points} pts",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ErrorView(message: String, onRetry: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = message, color = MaterialTheme.colorScheme.error)
        Button(onClick = onRetry, modifier = Modifier.padding(top = 16.dp)) {
            Text("Reintentar")
        }
    }
}

@Composable
fun EmptyView(message: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = message, style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun LeaderboardScreenWithContentPreview() {
    MentorlyTheme {
        LeaderboardContent(
            state = LeaderboardUiState(
                entries = listOf(
                    LeaderboardEntry(1, "1", "Juan Perez", 500),
                    LeaderboardEntry(2, "2", "Maria Lopez", 450),
                    LeaderboardEntry(3, "3", "Carlos Ruiz", 400),
                    LeaderboardEntry(4, "4", "Ana Garcia", 350)
                ),
                ownPosition = LeaderboardEntry(2, "2", "Maria Lopez", 450)
            ),
            onEvent = {},
            onBackClick = {},
            onStudentClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LeaderboardScreenEmptyPreview() {
    MentorlyTheme {
        LeaderboardContent(
            state = LeaderboardUiState(entries = emptyList()),
            onEvent = {},
            onBackClick = {},
            onStudentClick = {}
        )
    }
}

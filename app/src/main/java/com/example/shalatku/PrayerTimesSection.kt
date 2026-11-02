package com.example.shalatku

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PrayerTimesSection(
    state: PrayerTimesUiState,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxWidth()) {
        when (state) {
            is PrayerTimesUiState.Loading -> {
                Box(Modifier.fillMaxWidth().padding(32.dp), contentAlignment = Alignment.TopCenter) {
                    CircularProgressIndicator()
                }
            }
            is PrayerTimesUiState.Success -> {
                state.times.forEach { prayer ->
                    PrayerCard(prayer)
                }
                Spacer(Modifier.height(16.dp))
                Button(onClick = onRefresh) {
                    Text("Refresh")
                }
            }
            is PrayerTimesUiState.Error -> {
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
                    Text(state.message, color = MaterialTheme.colorScheme.error)
                    Spacer(Modifier.height(16.dp))
                    Button(onClick = onRefresh) {
                        Text("Retry")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrayerTimesLoadingPreview() {
    PrayerTimesSection(state = PrayerTimesUiState.Loading, onRefresh = {})
}

@Preview(showBackground = true)
@Composable
fun PrayerTimesSuccessPreview() {
    PrayerTimesSection(state = PrayerTimesUiState.Success(samplePrayers), onRefresh = {})
}

@Preview(showBackground = true)
@Composable
fun PrayerTimesErrorPreview() {
    PrayerTimesSection(state = PrayerTimesUiState.Error("Network Error"), onRefresh = {})
}
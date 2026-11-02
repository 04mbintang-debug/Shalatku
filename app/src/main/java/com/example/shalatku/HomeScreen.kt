package com.example.shalatku

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    prayers: List<Prayer>,
    prayerTimes: PrayerTimesUiState = PrayerTimesUiState.Success(prayers),
    onRefreshPrayerTimes: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    Column(modifier.padding(16.dp)) {
        Text("Shalatku", style = MaterialTheme.typography.headlineMedium)
        Text("Today's prayer times", style = MaterialTheme.typography.bodyMedium)
        
        Spacer(Modifier.height(16.dp))
        PrayerTimesSection(state = prayerTimes, onRefresh = onRefreshPrayerTimes)
    }
}

@Composable
fun PrayerCard(prayer: Prayer) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(prayer.name, style = MaterialTheme.typography.titleMedium)
            Text(prayer.time, style = MaterialTheme.typography.titleMedium)
        }
    }
}
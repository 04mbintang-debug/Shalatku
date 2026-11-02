package com.example.shalatku

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TrackerScreen(
    prayers: List<Prayer>,
    donePrayers: List<String>,
    doneCount: Int,
    onToggle: (String) -> Unit,
    onClear: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.padding(16.dp)) {
        Text("Prayer Tracker", style = MaterialTheme.typography.headlineMedium)
        Text(
            "$doneCount of ${prayers.size} prayers done today",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(Modifier.height(16.dp))
        prayers.forEach { prayer ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = prayer.name in donePrayers,
                    onCheckedChange = { onToggle(prayer.name) }
                )
                Text(prayer.name, style = MaterialTheme.typography.titleMedium)
            }
        }
        Spacer(Modifier.height(16.dp))
        OutlinedButton(onClick = onClear) {
            Text("Clear all")
        }
    }
}
package com.pscode.app.presentation.screens.countries.flag_game.leaderboard

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pscode.app.domain.model.Result
import com.pscode.app.presentation.composables.AutoResizedText
import com.pscode.app.utils.Constants.NUMBER_OF_ROUNDS

@Composable
fun LeaderboardListItem(
    rank: Int, resultData: Result, isCurrentUser: Boolean, modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier, colors = if (isCurrentUser) CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer
        ) else CardDefaults.elevatedCardColors()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
        ) {
            Text(
                text = "$rank",
                modifier = Modifier.weight(0.5f).padding(vertical = 8.dp),
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.ExtraBold
            )

            AutoResizedText(
                text = resultData.username,
                modifier = Modifier.weight(1f).padding(vertical = 8.dp),
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Medium,
            )

            AutoResizedText(
                text = "${resultData.score}/$NUMBER_OF_ROUNDS",
                modifier = Modifier.weight(1f).padding(vertical = 8.dp),
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Medium
            )

            AutoResizedText(
                text = resultData.time,
                modifier = Modifier.weight(1f).padding(vertical = 8.dp),
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
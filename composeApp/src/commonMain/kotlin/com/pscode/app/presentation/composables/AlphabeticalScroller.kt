package com.pscode.app.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AlphabeticalScroller(
    onLetterClick: (Char) -> Unit, modifier: Modifier = Modifier
) {
    val alphabet = ('A'..'Z')
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        alphabet.forEach { letter ->
            Text(
                text = letter.uppercase(),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .clickable { onLetterClick(letter) }
                    .padding(vertical = 1.dp)
            )
        }
    }
}


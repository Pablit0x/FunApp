package com.pscode.app.presentation.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import com.pscode.app.SharedRes
import com.pscode.app.presentation.screens.countries.detail.DetailScreen
import com.pscode.app.presentation.screens.countries.flag_game.FlagGameScreen
import com.pscode.app.presentation.screens.countries.overview.OverviewScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopAppBar(
    navigator: Navigator,
    onSearchClicked: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior,
    selectedCountryName: String? = null
) {
    val currentScreen = navigator.lastItem

    var topBarTitle: String = SharedRes.string.app_name
    var actions: @Composable() (RowScope.() -> Unit) = {}
    var navigationIcon: @Composable () -> Unit = {}

    when (currentScreen) {
        is OverviewScreen -> {
            topBarTitle = SharedRes.string.countries
            actions = {
                IconButton(onClick = onSearchClicked) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                }
            }
            navigationIcon = {}
        }

        is FlagGameScreen -> {
            topBarTitle = SharedRes.string.flag_matcher
            actions = {}
            navigationIcon = {
                IconButton(onClick = { navigator.pop() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, contentDescription = "Navigate back"
                    )
                }
            }
        }

        is DetailScreen -> {
            topBarTitle = selectedCountryName ?: SharedRes.string.unknown
            actions = {}
            navigationIcon = {
                IconButton(onClick = { navigator.pop() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, contentDescription = "Navigate back"
                    )
                }
            }
        }
    }

    CenterAlignedTopAppBar(
        title = {
            AutoResizedText(
                text = topBarTitle,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        },
        actions = actions,
        navigationIcon = navigationIcon,
        scrollBehavior = if (currentScreen is OverviewScreen) scrollBehavior else null
    )
}
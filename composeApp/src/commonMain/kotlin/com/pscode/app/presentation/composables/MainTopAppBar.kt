package com.pscode.app.presentation.composables

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.pscode.app.presentation.screens.countries.overview.SearchWidgetState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(
    navigator: Navigator,
    scrollBehavior: TopAppBarScrollBehavior,
    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchTriggered: () -> Unit,
    selectedCountryName: String? = null,
) {
    when (searchWidgetState) {
        SearchWidgetState.CLOSED -> {
            DefaultTopAppBar(
                navigator = navigator,
                onSearchClicked = onSearchTriggered,
                scrollBehavior = scrollBehavior,
                selectedCountryName = selectedCountryName
            )
        }

        SearchWidgetState.OPENED -> {
            SearchAppBar(
                text = searchTextState,
                onTextChange = onTextChange,
                onCloseClicked = onCloseClicked,
            )
        }
    }
}
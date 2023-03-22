package com.example.amphibianapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibianapp.ui.AmphibianUiState
import com.example.amphibianapp.ui.AmphibianViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    amphibianViewModel: AmphibianViewModel
) {
    val amphibianUiState = amphibianViewModel.amphibianUiState.collectAsState()

    when(amphibianUiState.value) {
        is AmphibianUiState.Loading -> LoadingScreen(modifier = modifier)
        is AmphibianUiState.Error -> ErrorScreen(modifier = modifier, onRetryClick = amphibianViewModel::getAmphibianData)
        is AmphibianUiState.Success -> AmphibianGridScreen(
            modifier = modifier, amphibians = (amphibianUiState.value as AmphibianUiState.Success).amphibians
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    val amphibianViewModel: AmphibianViewModel = viewModel(factory = AmphibianViewModel.Factory)
    HomeScreen(
        amphibianViewModel = amphibianViewModel
    )
}

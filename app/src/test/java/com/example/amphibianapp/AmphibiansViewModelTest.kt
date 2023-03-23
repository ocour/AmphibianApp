package com.example.amphibianapp

import com.example.amphibianapp.fake.FakeAmphibiansErrorRepository
import com.example.amphibianapp.fake.FakeAmphibiansRepository
import com.example.amphibianapp.fake.FakeDataSource
import com.example.amphibianapp.rules.TestDispatcherRule
import com.example.amphibianapp.ui.AmphibianUiState
import com.example.amphibianapp.ui.AmphibianViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class AmphibiansViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun amphibiansViewModel_getAmphibians_verifyUiSuccess() = runTest {
        val amphibiansViewModel = AmphibianViewModel(
            amphibiansRepository = FakeAmphibiansRepository()
        )

        Assert.assertEquals(
            AmphibianUiState.Success(FakeDataSource.amphibians),
            amphibiansViewModel.amphibianUiState.value
        )
    }

    @Test
    fun amphibiansViewModel_getAmphibians_checkForError() = runTest {
        val amphibiansViewModel = AmphibianViewModel(
            amphibiansRepository = FakeAmphibiansErrorRepository()
        )

        Assert.assertEquals(
            AmphibianUiState.Error,
            amphibiansViewModel.amphibianUiState.value
        )
    }
}
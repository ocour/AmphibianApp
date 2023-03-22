package com.example.amphibianapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.network.HttpException
import com.example.amphibianapp.AmphibiansApplication
import com.example.amphibianapp.data.AmphibiansRepository
import com.example.amphibianapp.model.Amphibian
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

/** Ui state */
sealed interface AmphibianUiState {
    data class Success(val amphibians: List<Amphibian>) : AmphibianUiState
    object Error : AmphibianUiState
    object Loading : AmphibianUiState
}

class AmphibianViewModel(
    private val amphibiansRepository: AmphibiansRepository
) : ViewModel() {
    private val _amphibianUiState: MutableStateFlow<AmphibianUiState> = MutableStateFlow(AmphibianUiState.Loading)
    val amphibianUiState: StateFlow<AmphibianUiState> = _amphibianUiState.asStateFlow()

    init {
        getAmphibianData()
    }

    fun getAmphibianData() {
        // Set state to Loading, this will indicate that data is being fetched
        _amphibianUiState.value = AmphibianUiState.Loading

        // Fetch data, give back Error if an error occurred
        viewModelScope.launch {
            try {
                _amphibianUiState.value = AmphibianUiState.Success(amphibiansRepository.getAmphibians())
            }
            catch(e: IOException) {
                _amphibianUiState.value =  AmphibianUiState.Error
            }
            catch(e: HttpException) {
                _amphibianUiState.value =  AmphibianUiState.Error
            }
        }
    }

    /**
     *  For Dependency injection
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansRepository = application.container.amphibiansRepository
                AmphibianViewModel(amphibiansRepository = amphibiansRepository)
            }
        }
    }
}
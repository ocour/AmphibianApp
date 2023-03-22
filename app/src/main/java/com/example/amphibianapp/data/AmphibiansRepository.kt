package com.example.amphibianapp.data

import com.example.amphibianapp.model.Amphibian
import com.example.amphibianapp.network.AmphibianApiService

/**
 *  Amphibians Repository interface,
 *  Will fetch Amphibians from Api
 * */
interface AmphibiansRepository {
    /** Fetches a list of Amphibians from AmphibiansApi */
    suspend fun getAmphibians(): List<Amphibian>
}

/**
 *  Amphibians Repository implementation
 * */
class NetworkAmphibiansRepository(
    private val amphibiansApiService: AmphibianApiService
) : AmphibiansRepository {
    /** Fetches a list of Amphibians from AmphibiansApi */
    override suspend fun getAmphibians(): List<Amphibian> {
        return amphibiansApiService.getAmphibians()
    }
}
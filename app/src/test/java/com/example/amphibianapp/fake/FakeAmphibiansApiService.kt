package com.example.amphibianapp.fake

import com.example.amphibianapp.model.Amphibian
import com.example.amphibianapp.network.AmphibianApiService

class FakeAmphibiansApiService : AmphibianApiService {
    override suspend fun getAmphibians(): List<Amphibian> {
        return FakeDataSource.amphibians
    }
}
package com.example.amphibianapp.fake

import com.example.amphibianapp.data.AmphibiansRepository
import com.example.amphibianapp.model.Amphibian
import java.io.IOException

class FakeAmphibiansRepository : AmphibiansRepository {

    /**
     *  Return legitimate amphibians list
     */
    override suspend fun getAmphibians(): List<Amphibian> {
        return FakeDataSource.amphibians
    }
}
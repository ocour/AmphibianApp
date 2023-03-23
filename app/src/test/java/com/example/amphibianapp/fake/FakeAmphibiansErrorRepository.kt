package com.example.amphibianapp.fake

import com.example.amphibianapp.data.AmphibiansRepository
import com.example.amphibianapp.model.Amphibian
import java.io.IOException

class FakeAmphibiansErrorRepository : AmphibiansRepository {

    /**
     *  Throws IOException Error
     */
    override suspend fun getAmphibians(): List<Amphibian> {
        throw IOException()
    }
}
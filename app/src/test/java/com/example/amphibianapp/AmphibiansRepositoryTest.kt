package com.example.amphibianapp

import com.example.amphibianapp.data.AmphibiansRepository
import com.example.amphibianapp.data.NetworkAmphibiansRepository
import com.example.amphibianapp.fake.FakeAmphibiansApiService
import com.example.amphibianapp.fake.FakeDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class AmphibiansRepositoryTest {


    /**
     *  Tests if repository fetches the correct data
     */
    @Test
    fun amphibiansRepository_getAmphibians_verifyList() = runTest {
        val repository = NetworkAmphibiansRepository(
            amphibiansApiService = FakeAmphibiansApiService()
        )

        Assert.assertEquals(FakeDataSource.amphibians, repository.getAmphibians())
    }
}
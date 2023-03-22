package com.example.amphibianapp.network

import com.example.amphibianapp.model.Amphibian
import retrofit2.http.GET

interface AmphibianApiService {

    /**
     *  Will get amphibian data from BASE_URL/amphibians
     * */
    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}
package com.example.amphibianapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *  Data model for Amphibian data
 * */

@Serializable
data class Amphibian(
    val name: String,
    val type: String,
    val description: String,
    @SerialName(value = "img_src")val imgSrc: String,
)

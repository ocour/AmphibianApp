package com.example.amphibianapp.fake

import com.example.amphibianapp.model.Amphibian

object FakeDataSource {

    val amphibians = listOf(
        Amphibian(
            name = "toady",
            type = "toad",
            description = "This is a description1.",
            imgSrc = "url.1"
        ),
        Amphibian(
            name = "salam",
            type = "salamander",
            description = "This is a description2.",
            imgSrc = "url.12"
        )
    )
}
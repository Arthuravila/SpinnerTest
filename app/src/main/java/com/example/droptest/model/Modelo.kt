package com.example.droptest.model

import com.squareup.moshi.Json

data class Modelo (
    @field:Json(name = "name") val name: String? = null,
    @field:Json(name = "id") val id: String? = null
)
package com.example.droptest.model

import com.squareup.moshi.Json

data class Veiculo(
    @field:Json(name = "name") val name: String? = null,
    @field:Json(name = "id") val id: String? = null,
    @field:Json(name = "preco") val preco: String? = null,
    @field:Json(name = "fipe_codigo") val fipe_codigo: String? = null
)
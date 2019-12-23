package com.example.droptest.repository

import com.example.droptest.model.Marca
import com.example.droptest.model.Modelo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @GET("marcas.json")
    suspend fun listMarcas() : Response<List<Marca>>

    @GET("veiculos/{id}.json")
    suspend fun listModelos(@Path("id") id: String?) : Response<List<Modelo>>
}
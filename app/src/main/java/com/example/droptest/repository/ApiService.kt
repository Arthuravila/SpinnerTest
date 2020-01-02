package com.example.droptest.repository

import com.example.droptest.model.Ano
import com.example.droptest.model.Marca
import com.example.droptest.model.Modelo
import com.example.droptest.model.Veiculo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("marcas.json")
    suspend fun listMarcas() : Response<List<Marca>>

    @GET("veiculos/{id}.json")
    suspend fun listModelos(@Path("id") id: String?) : Response<List<Modelo>>

    @GET("veiculo/{marcaId}/{modeloId}.json")
    suspend fun listAnos(@Path("marcaId") marcaId: String?, @Path("modeloId") modeloId: String?) : Response<List<Ano>>

    @GET("veiculo/{marcaId}/{modeloId}/{anoId}.json")
    suspend fun listValor(@Path("marcaId") marcaId: String?, @Path("modeloId") modeloId: String?, @Path("anoId") anoId: String?) : Response<Veiculo>

}
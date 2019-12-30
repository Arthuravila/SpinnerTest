package com.example.droptest.repository

class Repository : SafeApiRequest() {

    suspend fun getDataMarcas() = apiRequest { ApiInitializer.apiService.listMarcas()}

    suspend fun getDataModelos(id: String?) = apiRequest { ApiInitializer.apiService.listModelos(id)}

}
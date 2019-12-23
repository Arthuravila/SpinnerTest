package com.example.droptest.repository

class Repository : SafeApiRequest() {

    suspend fun getData() = apiRequest { ApiInitializer.apiService.listMarcas()}

}
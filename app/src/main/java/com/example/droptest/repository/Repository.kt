package com.example.droptest.repository

class Repository : SafeApiRequest() {

    suspend fun getDataMarcas() = apiRequest { ApiInitializer.apiService.listMarcas()}

    suspend fun getDataModelos(id: String?) = apiRequest { ApiInitializer.apiService.listModelos(id)}

    suspend fun getDataAnos(marcaId: String?, modeloId: String?) = apiRequest { ApiInitializer.apiService.listAnos(marcaId, modeloId)}

    suspend fun getDataValor(marcaId: String?, modeloId: String?, anoId: String?) = apiRequest { ApiInitializer.apiService.listValor(marcaId, modeloId, anoId)}
}
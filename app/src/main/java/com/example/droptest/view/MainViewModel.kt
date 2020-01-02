package com.example.droptest.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.droptest.model.Ano
import com.example.droptest.model.Marca
import com.example.droptest.model.Modelo
import com.example.droptest.model.Veiculo
import com.example.droptest.repository.Repository
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    private val marca = listOf(Marca("Selecione uma marca",null))
    private val modelo = listOf(Modelo("Selecione um modelo",null))
    private val ano = listOf(Ano("Selecione um ano",null))

    private val _spinnerMarcaEntries = MutableLiveData<List<Marca>>(marca)
    val spinnerMarcaEntries: LiveData<List<Marca>>
        get() = _spinnerMarcaEntries

    private val _spinnerModeloEntries = MutableLiveData<List<Modelo>>()
    val spinnerModeloEntries: LiveData<List<Modelo>>
        get() = _spinnerModeloEntries

    private val _spinnerAnoEntries = MutableLiveData<List<Ano>>()
    val spinnerAnoEntries: LiveData<List<Ano>>
        get() = _spinnerAnoEntries

    private val _veiculoLiveData = MutableLiveData<Veiculo>()
    val veiculoLiveData: LiveData<Veiculo>
        get() = _veiculoLiveData


    fun fetchMarcas() {
        viewModelScope.launch {
            runCatching {
                repository.getDataMarcas()
            }.onSuccess {
                val joined = mutableListOf<Marca>()
                joined.addAll(marca)
                it?.let { it1 -> joined.addAll(it1) }
                val immutableList = Collections.unmodifiableList(joined)
                _spinnerMarcaEntries.value = immutableList
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    fun fetchModelos(id: String?) {
        viewModelScope.launch {
            runCatching {
                repository.getDataModelos(id)
            }.onSuccess {
                val joined = mutableListOf<Modelo>()
                joined.addAll(modelo)
                it?.let { it1 -> joined.addAll(it1) }
                val immutableList = Collections.unmodifiableList(joined)
                _spinnerModeloEntries.value = immutableList
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    fun fetchAnos(marcaId: String?, modeloId: String?) {
        viewModelScope.launch {
            runCatching {
                repository.getDataAnos(marcaId, modeloId)
            }.onSuccess {
                val joined = mutableListOf<Ano>()
                joined.addAll(ano)
                it?.let { it1 -> joined.addAll(it1) }
                val immutableList = Collections.unmodifiableList(joined)
                _spinnerAnoEntries.value = immutableList
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    fun fetchValor(marcaId: String?, modeloId: String?, anoId: String?) {
        viewModelScope.launch {
            runCatching {
                repository.getDataValor(marcaId, modeloId, anoId)
            }.onSuccess {
               _veiculoLiveData.value = it
            }.onFailure {
                it.printStackTrace()
            }
        }
    }



}
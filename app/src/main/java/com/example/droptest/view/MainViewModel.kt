package com.example.droptest.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.droptest.model.Marca
import com.example.droptest.model.Modelo
import com.example.droptest.repository.Repository
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    private val marca = listOf(Marca("Selecione uma marca",null))
    private val modelo = listOf(Modelo("Selecione um modelo",null))

    private val _spinnerMarcaEntries = MutableLiveData<List<Marca>>(marca)
    val spinnerMarcaEntries: LiveData<List<Marca>>
        get() = _spinnerMarcaEntries

    private val _spinnerModeloEntries = MutableLiveData<List<Modelo>>()
    val spinnerModeloEntries: LiveData<List<Modelo>>
        get() = _spinnerModeloEntries

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

}
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
    private val marcaRepository: Repository
) : ViewModel() {

    private val marcas = listOf(Marca("Selecione uma marca",null))

    private val _spinnerMarcaEntries = MutableLiveData<List<Marca>>(marcas)
    val spinnerMarcaEntries: LiveData<List<Marca>>
        get() = _spinnerMarcaEntries

    private val _spinnerModeloEntries = MutableLiveData<List<Modelo>>()
    val spinnerModeloEntries: LiveData<List<Modelo>>
        get() = _spinnerModeloEntries

    fun fetchMarca() {
        viewModelScope.launch {
            runCatching {
                marcaRepository.getData()
            }.onSuccess {
                val joined = mutableListOf<Marca>()
                joined.addAll(marcas)
                it?.let { it1 -> joined.addAll(it1) }
                val immutableList = Collections.unmodifiableList(joined)
                _spinnerMarcaEntries.value = immutableList
            }.onFailure {
                Log.d("veio",it.message)
                it.printStackTrace()
            }
        }
    }

}
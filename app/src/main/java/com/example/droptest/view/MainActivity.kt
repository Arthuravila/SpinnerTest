package com.example.droptest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.get
import androidx.lifecycle.Observer
import com.example.droptest.feature.CustomSpinnerAdapter
import com.example.droptest.R
import com.example.droptest.model.Marca
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMarcas()
    }

    private fun getMarcas() {
        mainViewModel.fetchMarcas()
        mainViewModel.spinnerMarcaEntries.observe(this, Observer { spinnerData ->
            val stateAdapter =
                CustomSpinnerAdapter(this, R.id.marcaSpinnerText, spinnerData.toTypedArray())
            marcaSpinner?.adapter = stateAdapter

            marcaSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val marca = stateAdapter.getItem(position)
                    getModelos(marca.id.toString())
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        })
    }


    private fun getModelos(id: String?) {
        mainViewModel.fetchModelos(id)
        mainViewModel.spinnerModeloEntries.observe(this, Observer { spinnerData ->
            val stateAdapter =
                CustomSpinnerAdapter(this, R.id.modeloSpinnerText, spinnerData.toTypedArray())
            modeloSpinner?.adapter = stateAdapter

            modeloSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val marca = marcaSpinner.selectedItem
                    val modelo = stateAdapter.getItem(position)
                    getAnos((marca as Marca).id.toString(), modelo.id.toString())
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        })
    }

    private fun getAnos(marcaId: String?, modeloId: String?) {
        mainViewModel.fetchAnos(marcaId, modeloId)
        mainViewModel.spinnerAnoEntries.observe(this, Observer { spinnerData ->
            val stateAdapter =
                CustomSpinnerAdapter(this, R.id.anoSpinnerText, spinnerData.toTypedArray())
            anoSpinner?.adapter = stateAdapter

            anoSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    // getAnos(modelo.id.toString(), marca.toString())
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        })

    }

}

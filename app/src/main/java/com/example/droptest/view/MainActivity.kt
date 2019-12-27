package com.example.droptest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.Observer
import com.example.droptest.feature.CustomSpinnerAdapter
import com.example.droptest.R
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
        mainViewModel.fetchMarca()
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
                    Log.d("marcapos",marca.toString())
                    //   getModelos(marca.id)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        })
    }

/*

                marcaSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        if (isSpinnerInitial) {
                            isSpinnerInitial = false
                            return
                        }
                        val marca = stateAdapter.getItem(position)
                        getModelos(marca.id)
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }

                }
            }



    private fun getModelos(id: String?) {
        val call = ApiInitializer().apiService().listModelos(id)
        call.enqueue(object : Callback<List<Modelo>?> {
            override fun onResponse(
                call: Call<List<Modelo>?>?,
                response: Response<List<Modelo>?>?
            ) {
                val responseList = response?.body()
                val stateAdapter =
                    CustomSpinnerAdapter(
                        this@MainActivity,
                        R.id.modeloSpinnerText,
                        responseList?.toTypedArray()
                    )
                modeloSpinner?.adapter = stateAdapter
            }

            override fun onFailure(
                call: Call<List<Modelo>?>?,
                t: Throwable?
            ) {
                Log.e("onFailure error", t?.message)
            }
        })
    }*/


}

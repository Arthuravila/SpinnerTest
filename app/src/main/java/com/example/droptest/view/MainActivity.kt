package com.example.droptest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import com.example.droptest.feature.CustomSpinnerAdapter
import com.example.droptest.R
import com.example.droptest.model.Marca
import com.example.droptest.model.Modelo
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
// import com.example.droptest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    // private val mainViewModel: MainViewModel by viewModel()
    // private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val splashFragment = SplashFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.nav_host_fragment, splashFragment)
            .commit()
    }

/*
    override fun onSupportNavigateUp() =
        findNavController(this, R.id.nav_host_fragment).navigateUp()

       binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this

        getMarcas()*/
    }

/*    private fun getMarcas() {
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
                    val marca = marcaSpinner.selectedItem
                    val modelo = modeloSpinner.selectedItem
                    val ano = stateAdapter.getItem(position)
                    getValor((marca as Marca).id.toString(), (modelo as Modelo).id.toString(), ano.id.toString())
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        })
    }

    private fun getValor(marcaId: String?, modeloId: String?, anoId: String?) {
        mainViewModel.fetchValor(marcaId, modeloId, anoId)
        mainViewModel.veiculoLiveData.observe(this, Observer {
            Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_LONG).show()
        })

    }*/

/*
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <data>

        <variable
            name="viewModel"
            type="com.example.droptest.view.MainViewModel" />
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center_vertical"
        android:orientation="vertical"
        tools:context=".view.MainActivity">

        <Spinner
            android:id="@+id/marcaSpinner"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal" />

        <Spinner
            android:id="@+id/modeloSpinner"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="20dp" />

        <Spinner
            android:id="@+id/anoSpinner"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="20dp" />

        <Button
            android:id="@+id/buttonSubmit"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="10dp"
            android:text="@string/submit" />

        <TextView
            android:id="@+id/txt_preco"
            android:text="@{viewModel.preco}"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />

        <TextView
            android:id="@+id/txt_codigo"
            android:text="@{viewModel.codigo}"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
    </LinearLayout>
</layout>
*/



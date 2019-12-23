package com.example.droptest.feature

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.droptest.R
import com.example.droptest.model.Marca
import com.example.droptest.model.Modelo
import kotlinx.android.synthetic.main.marca_list.view.*
import kotlinx.android.synthetic.main.modelo_list.view.*

class CustomSpinnerAdapter<T>(
    context: Context,
    textViewResourceId: Int,
    objects: Array<T>?
) : ArrayAdapter<T>(context, textViewResourceId, objects) {

    override fun isEnabled(position: Int): Boolean {
        return position != 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        return createView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View? {
        return createView(position, convertView, parent)
    }

    private fun createView(position: Int, convertView: View?, parent: ViewGroup): View? {
        if (getItem(position) is Marca) {
            val item = getItem(position) as Marca
            val view = convertView ?: LayoutInflater.from(context).inflate(
                R.layout.marca_list,
                parent,
                false
            )
            view.marcaSpinnerText.text = item.name
            return view
        } else if (getItem(position) is Modelo) {
            val item = getItem(position) as Modelo
            val view = convertView ?: LayoutInflater.from(context).inflate(
                R.layout.modelo_list,
                parent,
                false
            )
            view.modeloSpinnerText.text = item.name
            return view
        }
        return null
    }
}


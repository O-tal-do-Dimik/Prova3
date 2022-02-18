package com.example.atorapp

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.atorapp.model.Ator

@BindingAdapter("anoAsText")
fun TextView.setnotaAsText(ator: Ator){
    ator.let { it ->
        text = ator.converterAnoString()
    }
}
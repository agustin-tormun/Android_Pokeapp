package com.agustin_tormun.android.pokeapp.common.adapters

import android.view.View
import androidx.databinding.BindingAdapter

/*****
 ** Nombre de Aplicación: PokeApp
 ** Nombre del paquete: com.agustin_tormun.android.pokeapp.common.adapters
 ** Creado por: Agustín T. el 1/17/2023 a las 13:28
 ** Más información: @cuchara_dmadera / cucharademadera.bearblog.dev
 ** Todos los derechos reservados 2023
 ** Cuchara de madera 🥄
 ******/

@BindingAdapter("isLoaded")
fun loadedIsGone(view: View, isLoaded: Boolean) {
    view.visibility = if (isLoaded) View.GONE else View.VISIBLE
}
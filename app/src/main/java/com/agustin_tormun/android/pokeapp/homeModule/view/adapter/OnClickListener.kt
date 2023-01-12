package com.agustin_tormun.android.pokeapp.homeModule.view.adapter

import com.agustin_tormun.android.pokeapp.common.entities.PokemonResult

/*****
 ** Nombre de Aplicación: PokeApp
 ** Nombre del paquete: com.agustin_tormun.android.pokeapp.homeModule.view.adapter
 ** Creado por: Agustín T. el 1/12/2023 a las 14:05
 ** Más información: @cuchara_dmadera / cucharademadera.bearblog.dev
 ** Todos los derechos reservados 2023
 ** Cuchara de madera 🥄
 ******/

interface OnClickListener {
    fun onClick(pokemonResult: PokemonResult)
}
package com.agustin_tormun.android.pokeapp.common.entities

/*****
 ** Nombre de Aplicación: PokeApp
 ** Nombre del paquete: com.agustin_tormun.android.pokeapp.common.entities
 ** Creado por: Agustín T. el 1/12/2023 a las 12:24
 ** Más información: @cuchara_dmadera / cucharademadera.bearblog.dev
 ** Todos los derechos reservados 2023
 ** Cuchara de madera 🥄
 ******/

data class PokemonEntity(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)

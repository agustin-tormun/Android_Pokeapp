package com.agustin_tormun.android.pokeapp.homeModule.model

import com.agustin_tormun.android.pokeapp.common.dataAccess.RemoteDatabase
import com.agustin_tormun.android.pokeapp.common.entities.PokemonEntity
import com.agustin_tormun.android.pokeapp.common.entities.PokemonResult

/*****
 ** Nombre de Aplicación: PokeApp
 ** Nombre del paquete: com.agustin_tormun.android.pokeapp.mainModule.model
 ** Creado por: Agustín T. el 1/12/2023 a las 13:11
 ** Más información: @cuchara_dmadera / cucharademadera.bearblog.dev
 ** Todos los derechos reservados 2023
 ** Cuchara de madera 🥄
 ******/

class HomeRepository {
    private var remoteDatabase = RemoteDatabase()

    suspend fun getAllPokemons(
        count: Int,
        next: String?,
        previous: String?,
        result: List<PokemonResult>
    ): PokemonEntity = remoteDatabase.getAllPokemons(count, next, previous, result)
}
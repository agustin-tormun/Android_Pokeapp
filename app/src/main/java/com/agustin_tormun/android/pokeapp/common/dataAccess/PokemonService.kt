package com.agustin_tormun.android.pokeapp.common.dataAccess

import com.agustin_tormun.android.pokeapp.common.entities.PokemonEntity
import com.agustin_tormun.android.pokeapp.common.entities.PokemonResult
import com.agustin_tormun.android.pokeapp.common.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

/*****
 ** Nombre de Aplicación: PokeApp
 ** Nombre del paquete: com.agustin_tormun.android.pokeapp.common.dataAccess
 ** Creado por: Agustín T. el 1/12/2023 a las 12:30
 ** Más información: @cuchara_dmadera / cucharademadera.bearblog.dev
 ** Todos los derechos reservados 2023
 ** Cuchara de madera 🥄
 ******/

interface PokemonService {
    @GET(Constants.ALL_POKEMON_PATH)
    suspend fun getAllPokemons(
        @Query(Constants.PARAM_COUNT) count: Int,
        @Query(Constants.PARAM_NEXT) next: String?,
        @Query(Constants.PARAM_PREVIOUS) previous: String?,
        @Query(Constants.PARAM_RESULTS) results: List<PokemonResult>
    ): PokemonEntity
}
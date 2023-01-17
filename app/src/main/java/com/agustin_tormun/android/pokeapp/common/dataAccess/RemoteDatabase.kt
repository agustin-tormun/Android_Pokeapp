package com.agustin_tormun.android.pokeapp.common.dataAccess

import com.agustin_tormun.android.pokeapp.common.entities.PokemonEntity
import com.agustin_tormun.android.pokeapp.common.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*****
 ** Nombre de Aplicación: PokeApp
 ** Nombre del paquete: com.agustin_tormun.android.pokeapp.mainModule.model
 ** Creado por: Agustín T. el 1/12/2023 a las 12:41
 ** Más información: @cuchara_dmadera / cucharademadera.bearblog.dev
 ** Todos los derechos reservados 2023
 ** Cuchara de madera 🥄
 ******/

class RemoteDatabase {
    private val retrofit = Retrofit
        .Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(PokemonService::class.java)

    suspend fun getAllPokemons(): PokemonEntity = withContext(Dispatchers.IO) {
        service.getAllPokemons()
    }
}
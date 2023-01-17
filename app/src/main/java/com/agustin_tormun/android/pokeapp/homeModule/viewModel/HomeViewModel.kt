package com.agustin_tormun.android.pokeapp.homeModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agustin_tormun.android.pokeapp.R
import com.agustin_tormun.android.pokeapp.common.entities.PokemonEntity
import com.agustin_tormun.android.pokeapp.homeModule.model.HomeRepository
import kotlinx.coroutines.launch

/*****
 ** Nombre de Aplicación: PokeApp
 ** Nombre del paquete: com.agustin_tormun.android.pokeapp.mainModule.viewmodel
 ** Creado por: Agustín T. el 1/12/2023 a las 13:13
 ** Más información: @cuchara_dmadera / cucharademadera.bearblog.dev
 ** Todos los derechos reservados 2023
 ** Cuchara de madera 🥄
 ******/

class HomeViewModel : ViewModel() {

    private val repository: HomeRepository = HomeRepository()

    private val pokemonsList = MutableLiveData<PokemonEntity>()
    fun getPokemonsList(): LiveData<PokemonEntity> = pokemonsList

    private val snackbarMessage = MutableLiveData<Int>()
    fun getSnackbarMessage(): LiveData<Int> = snackbarMessage

    private val loaded = MutableLiveData<Boolean>()
    fun getLoaded(): LiveData<Boolean> = loaded

    suspend fun getAllPokemons() {
        viewModelScope.launch {
            try {
                loaded.value = false
                val resultServer = repository.getAllPokemons()
                pokemonsList.value = resultServer
            } catch (e: Exception) {
                snackbarMessage.value = R.string.main_error_server
            } finally {
                loaded.value = true
            }
        }
    }
}
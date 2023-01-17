package com.agustin_tormun.android.pokeapp.homeModule.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.agustin_tormun.android.pokeapp.BR
import com.agustin_tormun.android.pokeapp.R
import com.agustin_tormun.android.pokeapp.common.entities.PokemonResult
import com.agustin_tormun.android.pokeapp.databinding.ItemPokemonBinding

/*****
 ** Nombre de Aplicación: PokeApp
 ** Nombre del paquete: com.agustin_tormun.android.pokeapp.mainModule.view.adapters
 ** Creado por: Agustín T. el 1/12/2023 a las 13:33
 ** Más información: @cuchara_dmadera / cucharademadera.bearblog.dev
 ** Todos los derechos reservados 2023
 ** Cuchara de madera 🥄
 ******/

class HomeAdapter(private val listener: OnClickListener) :
    ListAdapter<PokemonResult, RecyclerView.ViewHolder>(PokemonResultDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pokemonResult = getItem(position)
        with(holder as ViewHolder) {
            binding?.setVariable(BR.pokemonResult, pokemonResult)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<ItemPokemonBinding>(view)

        fun setListener(pokemonResult: PokemonResult) {
            binding?.root?.setOnClickListener { }
        }
    }

    class PokemonResultDiffCallback : DiffUtil.ItemCallback<PokemonResult>() {
        override fun areItemsTheSame(oldItem: PokemonResult, newItem: PokemonResult): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: PokemonResult, newItem: PokemonResult): Boolean =
            oldItem == newItem
    }
}
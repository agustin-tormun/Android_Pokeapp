package com.agustin_tormun.android.pokeapp.homeModule.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.agustin_tormun.android.pokeapp.BR
import com.agustin_tormun.android.pokeapp.common.entities.PokemonResult
import com.agustin_tormun.android.pokeapp.databinding.FragmentHomeBinding
import com.agustin_tormun.android.pokeapp.homeModule.view.adapter.HomeAdapter
import com.agustin_tormun.android.pokeapp.homeModule.view.adapter.OnClickListener
import com.agustin_tormun.android.pokeapp.homeModule.viewModel.HomeViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class HomeFragment : Fragment(), OnClickListener {

    private lateinit var mBinding: FragmentHomeBinding
    private lateinit var mAdapter: HomeAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding =
            FragmentHomeBinding.inflate(inflater, container, false)

        setupViewModel()
        setupObservers()
        setupAdapter()
        setupRecyclerView()

        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch {
            mBinding.viewModel?.getAllPokemons()
        }
    }


    private fun setupViewModel() {
        val vm: HomeViewModel by viewModels()
        mBinding.lifecycleOwner = viewLifecycleOwner
        mBinding.setVariable(BR.viewModel, vm)
    }

    private fun setupObservers() {
        mBinding.viewModel?.let {
            it.getPokemonsList().observe(viewLifecycleOwner) { pokemonEntity ->
                mAdapter.submitList(pokemonEntity.results)
            }
        }
    }

    private fun setupAdapter() {
        mAdapter = HomeAdapter(this@HomeFragment)
    }

    private fun setupRecyclerView() {
        mBinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(mBinding.root.context)
            adapter = this@HomeFragment.mAdapter
        }
    }


    override fun onClick(pokemonResult: PokemonResult) {
        Snackbar.make(mBinding.root, "Hola Pokemon", Snackbar.LENGTH_SHORT).show()
    }
}
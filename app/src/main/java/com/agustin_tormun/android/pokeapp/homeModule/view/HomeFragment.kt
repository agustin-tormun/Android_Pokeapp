package com.agustin_tormun.android.pokeapp.homeModule.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.agustin_tormun.android.pokeapp.databinding.FragmentHomeBinding
import com.agustin_tormun.android.pokeapp.homeModule.viewModel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var mBinding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding =
            FragmentHomeBinding.inflate(inflater, container, false)
        return mBinding.root
    }
}
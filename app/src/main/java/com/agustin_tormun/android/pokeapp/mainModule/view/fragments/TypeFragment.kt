package com.agustin_tormun.android.pokeapp.mainModule.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.agustin_tormun.android.pokeapp.databinding.FragmentTypeBinding

class TypeFragment : Fragment() {

    private lateinit var mBinding: FragmentTypeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTypeBinding.inflate(inflater, container, false)
        return mBinding.root
    }
}
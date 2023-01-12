package com.agustin_tormun.android.pokeapp.mainModule.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.agustin_tormun.android.pokeapp.databinding.FragmentPartyBinding

class PartyFragment : Fragment() {
    private lateinit var mBinding: FragmentPartyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentPartyBinding.inflate(inflater, container, false)
        return mBinding.root
    }


}
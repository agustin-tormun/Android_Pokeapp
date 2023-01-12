package com.agustin_tormun.android.pokeapp.mainModule.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.agustin_tormun.android.pokeapp.R
import com.agustin_tormun.android.pokeapp.databinding.ActivityMainBinding
import com.agustin_tormun.android.pokeapp.homeModule.view.HomeFragment
import com.agustin_tormun.android.pokeapp.mainModule.view.fragments.PartyFragment
import com.agustin_tormun.android.pokeapp.mainModule.view.fragments.TypeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mFragmentManager: FragmentManager
    private lateinit var mActiveFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = setContentView(this, R.layout.activity_main)

        setupBottomNav()
    }

    private fun setupBottomNav() {
        mFragmentManager = supportFragmentManager

        val homeFragment = HomeFragment()
        val partyFragment = PartyFragment()
        val typeFragment = TypeFragment()

        mActiveFragment = homeFragment

        //TODO "Pasar esta gestión al ViewModel"
        mFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, typeFragment, TypeFragment::class.java.name).commit()

        mFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, partyFragment, PartyFragment::class.java.name).commit()

        mFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, homeFragment, HomeFragment::class.java.name).commit()

        mBinding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> {
                    mFragmentManager.beginTransaction().hide(mActiveFragment).show(homeFragment)
                        .commit()
                    mActiveFragment = homeFragment
                    true
                }
                R.id.action_party -> {
                    mFragmentManager.beginTransaction().hide(mActiveFragment).show(partyFragment)
                        .commit()
                    mActiveFragment = partyFragment
                    true
                }
                R.id.action_types -> {
                    mFragmentManager.beginTransaction().hide(mActiveFragment).show(typeFragment)
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}
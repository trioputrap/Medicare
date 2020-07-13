package com.example.trio.medicare

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.trio.medicare.fragment.PetaFragment
import com.example.trio.medicare.fragment.ResepFragment
import com.example.trio.medicare.fragment.RiwayatFragment
import com.example.trio.medicare.util.Constant
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar()?.setCustomView(R.layout.action_bar);

        nav_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_peta -> {
                    loadPetaFragment(savedInstanceState)
                }

                R.id.navigation_resep -> {
                    loadResepFragment(savedInstanceState)
                }

                R.id.navigation_riwayat -> {
                    loadRiwayatFragment(savedInstanceState)
                }
            }
            true
        }

        nav_view.selectedItemId = R.id.navigation_peta

    }

    private fun loadPetaFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.nav_host_fragment, PetaFragment(), PetaFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadResepFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.nav_host_fragment, ResepFragment(), ResepFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadRiwayatFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.nav_host_fragment, RiwayatFragment(), RiwayatFragment::class.java.simpleName)
                .commit()
        }
    }
}
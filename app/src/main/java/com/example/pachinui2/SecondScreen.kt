package com.example.pachinui2

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pachinui2.R
import com.example.pachinui2.secondfragments.ScoreFragment
import com.google.android.material.navigation.NavigationBarView
import com.example.pachinui2.secondfragments.ExpsFragment
import com.example.pachinui2.secondfragments.SettingsFragment

class SecondScreen : AppCompatActivity() {
    var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        showFragment(ScoreFragment())
        bottomNavigationView = findViewById(R.id.bottom_nav)
        bottomNavigationView!!.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            item.isChecked = true
            if (item.itemId == R.id.item_profile) {
                showFragment(ScoreFragment())
            } else if (item.itemId == R.id.item_recharge) {
                showFragment(ExpsFragment())
            } else if (item.itemId == R.id.item_settings) {
                showFragment(SettingsFragment())
            }
            false
        })
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout2, fragment)
            .commit()
    }
}
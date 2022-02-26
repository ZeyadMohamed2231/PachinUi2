package com.example.pachinui2

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.pachinui2.secondfragments.ExpsFragment
import com.example.pachinui2.secondfragments.ScoreFragment
import com.example.pachinui2.secondfragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.snackbar.Snackbar
import java.util.*


class SecondScreen : AppCompatActivity() {
    private var mTimer: Timer? = null
    private var mTimerTask: TimerTask? = null
    var bottomNavigationView: BottomNavigationView? = null
    var constraintLayout: ConstraintLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        showFragment(ScoreFragment())
        constraintLayout = findViewById(R.id.constraint_layout)
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
    var counter =0
    override fun onBackPressed() {
        counter++
        constraintLayout?.let {
            val snack = Snackbar.make(it, getString(R.string.close_app), Snackbar.LENGTH_LONG)
            val view: View = snack.getView()
            val params = view.layoutParams as FrameLayout.LayoutParams
            params.gravity = Gravity.TOP
            view.layoutParams = params
            snack.show()
        }
        if (counter == 2){
           finish()
        }else{
            mTimerTask = object : TimerTask() {
                override fun run() {
                    counter=0
                }
            }
            mTimer = Timer()
            mTimer!!.schedule(mTimerTask, 3000)

        }

    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout2, fragment)
            .commit()
    }
}
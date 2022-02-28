package com.example.pachinui2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.pachinui2.R
import com.example.pachinui2.fragments.SplashFragment
import com.example.pachinui2.fragments.LanguageFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    private var mTimer: Timer? = null
    private var mTimerTask: TimerTask? = null
    public var activityMain = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        showFragment(SplashFragment())
        mTimerTask = object : TimerTask() {
            override fun run() {
                showFragment(LanguageFragment())
            }
        }
        mTimer = Timer()
        mTimer!!.schedule(mTimerTask, 3000)
    }



    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}
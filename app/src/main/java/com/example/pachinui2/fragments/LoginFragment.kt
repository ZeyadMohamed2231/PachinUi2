package com.example.pachinui2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.pachinui2.R
import android.widget.TextView
import com.example.pachinui2.fragments.SignupFragment
import com.example.pachinui2.fragments.ForgetPassFragment
import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.pachinui2.SecondScreen

class LoginFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val tv_signup = view.findViewById<TextView>(R.id.tv_signup)
        tv_signup.setOnClickListener { showFragment(SignupFragment()) }
        val tv_forget_pass = view.findViewById<TextView>(R.id.tv_fp)
        tv_forget_pass.setOnClickListener { showFragment(ForgetPassFragment()) }
        val button_signup = view.findViewById<Button>(R.id.bt_sign_in)
        button_signup.setOnClickListener {
            val intent = Intent(activity, SecondScreen::class.java)
            startActivity(intent)
            activity?.finish()
        }
        return view
    }

    private fun showFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .addToBackStack(null)
            .commit()
    }
}
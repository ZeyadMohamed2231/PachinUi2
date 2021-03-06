package com.example.pachinui2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.pachinui2.R
import android.widget.TextView
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.pachinui2.CircularIndeterminateProgressBar
import com.example.pachinui2.SecondScreen
import com.example.pachinui2.backend.FirebaseConn.domain
import com.example.pachinui2.backend.FirebaseConn.firebaseAuth
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException


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
        val button_signin = view.findViewById<Button>(R.id.bt_sign_in)
        button_signin.setOnClickListener {

            val et_phone_number = view.findViewById<EditText>(R.id.et_phone_number).text.toString()
            val et_password = view.findViewById<EditText>(R.id.et_password).text.toString()


            if (et_phone_number.isEmpty()
                    .or((et_phone_number.length < 6).or(et_phone_number.length > 11))
            ) {
                dialog(getString(R.string.error), getString(R.string.enter_phone_number_correct))
            } else if (et_password.isEmpty()
                    .or((et_password.length < 6).or(et_password.length > 16))
            ) {
                dialog(getString(R.string.error), getString(R.string.enter_password_correct))
            } else {
                view.findViewById<ComposeView>(R.id.compose_view_login).setContent {
                    CircularIndeterminateProgressBar(isDisplayed = true)
                }
                login(et_phone_number,et_password)

            }
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

    fun dialog(title: String?, message: String?) {
        MaterialAlertDialogBuilder(requireActivity())
            .setTitle(title)
            .setMessage(message)
            .show()
    }

    private fun login(phone: String, password: String) {

        firebaseAuth.signInWithEmailAndPassword(phone+domain, password).addOnCompleteListener(requireActivity()) {
            if (it.isSuccessful) {
                val intent = Intent(activity, SecondScreen::class.java)
                startActivity(intent)
                activity?.finish()
            } else {
                Log.d("Login_error",it.exception.toString())
                if(it.exception is FirebaseAuthInvalidCredentialsException){
                    Log.d("display","Password is invalid")
                }
                else if (it.exception is FirebaseAuthInvalidUserException){
                    Log.d("display","This phone number is not registered ,Please sign-up.")
                }
                else if(it.exception is FirebaseNetworkException){
                    Log.d("display","Make sure you are connected to the internet and try again.")
                }else{
                    Log.d("display","Something went wrong please try again later")
                }
            }
        }
    }
}







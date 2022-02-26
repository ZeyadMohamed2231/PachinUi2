package com.example.pachinui2.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.pachinui2.MainActivity
import com.example.pachinui2.R
import com.example.pachinui2.fragments.VerficationFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit


private lateinit var auth: FirebaseAuth
// we will use this to match the sent otp from firebase
lateinit var storedVerificationId:String
private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
var number : String =""
private val bundle = Bundle()
private val verficationFragment = VerficationFragment()

class SignupFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_signup, container, false)
        val button = view.findViewById<Button>(R.id.bt_sign_up)
        val phoneNumber = view.findViewById<EditText>(R.id.et_phone_signup)
        //Tamer
        auth=FirebaseAuth.getInstance()
        button.setOnClickListener {
            number=phoneNumber.text.toString()


            val firstName = view.findViewById<EditText>(R.id.et_fname_signup).text.toString()
            val lastName = view.findViewById<EditText>(R.id.et_lname_signup).text.toString()
            val phoneNumberSignUP = view.findViewById<EditText>(R.id.et_phone_signup).text.toString()
            val passwordSignUP = view.findViewById<EditText>(R.id.et_password_signup).text.toString()
            val pcSignUp = view.findViewById<EditText>(R.id.et_password_conf_signup).text.toString()


            if(firstName.isEmpty()){
                dialog(getString(R.string.error),getString(R.string.enter_first_name));
            }
            else if(lastName.isEmpty()){
                dialog(getString(R.string.error),getString(R.string.enter_last_name));
            }
            else if(phoneNumberSignUP.isEmpty()){
                dialog(getString(R.string.error),getString(R.string.enter_phone_number_correct));
            }
            else if(passwordSignUP.isEmpty()){
                dialog(getString(R.string.error),getString(R.string.enter_password_correct));
            }
            else if(pcSignUp.isEmpty()){
                dialog(getString(R.string.error),getString(R.string.enter_pass_conf));
            }else{
            sendVerificationCode("+2$number")
            }
        }

        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            // This method is called when the verification is completed
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {

                Log.d("GFG" , "onVerificationCompleted Success")
            }

            // Called when verification is failed add log statement to see the exception
            override fun onVerificationFailed(e: FirebaseException) {
                Log.d("GFG" , "onVerificationFailed  $e")
            }

            // On code is sent by the firebase this method is called
            // in here we start a new activity where user can enter the OTP
            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                Log.d("GFG","onCodeSent: $verificationId")
                storedVerificationId = verificationId
                resendToken = token
                bundle.putString("verificationId", storedVerificationId)
                showFragment(VerficationFragment(), bundle)
            }
        }

        return view
    }

    public fun sendVerificationCode(number: String) {
        val options = activity?.let {
            PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(number) // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(it) // Activity (for callback binding)
                .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
                .build()
        }
        if (options != null) {
            PhoneAuthProvider.verifyPhoneNumber(options)
        }
        Log.d("GFG" , "Auth started")
    }

    private fun showFragment(fragment: Fragment, bundle: Bundle) {
        fragment.setArguments(bundle)
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
    fun dialog(title: String?, message: String?) {
        MaterialAlertDialogBuilder(requireActivity())
            .setTitle(title)
            .setMessage(message)
            .show()
    }
}
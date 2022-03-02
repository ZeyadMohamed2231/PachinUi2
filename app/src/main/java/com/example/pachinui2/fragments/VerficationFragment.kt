package com.example.pachinui2.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.pachinui2.CircularIndeterminateProgressBar
import com.example.pachinui2.R
import com.example.pachinui2.fragments.LoginFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider



// create instance of firebase auth
private lateinit var auth: FirebaseAuth
var userPassword:String?=""
var phoneNumber:String?=""
var verCodeEt:String?=""
class VerficationFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_verfication, container, false)
        val textField = view.findViewById<EditText>(R.id.et_code)
        val button = view.findViewById<Button>(R.id.ok_verf)
        auth=FirebaseAuth.getInstance()
        val bundle= this.getArguments()
        if (bundle != null) {
            val storedVerificationId = bundle.getString("verificationId")
            userPassword= bundle.getString("password")
            phoneNumber= bundle.getString("phoneNumber")
        }

        button.setOnClickListener {
            verCodeEt = view.findViewById<EditText>(R.id.et_code).text.toString()

            if(verCodeEt!!.isEmpty()){
                dialog(getString(R.string.error),getString(R.string.enter_ver_code))
            }else{


                view.findViewById<ComposeView>(R.id.compose_view_verification).setContent {
                    CircularIndeterminateProgressBar(isDisplayed = true)
                }

            val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(
                storedVerificationId.toString(), verCodeEt!!
            )
            signInWithPhoneAuthCredential(credential)}
        }
        return view
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    showFragment(LoginFragment())
                } else {
                    Log.d("error","task failed")
                    // Sign in failed, display a message and update the UI(can be for internet or something else)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                        Log.d("invalid","invalid code")
                    }
                }
            }
    }

    private fun signUpEmail(auth: FirebaseAuth,userPhone:String?,userPassword:String?) {

        if (userPhone != null && userPassword != null) {
            auth.createUserWithEmailAndPassword(userPhone, userPassword)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        Log.d("Email","created account successfully !")
                        showFragment(LoginFragment())
                    } else {
                        Log.d("Email","failed to create email, something went wrong(probably internet)")
                    }
                }
        }else{
            Log.d("alert","display unknown error")
        }
    }




    private fun showFragment(fragment: Fragment) {
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
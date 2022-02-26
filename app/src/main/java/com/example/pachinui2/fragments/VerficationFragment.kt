package com.example.pachinui2.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.pachinui2.R
import com.example.pachinui2.fragments.LoginFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider


// create instance of firebase auth


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
        button.setOnClickListener {
            Log.i("1",textField.text.toString())
            showFragment(LoginFragment())
        }
        return view
    }

    private fun showFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}
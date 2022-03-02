package com.example.pachinui2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.pachinui2.CircularIndeterminateProgressBar
import com.example.pachinui2.R
import com.example.pachinui2.fragments.VerficationFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ForgetPassFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_forget_pass, container, false)
        val button = view.findViewById<Button>(R.id.bt_changepass)
        button.setOnClickListener {
            val phoneNumberFP = view.findViewById<EditText>(R.id.et_phone_fp).text.toString()
            val newPasswordFP = view.findViewById<EditText>(R.id.et_password_fp).text.toString()
            val passConfFP = view.findViewById<EditText>(R.id.et_password_conf_fp).text.toString()

            if(phoneNumberFP.isEmpty()){
                dialog(getString(R.string.error),getString(R.string.enter_phone_number_correct))
            }else if(newPasswordFP.isEmpty()){
                dialog(getString(R.string.error),getString(R.string.enter_password_correct))
            }else if(passConfFP.isEmpty()){
                dialog(getString(R.string.error),getString(R.string.enter_pass_conf))
            }else{
            showFragment(VerficationFragment())
            }
        }
        return view
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
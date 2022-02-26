package com.example.pachinui2.secondfragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.pachinui2.R
import com.example.pachinui2.SecondScreen
import com.example.pachinui2.secondfragments.ScoreFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ExpsFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_exps, container, false)
        val button = view.findViewById<Button>(R.id.bt_OK_exps)
        button.setOnClickListener {

            val codeEt = view.findViewById<EditText>(R.id.et_code_exps).text.toString()
            if(codeEt.isEmpty()){
                dialog(getString(R.string.error),getString(R.string.enter_code))
            }
            else{
            activity?.finish()
            val intent = Intent(activity, SecondScreen::class.java)
            startActivity(intent)
            }
        }
        return view
    }

    private fun showFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout2, fragment)
            .commit()
    }
    fun dialog(title: String?, message: String?) {
        MaterialAlertDialogBuilder(requireActivity())
            .setTitle(title)
            .setMessage(message)
            .show()
    }
}
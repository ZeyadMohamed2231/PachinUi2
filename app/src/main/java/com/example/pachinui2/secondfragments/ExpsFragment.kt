package com.example.pachinui2.secondfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.pachinui2.R
import com.example.pachinui2.secondfragments.ScoreFragment

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
        button.setOnClickListener { showFragment(ScoreFragment()) }
        return view
    }

    private fun showFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout2, fragment)
            .commit()
    }
}
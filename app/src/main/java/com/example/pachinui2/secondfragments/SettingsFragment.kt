package com.example.pachinui2.secondfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.pachinui2.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.example.pachinui2.secondfragments.SettingsFragment
import com.example.pachinui2.secondfragments.ScoreFragment
import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.pachinui2.SecondScreen
import java.util.*

class SettingsFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        val button_arabic = view.findViewById<Button>(R.id.bt_arabic_settings)
        button_arabic.setOnClickListener { goToArabic() }
        val button_english = view.findViewById<Button>(R.id.bt_english_settings)
        button_english.setOnClickListener { goToEnglish() }
        val button_sign_out = view.findViewById<Button>(R.id.sign_out)
        button_sign_out.setOnClickListener { dialog("Title", "Message") }
        return view
    }

    fun dialog(title: String?, message: String?) {
        MaterialAlertDialogBuilder(requireActivity())
            .setTitle(title)
            .setMessage(message) //                .setPositiveButton("OK",
            //                        new DialogInterface.OnClickListener() {
            //                            public void onClick(DialogInterface dialog, int whichButton) {
            //                                dialog.cancel();
            //                            }
            //                        }
            //                )
            .show()
    }

    fun goToEnglish() {
        setLocale(activity, "en")
        activity?.finish()
        val intent = Intent(activity, SecondScreen::class.java)
        startActivity(intent)


    }

    fun goToArabic() {
        setLocale(activity, "ar")
        activity?.finish()
        val intent = Intent(activity, SecondScreen::class.java)
        startActivity(intent)
    }

//    private fun showFragment(fragment: Fragment) {
//        parentFragmentManager
//            .beginTransaction()
//            .replace(R.id.frame_layout2, fragment)
//            .commit()
//    }

    companion object {
        fun setLocale(activity: Activity?, languageCode: String?) {
            val locale = Locale(languageCode)
            Locale.setDefault(locale)
            val resources = activity!!.resources
            val configuration = resources.configuration
            configuration.setLocale(locale)
            resources.updateConfiguration(configuration, resources.displayMetrics)
        }
    }
}
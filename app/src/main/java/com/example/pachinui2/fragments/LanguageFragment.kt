package com.example.pachinui2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.pachinui2.R
import com.example.pachinui2.fragments.LanguageFragment
import com.example.pachinui2.fragments.LoginFragment
import android.app.Activity
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import java.util.*

class LanguageFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_language, container, false)
        val button_arabic = view.findViewById<Button>(R.id.bt_arabic)
        button_arabic.setOnClickListener { goToArabic() }
        val button_english = view.findViewById<Button>(R.id.bt_english)
        button_english.setOnClickListener { goToEnglish() }
        return view
    }

    fun goToEnglish() {
        setLocale(activity, "en")
        showFragment(LoginFragment())
    }

    fun goToArabic() {
        setLocale(activity, "ar")
        showFragment(LoginFragment())
    }

    private fun showFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)

            .commit()
    }

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
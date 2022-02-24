package com.example.pachinui2.secondfragments;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pachinui2.R;
import com.example.pachinui2.fragments.LoginFragment;

import java.util.Locale;


public class SettingsFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        Button button_arabic = view.findViewById(R.id.bt_arabic_settings);
        button_arabic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToArabic();
            }
        });

        Button button_english = view.findViewById(R.id.bt_english_settings);
        button_english.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToEnglish();
            }
        });




        return view;
    }

    public void goToEnglish() {
        setLocale(getActivity(),"en");
        showFragment(new ScoreFragment());
    }

    public void goToArabic() {
        setLocale(getActivity(),"ar");
        showFragment(new ScoreFragment());
    }
    public static void setLocale(Activity activity, String languageCode) {

        Locale locale = new Locale(languageCode);
        locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration,resources.getDisplayMetrics());

    }

    private void showFragment(Fragment fragment){
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout2,fragment)
                .commit();
    }
}
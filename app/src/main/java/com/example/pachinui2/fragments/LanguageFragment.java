package com.example.pachinui2.fragments;

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

import java.util.Locale;


public class LanguageFragment extends Fragment {


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
        View view = inflater.inflate(R.layout.fragment_language, container, false);



        Button button_arabic = view.findViewById(R.id.bt_arabic);
        button_arabic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToArabic();
            }
        });

        Button button_english = view.findViewById(R.id.bt_english);
        button_english.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToEnglish();
            }
        });




        return view;
    }

    public void goToEnglish() {
        setLocale(getActivity(),"en");
        showFragment(new LoginFragment());
    }

    public void goToArabic() {
        setLocale(getActivity(),"ar");
        showFragment(new LoginFragment());
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
                .replace(R.id.frame_layout,fragment)
                .commit();
    }
}
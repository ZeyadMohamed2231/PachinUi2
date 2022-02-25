package com.example.pachinui2.secondfragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pachinui2.R;
import com.example.pachinui2.fragments.LoginFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

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

        Button button_sign_out = view.findViewById(R.id.sign_out);
        button_sign_out.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog("Title","Message");

            }
        });


        return view;
    }

    public void dialog(String title,String message){
        new MaterialAlertDialogBuilder(getActivity())
                .setTitle(title)
                .setMessage(message)
//                .setPositiveButton("OK",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int whichButton) {
//                                dialog.cancel();
//                            }
//                        }
//                )
                .show();


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
package com.example.pachinui2.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pachinui2.R;
import com.example.pachinui2.SecondScreen;

public class LoginFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        TextView tv_signup= view.findViewById(R.id.tv_signup);

        tv_signup.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                showFragment(new SignupFragment());
            }
        });

        TextView tv_forget_pass= view.findViewById(R.id.tv_fp);

        tv_forget_pass.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                showFragment(new ForgetPassFragment());
            }
        });

        Button button_signup = view.findViewById(R.id.bt_sign_in);
        button_signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SecondScreen.class);
                startActivity(intent);
            }
        });



        return view;


    }

    private void showFragment(Fragment fragment){
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();
    }
}



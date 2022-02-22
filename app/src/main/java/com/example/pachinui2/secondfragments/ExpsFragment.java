package com.example.pachinui2.secondfragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pachinui2.R;


public class ExpsFragment extends Fragment {


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
        View view = inflater.inflate(R.layout.fragment_exps, container, false);


        Button button = view.findViewById(R.id.bt_OK_exps);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                showFragment(new ScoreFragment());
            }
        });


        return view;
    }
    private void showFragment(Fragment fragment){
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout2,fragment)
                .commit();
    }
}
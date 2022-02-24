package com.example.pachinui2.secondfragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pachinui2.R;
import com.example.pachinui2.ScoreAdapter;
import com.example.pachinui2.ScoreModel;
import com.example.pachinui2.SecondScreen;
import com.example.pachinui2.fragments.ForgetPassFragment;
import com.example.pachinui2.fragments.VerficationFragment;

import java.util.ArrayList;


public class ScoreFragment extends Fragment {


    ArrayList<ScoreModel> score_products =new ArrayList<>();
    RecyclerView recyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_score, container, false);



        recyclerView =view.findViewById(R.id.rv_advs);

        prepareData();

        ScoreAdapter socreAdapter = new ScoreAdapter(score_products);
        recyclerView.setAdapter(socreAdapter);




        return view;
    }
    private void showFragment(Fragment fragment){
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout2,fragment)
                .commit();
    }


    private void prepareData() {

        ScoreModel scoreModel= new ScoreModel(R.drawable.logo);
        score_products.add(scoreModel);
        ScoreModel scoreModel1= new ScoreModel(R.drawable.splash);
        score_products.add(scoreModel1);
        ScoreModel scoreModel2= new ScoreModel(R.drawable.image);
        score_products.add(scoreModel2);

    }
}
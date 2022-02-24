package com.example.pachinui2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.pachinui2.fragments.SplashFragment;
import com.example.pachinui2.secondfragments.ExpsFragment;
import com.example.pachinui2.secondfragments.ScoreFragment;
import com.example.pachinui2.secondfragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class SecondScreen extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        showFragment(new ScoreFragment());
        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);



                if(item.getItemId() == R.id.item_profile){
                    showFragment(new ScoreFragment());
                } else if (item.getItemId() == R.id.item_recharge){
                    showFragment(new ExpsFragment());
                } else if (item.getItemId() == R.id.item_settings){
                    showFragment(new SettingsFragment());
                }


                return false;
            }
        });


    }

    private void showFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout2,fragment)
                .commit();
    }
}
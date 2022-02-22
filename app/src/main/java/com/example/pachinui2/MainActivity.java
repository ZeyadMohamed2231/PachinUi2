package com.example.pachinui2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pachinui2.fragments.LoginFragment;
import com.example.pachinui2.fragments.SignupFragment;
import com.example.pachinui2.fragments.SplashFragment;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Timer mTimer;
    private TimerTask mTimerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragment(new SplashFragment());
        mTimerTask = new TimerTask() {

            @Override
            public void run() {
                showFragment(new LoginFragment());
            }
        };
        mTimer = new Timer();
        mTimer.schedule(mTimerTask, 3000);
    }

    private void showFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();
    }
}
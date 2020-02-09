package com.example.freshmarket.ui.splashactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import com.example.freshmarket.R;
import com.example.freshmarket.ui.homeactivity.HomeActivity;
import com.example.freshmarket.ui.slideractivity.SliderActivity;

public class SplashActivity extends AppCompatActivity {
   private SharedPreferences sharedPreferences;
   private boolean firstStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedPreferences=getSharedPreferences("shared",MODE_PRIVATE);
        firstStart = sharedPreferences.getBoolean("firstStart", true);
        goToFirstActivity();


    }

    private void goToFirstActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (firstStart)
                    showSliderActivity();
                else
                    showHomeActivity();
            }
        }, 1500);
    }

    private void showHomeActivity(){
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    private void showSliderActivity(){
        startActivity(new Intent(this, SliderActivity.class));
        finish();
        SharedPreferences prefs = getSharedPreferences("shared", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }
}

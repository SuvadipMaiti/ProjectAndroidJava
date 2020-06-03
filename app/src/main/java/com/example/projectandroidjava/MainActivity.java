package com.example.projectandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this code will pause the app for 1.5 sec and then anything in run method will run
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                isFirstTime();
            }
        },1500);

    }

    private void isFirstTime() {
        //for checking if the app is running for the very first time.
        //we need to save a value to share preference.
        SharedPreferences preferences = getApplication().getSharedPreferences("onBoard", Context.MODE_PRIVATE);
        boolean isFirstTime = preferences.getBoolean("isFirstTime",true);
        //default value true
        if(isFirstTime) {
            //if it's true then first time and we will change it false
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstTime", false);
            editor.apply();

            //start Auth activity
            startActivity(new Intent(MainActivity.this,OnboardActivity.class));
            finish();
        }else{
            ////start home activity
            startActivity(new Intent(MainActivity.this, AuthActivity.class));
            finish();
        }
    }
}
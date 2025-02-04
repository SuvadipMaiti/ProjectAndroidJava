package com.example.projectandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projectandroidjava.Fragments.SigninFragment;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameAuthContainer, new SigninFragment()).commit();
    }
}
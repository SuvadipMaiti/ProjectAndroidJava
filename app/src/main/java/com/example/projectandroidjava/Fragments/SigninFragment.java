package com.example.projectandroidjava.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.projectandroidjava.AuthActivity;
import com.example.projectandroidjava.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SigninFragment extends Fragment {

    private View view;

    private TextInputLayout layoutEmail,layoutPassword;
    private TextInputEditText txtEmail,txtPassword;
    private Button btnSignIn;

    private TextView txtSignUp;



    public SigninFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_sign_in,container,false);
        init();
        return view;
    }

    private void init() {
        layoutPassword = view.findViewById(R.id.txtLayoutPasswordSignIn);
        layoutEmail = view.findViewById(R.id.txtLayoutEmailSignIn);
        txtPassword = view.findViewById(R.id.txtPasswordSignIn);
        txtEmail = view.findViewById(R.id.txtEmailSignIn);
        btnSignIn = view.findViewById(R.id.btnSignIn);

        txtSignUp = view.findViewById(R.id.txtSignUp);

        txtSignUp.setOnClickListener(v->{
            //change fragments
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameAuthContainer,new SignUpFragment()).commit();
        });

        btnSignIn.setOnClickListener(v->{
            //validate field first
            if(validate()){
                //do something
            }
        });

        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!txtEmail.getText().toString().isEmpty()){
                    layoutEmail.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(txtPassword.getText().toString().length() > 7){
                    layoutPassword.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }



    private boolean validate() {
        if(txtEmail.getText().toString().isEmpty()){
            layoutEmail.setErrorEnabled(true);
            layoutEmail.setError("Email is Required.");
            return false;
        }
        if(txtPassword.getText().toString().length() < 8 ){
            layoutPassword.setErrorEnabled(true);
            layoutPassword.setError("Required at least 8 characters.");
            return false;
        }
        return true;
    }
}

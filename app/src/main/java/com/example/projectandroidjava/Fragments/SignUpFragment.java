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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.projectandroidjava.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpFragment extends Fragment {
    private View view;

    private TextInputLayout layoutEmail,layoutPassword,layoutConfirm;
    private TextInputEditText txtEmail,txtPassword, txtConfirm;
    private Button btnSignUp;

    private TextView txtSignIn;


    public SignUpFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_sign_up,container,false);
        init();
        return view;
    }



    private void init() {
        layoutPassword = view.findViewById(R.id.txtLayoutPasswordSignUp);
        layoutConfirm = view.findViewById(R.id.txtLayoutConfirmSignUp);
        layoutEmail = view.findViewById(R.id.txtLayoutEmailSignUp);
        txtPassword = view.findViewById(R.id.txtPasswordSignUp);
        txtConfirm = view.findViewById(R.id.txtConfirmSignUp);
        txtEmail = view.findViewById(R.id.txtEmailSignUp);
        btnSignUp = view.findViewById(R.id.btnSignUp);

        txtSignIn = view.findViewById(R.id.txtSignIn);

        txtSignIn.setOnClickListener(v->{
            //change fragments
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameAuthContainer,new SigninFragment()).commit();
        });

        btnSignUp.setOnClickListener(v->{
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
        txtConfirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(txtConfirm.getText().toString().equals(txtPassword.getText().toString()) ){
                    layoutConfirm.setErrorEnabled(false);
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
        if(!txtConfirm.getText().toString().equals(txtPassword.getText().toString()) ){
            layoutConfirm.setErrorEnabled(true);
            layoutConfirm.setError("Password does not match.");
            return false;
        }
        return true;
    }


}

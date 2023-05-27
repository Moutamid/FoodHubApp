package com.moutamid.foodhubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

import com.moutamid.foodhubapp.databinding.ActivitySignUpBinding;
import com.moutamid.foodhubapp.model.User;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;
    private String fname, lname, email, password;
    ProgressDialog pd;
    private DBHandler databaseHelper;
    private SharedPreferencesManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DBHandler(SignUpActivity.this);
        manager = new SharedPreferencesManager(SignUpActivity.this);
        binding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validInfo()) {
                    pd = new ProgressDialog(SignUpActivity.this);
                    pd.setMessage("Creating Account....");
                    pd.show();
                    registerUser();
                }

            }
        });
        binding.arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void registerUser() {
        User user = new User();
        user.setName(fname);
        user.setSurname(lname);
        user.setEmail(email);
        user.setPassword(password);
        databaseHelper.addUser(user);
        manager.storeString("email",email);
        sendActivityToHome();
    }


    private void sendActivityToHome() {
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    public boolean validInfo() {

        email = binding.email.getText().toString();
        password = binding.password.getText().toString();
        fname = binding.fname.getText().toString();
        lname = binding.lname.getText().toString();

        if (fname.isEmpty()) {
            binding.fname.setError("Input First Name!");
            binding.fname.requestFocus();
            return false;
        }
        if (lname.isEmpty()) {
            binding.lname.setError("Input Last Name!");
            binding.lname.requestFocus();
            return false;
        }

        if (email.isEmpty()) {
            binding.email.setError("Input email!");
            binding.email.requestFocus();
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.email.setError("Please input valid email!");
            binding.email.requestFocus();
            return false;
        }

        if (password.isEmpty()) {
            binding.password.setError("Input password!");
            binding.password.requestFocus();
            return false;
        }

        return true;
    }
}
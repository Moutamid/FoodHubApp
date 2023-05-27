package com.moutamid.foodhubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.moutamid.foodhubapp.databinding.ActivityLoginBinding;
import com.moutamid.foodhubapp.model.User;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private String email, password;
    ProgressDialog pd;
    private DBHandler databaseHelper;
    private SharedPreferencesManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DBHandler(LoginActivity.this);
        manager = new SharedPreferencesManager(LoginActivity.this);
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validInfo()) {
                    pd = new ProgressDialog(LoginActivity.this);
                    pd.setMessage("Creating Account....");
                    pd.show();
                    loginUser();
                }

            }
        });
        binding.arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private boolean validInfo() {
        email = binding.email.getText().toString();
        password = binding.password.getText().toString();

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

    private void loginUser() {
        boolean isExists = databaseHelper.checkUser(email,password);
        if (isExists){
            manager.storeString("email",email);
            sendActivityToHome();
        }else {
            Toast.makeText(this, "You are not registered!", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendActivityToHome() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

}
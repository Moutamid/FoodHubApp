package com.moutamid.foodhubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.moutamid.foodhubapp.databinding.ActivityProfileImformationBinding;
import com.moutamid.foodhubapp.model.User;

public class ProfileImformation extends AppCompatActivity {

    private ActivityProfileImformationBinding binding;
    private SharedPreferencesManager manager;
    private DBHandler dbHandler;
    private String email;
    private String version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileImformationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dbHandler = new DBHandler(ProfileImformation.this);
        manager = new SharedPreferencesManager(ProfileImformation.this);
        version = manager.retrieveString("billing","Free Version");
        email = manager.retrieveString("email","");
        getUserDetails();

        binding.arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileImformation.this,MainActivity.class));
                finish();
            }
        });
        binding.logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.storeString("email","");
                startActivity(new Intent(ProfileImformation.this,LoginActivity.class));
                finish();
            }
        });
    }


    @SuppressLint("Range")
    private void getUserDetails() {
        User user = dbHandler.getUser(email);
        binding.name.setText(user.getName());
        binding.surName.setText(user.getSurname());
        binding.email.setText(user.getEmail());
        binding.paid.setText(version);
    }
}
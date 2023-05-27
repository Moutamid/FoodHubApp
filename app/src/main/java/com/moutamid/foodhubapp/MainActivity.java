package com.moutamid.foodhubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.moutamid.foodhubapp.databinding.ActivityMainBinding;
import com.moutamid.foodhubapp.model.User;
import com.moutamid.foodhubapp.utils.Constants;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DBHandler dbHandler;
    private SharedPreferencesManager manager;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Constants.checkApp(MainActivity.this);
        dbHandler = new DBHandler(MainActivity.this);
        manager = new SharedPreferencesManager(MainActivity.this);
        email = manager.retrieveString("email","");
        getUserDetails();

        binding.product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ProductScreen.class));
                finish();
            }
        });
        binding.ingredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,IngredientsScreen.class));
                finish();
            }
        });
        binding.recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PersonalRecipes.class));
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
        binding.paid.setText("No");
    }
}
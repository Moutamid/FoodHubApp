package com.moutamid.foodhubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.moutamid.foodhubapp.databinding.ActivityRecipeWebScreenBinding;

public class RecipeWebScreen extends AppCompatActivity {

    private ActivityRecipeWebScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecipeWebScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}
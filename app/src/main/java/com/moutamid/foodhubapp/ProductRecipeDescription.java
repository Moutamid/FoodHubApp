package com.moutamid.foodhubapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.moutamid.foodhubapp.databinding.ActivityProductRecipeDescriptionBinding;
import com.moutamid.foodhubapp.model.Ingredients;

import java.lang.reflect.Array;

public class ProductRecipeDescription extends AppCompatActivity {

    private ActivityProductRecipeDescriptionBinding binding;
    private Ingredients model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductRecipeDescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        final Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        model = getIntent().getParcelableExtra("model");
        mToolbar.setTitle(model.getName());
        binding.title.setTitle(model.getName());
        binding.imageView.setImageResource(model.getImage());
        binding.recipe.setText(model.getRecipe());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ProductRecipeDescription.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,model.getIngredients());
        binding.listView.setAdapter(adapter);

    }
}
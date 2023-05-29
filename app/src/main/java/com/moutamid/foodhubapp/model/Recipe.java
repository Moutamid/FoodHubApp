package com.moutamid.foodhubapp.model;

import android.graphics.Bitmap;

public class Recipe {

    private int id;
    private String name;
    private String description;
    private Bitmap image;

    public Recipe(){

    }

    public Recipe(String name, String description, Bitmap image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

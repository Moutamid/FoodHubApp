package com.moutamid.foodhubapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class Ingredients implements Parcelable {

    private String name;
    private List<String> ingredients;
    private String recipe;
    private int image;

    public Ingredients(){

    }

    public Ingredients(String name, List<String> ingredients, int image,String recipe) {
        this.name = name;
        this.ingredients = ingredients;
        this.image = image;
        this.recipe = recipe;
    }

    protected Ingredients(Parcel in) {
        name = in.readString();
        ingredients = in.createStringArrayList();
        recipe = in.readString();
        image = in.readInt();
    }

    public static final Creator<Ingredients> CREATOR = new Creator<Ingredients>() {
        @Override
        public Ingredients createFromParcel(Parcel in) {
            return new Ingredients(in);
        }

        @Override
        public Ingredients[] newArray(int size) {
            return new Ingredients[size];
        }
    };

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeStringList(ingredients);
        dest.writeString(recipe);
        dest.writeInt(image);
    }
}

package com.moutamid.foodhubapp.model;

public class Ingredients {

    private String name;
    private String link;
    private double quantity;

    public Ingredients(){

    }

    public Ingredients(String name, String link,double quantity) {
        this.name = name;
        this.link = link;
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

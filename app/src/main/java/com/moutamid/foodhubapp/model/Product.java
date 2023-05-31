package com.moutamid.foodhubapp.model;

public class Product {

    private int id;
    private String productName;
    private String expiryDate;
    private byte[] imgByte;

    public Product(String productName, String expiryDate,byte[] imgByte) {
        this.productName = productName;
        this.expiryDate = expiryDate;
        this.imgByte = imgByte;
    }

    public Product(){

    }

    public byte[] getImgByte() {
        return imgByte;
    }

    public void setImgByte(byte[] imgByte) {
        this.imgByte = imgByte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}

package com.example.serveripwcr.models;

public class Product {
    private long productNumber;
    private String name;
    private String description;
    private int price;
    private int amountInStorage;
    private boolean isSoldOut;

    public Product(long productNumber, String name, String description, int price, int amountInStorage, boolean isSoldOut) {
        this.productNumber = productNumber;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStorage = amountInStorage;
        this.isSoldOut = isSoldOut;
    }

    public Product() {
    }

    public long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(long productNumber) {
        this.productNumber = productNumber;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmountInStorage() {
        return amountInStorage;
    }

    public void setAmountInStorage(int amountInStorage) {
        this.amountInStorage = amountInStorage;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }
}

package com.example.serveripwcr.models;

import java.util.List;

public class Cart {
    private  Long cartNumber;
    private int amountOfProducts;
    private List<Product> products;
    private float totalPrice;
    private boolean readyToOrder;

    public Cart(Long cartNumber, int amountOfProducts, List<Product> products, float totalPrice, boolean readyToOrder) {
        this.cartNumber = cartNumber;
        this.amountOfProducts = amountOfProducts;
        this.products = products;
        this.totalPrice = totalPrice;
        this.readyToOrder = readyToOrder;
    }

    public Cart() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(Long cartNumber) {
        this.cartNumber = cartNumber;
    }

    public int getAmountOfProducts() {
        return amountOfProducts;
    }

    public void setAmountOfProducts(int amountOfProducts) {
        this.amountOfProducts = amountOfProducts;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isReadyToOrder() {
        return readyToOrder;
    }

    public void setReadyToOrder(boolean readyToOrder) {
        this.readyToOrder = readyToOrder;
    }
}

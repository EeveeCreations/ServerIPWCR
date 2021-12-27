package com.example.serveripwcr.models;

public class Order {
    private Long OrderNumber;
    private Cart cart;
    private boolean isCompleted;

    public Order(Long orderNumber, Cart cart, boolean isCompleted) {
        OrderNumber = orderNumber;
        this.cart = cart;
        this.isCompleted = isCompleted;
    }

    public Order() {
    }

    public Long getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        OrderNumber = orderNumber;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}

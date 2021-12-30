package com.example.serveripwcr.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_nr")
    private  Long id;
    private int amountOfProducts;
    @OneToMany(targetEntity = CartItem.class)
    private List<Product> products;
    @Column(name = "total_price")
    private float totalPrice;
    @Column(name = "ordered")
    private boolean isOrdered;

    public Cart(Long id, int amountOfProducts, List<Product> products, float totalPrice, boolean isOrdered) {
        this.id = id;
        this.amountOfProducts = amountOfProducts;
        this.products = products;
        this.totalPrice = totalPrice;
        this.isOrdered = isOrdered;
    }

    public Cart(int amountOfProducts, List<Product> products, float totalPrice, boolean isOrdered) {
        this.amountOfProducts = amountOfProducts;
        this.products = products;
        this.totalPrice = totalPrice;
        this.isOrdered = isOrdered;
    }

    public Cart() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long cartNumber) {
        this.id = cartNumber;
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

    public boolean isIsOrdered() {
        return isOrdered;
    }

    public void setIsOrdered(boolean readyToOrder) {
        this.isOrdered = readyToOrder;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}

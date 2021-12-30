package com.example.serveripwcr.models;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Product productNr;

    private int amount;

    public CartItem(long id, Product productNr, int amount) {
        this.id = id;
        this.productNr = productNr;
        this.amount = amount;
    }

    public CartItem(Product productNr, int amount) {
        this.productNr = productNr;
        this.amount = amount;
    }

    public CartItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProductNr() {
        return productNr;
    }

    public void setProductNr(Product productNr) {
        this.productNr = productNr;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

package com.example.serveripwcr.models;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_nr")
    private long productNumber;
    private String name;
    private String description;
    private int price;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "storage", referencedColumnName = "product_nr")
    private Storage storage;


    public Product(long productNumber, String name, String description, int price, Storage storage) {
        this.productNumber = productNumber;
        this.name = name;
        this.description = description;
        this.price = price;
        this.storage = storage;
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

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}

package com.platzi.marken.domain;

public class Product {
    private Integer productId;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
    private Category category;


    /*Seter*/
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    /*Geter*/
    public Integer getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public boolean isActive() {
        return active;
    }

    public Category getCategory() {
        return category;
    }







}

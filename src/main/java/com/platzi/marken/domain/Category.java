package com.platzi.marken.domain;

public class Category {

    private Integer categoryId;
    private String category;
    private  boolean active;


    /*Seter*/
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    /*Geter*/
    public Integer getCategoryId() {
        return categoryId;
    }

    public String getCategory() {
        return category;
    }

    public boolean isActive() {
        return active;
    }

}

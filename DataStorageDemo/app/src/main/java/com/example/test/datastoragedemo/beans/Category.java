package com.example.test.datastoragedemo.beans;

import org.litepal.crud.LitePalSupport;

/**
 * Created by believe563 on 2019/7/13.
 */
public class Category extends LitePalSupport {
    private int id;
    private String categoryName;
    private int categoryCode;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

}

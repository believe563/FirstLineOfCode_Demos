package com.example.test.RecyclerView;

/**
 * Created by believe563 on 2019/2/19.
 * 创建Fruit类
 */
public class Fruit {
    private String name;
    private int imageId;

    public Fruit(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}

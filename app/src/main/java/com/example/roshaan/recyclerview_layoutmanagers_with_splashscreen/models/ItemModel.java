package com.example.roshaan.recyclerview_layoutmanagers_with_splashscreen.models;

/**
 * Created by Roshaan on 1/25/2018.
 */

public class ItemModel {
    String name;
    int image;

    public ItemModel(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

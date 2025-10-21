package com.example.test_4;

import androidx.annotation.NonNull;

public class Dish {
    String title;
    String desc;
    int price;

    Dish(String title, String desc, int price){
        this.title = title;
        this.desc = desc;
        this.price = price;
    }

    @NonNull
    @Override
    public String toString() {
        return title + " | $" + price;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getPrice() {
        return price;
    }
}
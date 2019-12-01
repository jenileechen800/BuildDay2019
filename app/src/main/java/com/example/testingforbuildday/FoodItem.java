package com.example.testingforbuildday;

public class FoodItem {
    public String name;
    public String description;
    public String category;

    FoodItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    FoodItem(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }
}
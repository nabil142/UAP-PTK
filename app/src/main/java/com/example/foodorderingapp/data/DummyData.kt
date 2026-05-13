package com.example.foodorderingapp.data

import com.example.foodorderingapp.model.FoodItem

object DummyData {

    fun getFoodItems(): MutableList<FoodItem> {
        return mutableListOf(
            FoodItem(1, "Burger", 25000),
            FoodItem(2, "Pizza", 50000),
            FoodItem(3, "Mie Ayam", 18000),
            FoodItem(4, "Es Teh", 5000),
            FoodItem(5, "Ayam Geprek", 22000)
        )
    }
}
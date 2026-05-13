package com.example.foodorderingapp.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue

class FoodItem(
    val id: Int,
    val name: String,
    val price: Int,
    quantity: Int = 0
) {

    var quantity by mutableIntStateOf(quantity)
}
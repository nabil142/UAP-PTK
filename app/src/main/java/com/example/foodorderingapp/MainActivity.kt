package com.example.foodorderingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.foodorderingapp.data.DummyData
import com.example.foodorderingapp.navigation.AppNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val foodList = remember {
                mutableStateListOf(
                    *DummyData.getFoodItems().toTypedArray()
                )
            }

            AppNavigation(foodList)
        }
    }
}
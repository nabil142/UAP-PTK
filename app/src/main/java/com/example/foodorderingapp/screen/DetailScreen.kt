package com.example.foodorderingapp.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodorderingapp.model.FoodItem

@Composable
fun DetailScreen(
    foodItem: FoodItem,
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Food Detail",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = foodItem.name,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Price: Rp${foodItem.price}")

        Spacer(modifier = Modifier.height(8.dp))

        Text("Quantity: ${foodItem.quantity}")

        Spacer(modifier = Modifier.height(16.dp))

        Row {

            Button(
                onClick = {
                    foodItem.quantity++
                }
            ) {
                Text("+")
            }

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            Button(
                onClick = {

                    if (foodItem.quantity > 0) {
                        foodItem.quantity--
                    }
                }
            ) {
                Text("-")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                onBack()
            }
        ) {
            Text("Back")
        }
    }
}
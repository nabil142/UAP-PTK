package com.example.foodorderingapp.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodorderingapp.model.FoodItem

@Composable
fun MenuScreen(
    foodList: MutableList<FoodItem>,
    onDetailClick: (Int) -> Unit
) {

    val totalItems =
        foodList.sumOf { it.quantity }

    val totalPrice =
        foodList.sumOf { it.quantity * it.price }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Food Menu",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (totalItems == 0) {

            Text("No orders yet")

        } else {

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text("Total Items: $totalItems")

                    Text("Total Price: Rp$totalPrice")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(foodList) { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable {
                            onDetailClick(item.id)
                        }
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(item.name)

                        Text("Rp${item.price}")

                        Text("Quantity: ${item.quantity}")

                        Spacer(modifier = Modifier.height(8.dp))

                        Row {

                            Button(
                                onClick = {
                                    item.quantity++
                                }
                            ) {
                                Text("+")
                            }

                            Spacer(
                                modifier = Modifier.width(8.dp)
                            )

                            Button(
                                onClick = {

                                    if (item.quantity > 0) {
                                        item.quantity--
                                    }
                                }
                            ) {
                                Text("-")
                            }
                        }
                    }
                }
            }
        }
    }
}
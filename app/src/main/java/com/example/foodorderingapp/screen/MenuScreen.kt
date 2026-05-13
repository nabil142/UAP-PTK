package com.example.foodorderingapp.screen
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodorderingapp.model.FoodItem
import androidx.compose.runtime.saveable.rememberSaveable
@Composable
fun MenuScreen(
    foodList: MutableList<FoodItem>,
    onDetailClick: (Int) -> Unit
) {

    val totalItems =
        foodList.sumOf { it.quantity }

    val totalPrice =
        foodList.sumOf { it.quantity * it.price }

    var notes by rememberSaveable {
        mutableStateOf("")
    }

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

        // SUMMARY CARD
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                if (totalItems == 0) {

                    Text("No orders yet")

                } else {

                    Text(
                        text = "Order Summary",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    foodList
                        .filter { it.quantity > 0 }
                        .forEach { item ->

                            Text(
                                text =
                                    "${item.name} x${item.quantity}"
                            )

                            Text(
                                text =
                                    "Subtotal: Rp${item.quantity * item.price}"
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )
                        }

                    Divider()

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Total Items: $totalItems")

                    Text("Total Price: Rp$totalPrice")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = notes,
            onValueChange = {
                notes = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Order Notes")
            }
        )

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
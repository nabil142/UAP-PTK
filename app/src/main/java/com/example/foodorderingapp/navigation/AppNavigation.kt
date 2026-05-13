package com.example.foodorderingapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.foodorderingapp.screen.DetailScreen
import com.example.foodorderingapp.screen.MenuScreen
import com.example.foodorderingapp.model.FoodItem

@Composable
fun AppNavigation(foodList: MutableList<FoodItem>) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "menu"
    ) {

        composable("menu") {
            MenuScreen(
                foodList = foodList,
                onDetailClick = { id ->
                    navController.navigate("detail/$id")
                }
            )
        }

        composable(
            route = "detail/{itemId}",
            arguments = listOf(
                navArgument("itemId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val itemId =
                backStackEntry.arguments?.getInt("itemId")

            val selectedItem =
                foodList.find { it.id == itemId }

            selectedItem?.let {
                DetailScreen(
                    foodItem = it,
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
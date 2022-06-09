package com.aangles.cmestas.mquispeyn.navigation


import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aangles.cmestas.myquispeyn.screens.FirstScreen
import com.aangles.cmestas.myquispeyn.screens.SecondScreen

@ExperimentalMaterialApi
@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destinations.FirstScreen.route) {
        composable(route = Destinations.FirstScreen.route) {
            FirstScreen(navController)
        }
        composable(
            route = Destinations.SecondScreen.route
        ) {

            SecondScreen(navController)
        }
        composable(
            route = Destinations.SecondScreen.route + "/{text}" + "/{id}",
            arguments = listOf(
                navArgument(name = "text") {
                    type = NavType.StringType
                }
            )
        ) {


            SecondScreen(
                navController,

            )
        }

    }


}
package com.aangles.cmestas.mquispeyn.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CarRental
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route:String,
    val title: String,
    val icon: ImageVector
    ){
    object FirstScreen: Destinations("first_screen", "Pantall 1", Icons.Filled.Home)
    object SecondScreen: Destinations("second_screen", "Pantalla 2", Icons.Filled.CarRental)
    object EditUserScreen: Destinations("edit_user_screen?userId={userId}", "Editar usuario", Icons.Filled.Edit){
        fun passId(userId: Int?): String {
            return "edit?userId=$userId"
        }
    }
    object EditCarParkScreen: Destinations("edit_carpark_screen?carParkId={carParkId}", "Editar parqueo", Icons.Filled.Edit){
        fun passId(carParkId: Int?): String {
            return "edit?carParkId=$carParkId"
        }
    }


}
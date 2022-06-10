package com.aangles.cmestas.mquispeyn.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route:String,
    val title: String,
    val icon: ImageVector
    ){
    object FirstScreen: Destinations("first_screen", "Usuarios", Icons.Filled.Person)
    object SecondScreen: Destinations("second_screen", "Parqueos", Icons.Filled.LocationSearching)
    object EditUserScreen: Destinations("edit?userId={userId}", "Editar usuario", Icons.Filled.Edit){
        fun passId(userId: Int?): String {
            return "edit?userId=$userId"
        }
    }
    object EditCarParkScreen: Destinations("edit2?carParkId={carParkId}", "Editar parqueo", Icons.Filled.Edit){
        fun passId(carParkId: Int?): String {
            return "edit2?carParkId=$carParkId"
        }
    }

}
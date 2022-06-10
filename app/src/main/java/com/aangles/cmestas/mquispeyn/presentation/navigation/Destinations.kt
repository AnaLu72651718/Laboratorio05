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
    object EditUserScreen: Destinations("edit_user_screen?userId={userId}", "Editar usuario", Icons.Filled.Edit){
        fun passId(userId: Int?): String {
            return "edit?userId=$userId"
        }
    }

}
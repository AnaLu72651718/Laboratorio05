package com.aangles.cmestas.mquispeyn.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route:String,
    val title: String,
    val icon: ImageVector
    ){
    object FirstScreen: Destinations("first_screen", "Pantall 1", Icons.Filled.Home)
    object SecondScreen: Destinations("second_screen", "Pantalla 2", Icons.Filled.Search)


}
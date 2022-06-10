package com.aangles.cmestas.mquispeyn.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.aangles.cmestas.mquispeyn.presentation.components.BottomNavigationBar
import com.aangles.cmestas.mquispeyn.presentation.navigation.Destinations
import com.aangles.cmestas.mquispeyn.presentation.navigation.NavigationHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          MainScreen()
        }
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable

fun MainScreen() {
    val navController = rememberNavController()

    val navigationItems = listOf(
        Destinations.FirstScreen,
        Destinations.SecondScreen,
    )
    Scaffold(
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { null },
                backgroundColor = Color.Transparent,
                contentColor = Color.Transparent,
                elevation = FloatingActionButtonDefaults.elevation(0.dp,0.dp),
                modifier = Modifier
                    .size(75.dp)
                    .offset {
                        IntOffset(x = 0, y = -100000)
                    }
            ) {

            /* FAB content */
            }
        },
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
               cutoutShape = MaterialTheme.shapes.large.copy(
                    CornerSize(percent = 50)
                ),
                content = {
                    BottomNavigationBar(navController = navController, items = navigationItems)
                })
        }
    ) {
        NavigationHost(navController)
    }

}
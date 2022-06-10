package com.aangles.cmestas.mquispeyn.presentation.screens.parking

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aangles.cmestas.mquispeyn.R
import com.aangles.cmestas.mquispeyn.feature_db.domain.model.CarPark
import com.aangles.cmestas.mquispeyn.feature_db.domain.model.User
import com.aangles.cmestas.mquispeyn.presentation.navigation.Destinations
import com.aangles.cmestas.mquispeyn.presentation.screens.parking.components.CarParkItem
import com.aangles.cmestas.mquispeyn.presentation.screens.users.HomeUserViewModel
import com.aangles.cmestas.mquispeyn.presentation.screens.users.UserEvent
import com.aangles.cmestas.mquispeyn.presentation.screens.users.components.UserItem
import com.aangles.cmestas.mquispeyn.ui.theme.Laboratorio05Theme


@Composable
fun SecondScreen( navController: NavController,
                 viewModel: HomeCarParkViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            HomeTopBar()
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {

            HomeFab(
                onFabClicked = { navController.navigate(Destinations.EditCarParkScreen.route) },
                )
        },
        content = { innerPadding ->
            HomeContent(
                modifier = Modifier.padding(innerPadding),
                onDeleteCarPark = { viewModel.onEvent(CarParkEvent.DeleteCarPark(it)) },
                onEditCarPark = {
                    navController.navigate(
                        route = Destinations.EditUserScreen.passId(it)
                    )
                },
                carParks = state.carParks
            )
        }
    )
}

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.carParks),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        backgroundColor = MaterialTheme.colors.surface
    )
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onDeleteCarPark: (carPark: CarPark) -> Unit,
    onEditCarPark: (id: Int?) -> Unit,
    carParks: List<CarPark> = emptyList()
) {
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = modifier
    ) {
        LazyColumn {
            items(carParks) { carPark ->
                CarParkItem(
                    carPark = carPark,
                    onEditCarPark = { onEditCarPark(carPark.id) },
                    onDeleteCarPark = { onDeleteCarPark(carPark) }
                )
            }
        }

    }
}

@Composable
fun HomeFab(
    modifier: Modifier = Modifier,
    onFabClicked: () -> Unit = {  }
) {
    FloatingActionButton(
        onClick = onFabClicked,
        modifier = modifier
            .height(52.dp)
            .widthIn(min = 52.dp),
        elevation = FloatingActionButtonDefaults.elevation(10.dp,10.dp),
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        Icon(imageVector = Icons.Outlined.Add, contentDescription = stringResource(id = R.string.add_carPark))
    }
}

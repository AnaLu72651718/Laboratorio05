package com.aangles.cmestas.mquispeyn.presentation.screens.users

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aangles.cmestas.mquispeyn.R
import com.aangles.cmestas.mquispeyn.feature_db.domain.model.User
import com.aangles.cmestas.mquispeyn.presentation.navigation.Destinations
import com.aangles.cmestas.mquispeyn.presentation.screens.users.components.UserItem
import com.aangles.cmestas.mquispeyn.ui.theme.Laboratorio05Theme


@Composable
fun FirstScreen( navController: NavController,
                 viewModel: HomeUserViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            HomeTopBar()
        },
        floatingActionButton = {
            HomeFab(
                onFabClicked = { navController.navigate(Destinations.EditUserScreen.route) }
            )
        },
        content = { innerPadding ->
            HomeContent(
                modifier = Modifier.padding(innerPadding),
                onDeleteUser = { viewModel.onEvent(UserEvent.DeleteUser(it)) },
                onEditUser = {
                    navController.navigate(
                        route = Destinations.EditUserScreen.passId(it)
                    )
                },
                users = state.users
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
                text = stringResource(id = R.string.users),
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
    onDeleteUser: (user: User) -> Unit,
    onEditUser: (id: Int?) -> Unit,
    users: List<User> = emptyList()
) {
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = modifier
    ) {
        LazyColumn {
            items(users) { user ->
                UserItem(
                    user = user,
                    onEditUser = { onEditUser(user.id) },
                    onDeleteUser = { onDeleteUser(user) }
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
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(imageVector = Icons.Outlined.Add, contentDescription = stringResource(id = R.string.add_user))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserContent() {
    Laboratorio05Theme(darkTheme = false) {
        HomeContent(onDeleteUser = {}, onEditUser = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserFab() {
    Laboratorio05Theme(darkTheme = false) {
        HomeFab()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserTopBar() {
    Laboratorio05Theme(darkTheme = false) {
        HomeTopBar()
    }
}


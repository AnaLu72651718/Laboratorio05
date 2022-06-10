package com.aangles.cmestas.mquispeyn.presentation.screens.users.edit

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aangles.cmestas.mquispeyn.R
import com.aangles.cmestas.mquispeyn.presentation.screens.users.edit.components.UserInputText
import com.aangles.cmestas.mquispeyn.ui.theme.Laboratorio05Theme
import kotlinx.coroutines.flow.collectLatest

@Composable
fun EditUserScreen(
    navController: NavController,
    viewModel: EditViewModel = hiltViewModel()
) {
    val nameState = viewModel.userName.value
    val lastNameState = viewModel.userLastName.value
    val phoneState = viewModel.userPhone.value
    val ageState = viewModel.userAge.value

    val id = viewModel.currentUserId

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is EditViewModel.UiEvent.SaveUser -> {
                    navController.navigateUp()
                }
            }
        }
    }

    Scaffold(
        topBar = {
            if(id!=null){
                EditTopBar(
                    topAppBarText = stringResource(id = R.string.modifier_user)
                )
            }
            else{
                EditTopBar(
                    topAppBarText = stringResource(id = R.string.add_user)
                )
            }
        },
        content = {
            EditContent(
                name = nameState.text,
                lastName = lastNameState.text,
                phone = phoneState.text,
                age = ageState.text,
                onEvent = { viewModel.onEvent(it) }
            )
        },
        bottomBar = {
            if (id != null) {
                EditBottomBar(
                    id,
                    onInsertUser = { viewModel.onEvent(EditEvent.InsertUser) }
                )
            }else{
                EditBottomBar(
                    -1,
                    onInsertUser = { viewModel.onEvent(EditEvent.InsertUser) }
                )
            }
        }
    )
}

@Composable
fun EditTopBar(topAppBarText: String) {
    TopAppBar(
        title = {
            Text(
                text = topAppBarText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        backgroundColor = MaterialTheme.colors.surface
    )
}

@Composable
fun EditContent(
    name: String,
    lastName: String,
    phone: String,
    age: String,
    onEvent: (EditEvent) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(44.dp))
        UserInputText(
            text = name,
            hint = stringResource(id = R.string.name),
            onTextChange = { onEvent(EditEvent.EnteredName(it)) }
        )
        UserInputText(
            text = lastName,
            hint = stringResource(id = R.string.last_name),
            onTextChange = { onEvent(EditEvent.EnteredLastName(it)) }
        )
        UserInputText(
            text = phone,
            hint = stringResource(id = R.string.phone),
            onTextChange = { onEvent(EditEvent.EnteredPhone(it)) }
        )
        UserInputText(
            text = age,
            hint = stringResource(id = R.string.age),
            onTextChange = { onEvent(EditEvent.EnteredAge(it)) }
        )
    }
}

@Composable
fun EditBottomBar(
    text: Int,
    modifier: Modifier = Modifier,
    onInsertUser: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp, 10.dp, 10.dp, 100.dp),
        onClick = { onInsertUser() }
    ) {
        if(text == -1)
            Text(text = stringResource(id = R.string.add_user))
        else
            Text(text = stringResource(id = R.string.modifier_user))
    }
}

@Preview
@Composable
fun PreviewAddEditUserTopBar() {
    Laboratorio05Theme(){
        EditTopBar(
            topAppBarText = stringResource(id = R.string.add_user)
        )
    }
}

@Preview
@Composable
fun PreviewAddEditUserContent() {
    Laboratorio05Theme() {
        EditContent(
            name = "Ada",
            lastName = "Smith",
            phone = "Smith",
            age = "20",
            onEvent = { }
        )
    }
}


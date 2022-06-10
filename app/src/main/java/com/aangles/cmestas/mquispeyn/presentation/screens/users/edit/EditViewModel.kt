package com.aangles.cmestas.mquispeyn.presentation.screens.users.edit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aangles.cmestas.mquispeyn.feature_db.domain.model.User
import com.aangles.cmestas.mquispeyn.feature_db.domain.uses_cases.GetUser
import com.aangles.cmestas.mquispeyn.feature_db.domain.uses_cases.InsertUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val getUser: GetUser,
    private val insertUser: InsertUser,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _userName = mutableStateOf(TextFieldState())
    val userName: State<TextFieldState> = _userName

    private val _userLastName = mutableStateOf(TextFieldState())
    val userLastName: State<TextFieldState> = _userLastName

    private val _userPhone = mutableStateOf(TextFieldState())
    val userPhone: State<TextFieldState> = _userPhone

    private val _userAge = mutableStateOf(TextFieldState())
    val userAge: State<TextFieldState> = _userAge

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    var currentUserId: Int? = null

    init {
        savedStateHandle.get<Int>("userId")?.let { userId ->
            if (userId != -1) {
                viewModelScope.launch {
                    getUser(userId)?.also { user ->
                        currentUserId = user.id
                        _userName.value = userName.value.copy(
                            text = user.name
                        )
                        _userLastName.value = userLastName.value.copy(
                            text = user.lastName
                        )
                        _userPhone.value = userPhone.value.copy(
                            text = user.age.toString()
                        )
                        _userAge.value = userAge.value.copy(
                            text = user.age.toString()
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: EditEvent) {
       when (event) {
           is EditEvent.EnteredName -> {
               _userName.value = userName.value.copy(
                   text = event.value
               )
           }
           is EditEvent.EnteredLastName -> {
               _userLastName.value = userLastName.value.copy(
                   text = event.value
               )
           }
           is EditEvent.EnteredPhone -> {
               _userPhone.value = userPhone.value.copy(
                   text = event.value
               )
           }
           is EditEvent.EnteredAge -> {
               _userAge.value = userAge.value.copy(
                   text = event.value
               )
           }
           EditEvent.InsertUser -> {
               viewModelScope.launch {
                   insertUser(
                       User(
                           name = userName.value.text,
                           lastName = userLastName.value.text,
                           phone = userPhone.value.text,
                           age = userAge.value.text,
                           id = currentUserId
                       )
                   )
                   _eventFlow.emit(UiEvent.SaveUser)
               }
           }
       }
    }

    sealed class UiEvent {
        object SaveUser: UiEvent()
    }
}
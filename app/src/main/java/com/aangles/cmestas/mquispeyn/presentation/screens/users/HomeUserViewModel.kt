package com.aangles.cmestas.mquispeyn.presentation.screens.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aangles.cmestas.mquispeyn.feature_db.domain.uses_cases.DeleteUser
import com.aangles.cmestas.mquispeyn.feature_db.domain.uses_cases.GetUsers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeUserViewModel @Inject constructor(
    private val deleteUser: DeleteUser,
    getUsers: GetUsers
): ViewModel() {

    private val _state = mutableStateOf(UserListState())
    val state: State<UserListState> = _state

    init {
        getUsers().onEach { users ->
            _state.value = state.value.copy(
                users = users
            )
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: UserEvent) {
        when (event) {
            is UserEvent.DeleteUser -> {
                viewModelScope.launch {
                    deleteUser(event.user)
                }
            }
        }
    }
}
package com.aangles.cmestas.mquispeyn.presentation.screens.users

import com.aangles.cmestas.mquispeyn.feature_db.domain.model.User

data class UserListState(
    val users: List<User> = emptyList()
)

package com.aangles.cmestas.mquispeyn.presentation.screens.users

import com.aangles.cmestas.mquispeyn.feature_db.domain.model.User

sealed class UserEvent {
    data class DeleteUser(val user: User): UserEvent()
}

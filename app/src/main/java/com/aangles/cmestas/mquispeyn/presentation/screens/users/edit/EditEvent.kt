package com.aangles.cmestas.mquispeyn.presentation.screens.users.edit

sealed class EditEvent {
    data class EnteredName(val value: String): EditEvent()
    data class EnteredLastName(val value: String): EditEvent()
    data class EnteredPhone(val value: String): EditEvent()
    data class EnteredAge(val value: String): EditEvent()
    object InsertUser: EditEvent()
}
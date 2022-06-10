package com.aangles.cmestas.mquispeyn.presentation.screens.parking.edit

sealed class Edit2Event {
    data class EnteredName(val value: String): Edit2Event()
    data class EnteredAddress(val value: String): Edit2Event()
    data class EnteredLat(val value: String): Edit2Event()
    data class EnteredLon(val value: String): Edit2Event()
    data class EnteredDateC(val value: String): Edit2Event()
    data class EnteredDateO(val value: String): Edit2Event()
    object InsertCarPark: Edit2Event()
}

package com.aangles.cmestas.mquispeyn.presentation.screens.parking

import com.aangles.cmestas.mquispeyn.feature_db.domain.model.CarPark

sealed class CarParkEvent {
    data class DeleteCarPark(val carPark: CarPark): CarParkEvent()
}

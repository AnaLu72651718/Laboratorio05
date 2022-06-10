package com.aangles.cmestas.mquispeyn.presentation.screens.parking

import com.aangles.cmestas.mquispeyn.feature_db.domain.model.CarPark

data class CarParkListState(
    val carParks: List<CarPark> = emptyList()
)

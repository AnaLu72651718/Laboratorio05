package com.aangles.cmestas.mquispeyn.feature_db.domain.uses_cases

import com.aangles.cmestas.mquispeyn.feature_db.domain.model.CarPark
import com.aangles.cmestas.mquispeyn.feature_db.domain.repository.CarParkRepository
import javax.inject.Inject

class DeleteCarPark @Inject constructor(
    private val repository: CarParkRepository
) {
    suspend operator fun invoke(carpark: CarPark) {
        repository.deleteCarPark(carpark)
    }
}
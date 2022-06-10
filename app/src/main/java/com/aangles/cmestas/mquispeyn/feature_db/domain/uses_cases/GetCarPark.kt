package com.aangles.cmestas.mquispeyn.feature_db.domain.uses_cases

import com.aangles.cmestas.mquispeyn.feature_db.domain.model.CarPark
import com.aangles.cmestas.mquispeyn.feature_db.domain.repository.CarParkRepository
import javax.inject.Inject

class GetCarPark @Inject constructor(
    private val repository: CarParkRepository
) {
    suspend operator fun invoke(id: Int): CarPark? {
        return repository.getCarParkById(id)
    }
}
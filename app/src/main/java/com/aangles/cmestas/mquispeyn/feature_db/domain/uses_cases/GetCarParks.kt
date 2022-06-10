package com.aangles.cmestas.mquispeyn.feature_db.domain.uses_cases

import com.aangles.cmestas.mquispeyn.feature_db.domain.model.CarPark
import com.aangles.cmestas.mquispeyn.feature_db.domain.repository.CarParkRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCarParks @Inject constructor(
    private val repository: CarParkRepository
) {
    operator fun invoke(): Flow<List<CarPark>> {
        return repository.getCarParks()
    }
}
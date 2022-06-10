package com.aangles.cmestas.mquispeyn.feature_db.domain.repository

import com.aangles.cmestas.mquispeyn.feature_db.domain.model.CarPark
import kotlinx.coroutines.flow.Flow

interface CarParkRepository {
    fun getCarParks(): Flow<List<CarPark>>

    suspend fun getCarParkById(id: Int): CarPark?

    suspend fun insertCarPark(carPark: CarPark)

    suspend fun deleteCarPark(carPark: CarPark)
}
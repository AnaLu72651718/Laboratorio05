package com.aangles.cmestas.mquispeyn.feature_db.data.repository

import com.aangles.cmestas.mquispeyn.feature_db.data.local.dao.CarParkDao
import com.aangles.cmestas.mquispeyn.feature_db.data.local.dao.UserDao
import com.aangles.cmestas.mquispeyn.feature_db.domain.model.CarPark
import com.aangles.cmestas.mquispeyn.feature_db.domain.model.User
import com.aangles.cmestas.mquispeyn.feature_db.domain.repository.CarParkRepository
import com.aangles.cmestas.mquispeyn.feature_db.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CarParkRepositoryImpl @Inject constructor(
    private val dao: CarParkDao
): CarParkRepository {
    override fun getCarParks(): Flow<List<CarPark>> {
        return dao.getCarParks()
    }

    override suspend fun getCarParkById(id: Int): CarPark? {
        return dao.getCarParkById(id)
    }

    override suspend fun insertCarPark(carPark: CarPark) {
        dao.insertCarPark(carPark)
    }

    override suspend fun deleteCarPark(carPark: CarPark) {
        dao.deleteCarPark(carPark)
    }
}
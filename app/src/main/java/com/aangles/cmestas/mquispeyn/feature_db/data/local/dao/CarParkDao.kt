package com.aangles.cmestas.mquispeyn.feature_db.data.local.dao

import androidx.room.*
import com.aangles.cmestas.mquispeyn.feature_db.domain.model.CarPark
import kotlinx.coroutines.flow.Flow

@Dao
interface CarParkDao {
    @Query("SELECT * FROM CarPark")
    fun getCarParks(): Flow<List<CarPark>>

    @Query("SELECT * FROM CarPark WHERE id = :id")
    suspend fun getCarParkById(id: Int): CarPark?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCarPark(carPark: CarPark)

    @Delete
    suspend fun deleteCarPark(carPark: CarPark)
}
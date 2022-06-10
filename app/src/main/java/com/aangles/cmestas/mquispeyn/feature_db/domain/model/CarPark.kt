package com.aangles.cmestas.mquispeyn.feature_db.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CarPark(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val name: String,
    val address: String,
    val lat: String,
    val lon: String,
    val dateC: String,
    val dateO: String
)
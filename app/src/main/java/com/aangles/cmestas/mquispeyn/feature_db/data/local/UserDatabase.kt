package com.aangles.cmestas.mquispeyn.feature_db.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aangles.cmestas.mquispeyn.feature_db.data.local.dao.CarParkDao
import com.aangles.cmestas.mquispeyn.feature_db.data.local.dao.UserDao
import com.aangles.cmestas.mquispeyn.feature_db.domain.model.CarPark
import com.aangles.cmestas.mquispeyn.feature_db.domain.model.User

/*
@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)

abstract class UserDatabase: RoomDatabase() {
    abstract fun carParkDao(): CarParkDao
    abstract fun userDao(): UserDao
}
*/
/*
@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)

abstract class UserDatabase: RoomDatabase() {
    abstract val userDao: UserDao
}
* */
package com.aangles.cmestas.mquispeyn.di


import android.app.Application
import androidx.room.Room
//import com.aangles.cmestas.mquispeyn.feature_db.data.local.CarParkbase
import com.aangles.cmestas.mquispeyn.feature_db.data.local.DataBase
//import com.aangles.cmestas.mquispeyn.feature_db.data.local.CarParkbase
import com.aangles.cmestas.mquispeyn.feature_db.data.repository.UserRepositoryImpl
//import com.aangles.cmestas.mquispeyn.feature_db.data.local.UserDatabase
import com.aangles.cmestas.mquispeyn.feature_db.data.repository.CarParkRepositoryImpl
import com.aangles.cmestas.mquispeyn.feature_db.domain.repository.CarParkRepository
import com.aangles.cmestas.mquispeyn.feature_db.domain.repository.UserRepository
import com.aangles.cmestas.mquispeyn.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserDatabase(app: Application) = Room.databaseBuilder(
        app,
        DataBase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideRepository(db: DataBase): UserRepository {
        return UserRepositoryImpl(db.userDao())
    }

    @Provides
    @Singleton
    fun provideRepository2(db: DataBase): CarParkRepository {
        return CarParkRepositoryImpl(db.carParkDao())
    }


}
/*
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserDatabase(app: Application) = Room.databaseBuilder(
        app,
        UserDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideCarParkDatabase(app: Application) = Room.databaseBuilder(
        app,
        CarParkbase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideRepository(db: UserDatabase): UserRepository {
        return UserRepositoryImpl(db.userDao)
    }

    @Provides
    @Singleton
    fun provideRepository2(db: CarParkbase): CarParkRepository {
        return CarParkRepositoryImpl(db.carParkDao)
    }


}

*/
package com.konstantink.intlcard.data.databases

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.konstantink.intlcard.data.converters.CardConverter
import com.konstantink.intlcard.data.dao.CardDao
import com.konstantink.intlcard.data.dao.CardSetDao
import com.konstantink.intlcard.data.dbModels.CardDbModel
import com.konstantink.intlcard.data.dbModels.CardSetDbModel

@Database(entities = [CardDbModel::class, CardSetDbModel::class], version = 1, exportSchema = false)
@TypeConverters(CardConverter::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun cardDao(): CardDao
    abstract fun cardSetDao(): CardSetDao

    companion object {

        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "card.db"

        fun getInstance(application: Application): AppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration().build()
                INSTANCE = db
                return db
            }
        }
    }

}
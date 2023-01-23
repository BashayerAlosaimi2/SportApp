package com.example.pifsportapp.RoomData

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import com.example.pifsportapp.data.MatchCreatedData

@Database(entities = [MatchCreatedData::class], version = 1, exportSchema = false)
abstract class MatchDatabase : RoomDatabase() {

    abstract fun matchDau(): MatchDao

    companion object {
        @Volatile
        private var INSTANCE: MatchDatabase? = null
        fun getAppDataBase(context: Context): MatchDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext, MatchDatabase::class.java, "Match-database"
                ).build()

            }
            return INSTANCE
        }
    }

}

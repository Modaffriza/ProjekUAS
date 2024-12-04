package com.example.projekuas

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CalonDPR::class], version = 1, exportSchema = false)
abstract class CalonDPRDatabase : RoomDatabase() {

    abstract fun calonDPRDao(): CalonDPRDao

    companion object {
        @Volatile
        private var INSTANCE: CalonDPRDatabase? = null

        fun getDatabase(context: Context): CalonDPRDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CalonDPRDatabase::class.java,
                    "calon_dpr_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

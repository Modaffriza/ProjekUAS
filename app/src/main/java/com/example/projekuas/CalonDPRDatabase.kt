package com.example.projekuas

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [CalonDPR::class, Favorite::class], version = 3, exportSchema = false)
abstract class CalonDPRDatabase : RoomDatabase() {

    abstract fun calonDPRDao(): CalonDPRDao

    companion object {
        @Volatile
        private var INSTANCE: CalonDPRDatabase? = null

        fun getDatabase(context: Context): CalonDPRDatabase? {
            if (INSTANCE == null){
                synchronized(CalonDPRDatabase::class.java){
                    INSTANCE = databaseBuilder(
                        context.applicationContext,
                        CalonDPRDatabase::class.java, "calon_dpr_db"
                    )
                        .build()
                }
            }
            return INSTANCE
        }
    }
}

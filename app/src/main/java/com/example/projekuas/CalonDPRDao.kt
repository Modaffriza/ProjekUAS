package com.example.projekuas

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CalonDPRDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCalon(calon: CalonDPR)

    @Delete
    suspend fun deleteCalon(calon: CalonDPR)

    @Query("SELECT * FROM calon_dpr")
    fun getAllCalon(): LiveData<List<CalonDPR>>
}

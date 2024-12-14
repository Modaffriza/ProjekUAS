package com.example.projekuas

import androidx.lifecycle.LiveData
import androidx.room.*
import retrofit2.Call

@Dao
interface CalonDPRDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(favorite: Favorite)

    @Delete
    fun deleteFavorite(favorite: Favorite)
    //mengambil spesifik favorite calondpr
    @Query("SELECT * FROM favorite WHERE pid = :pid")
    fun getCalonDPR(pid:String):Favorite?

    // Mengembalikan daftar ID favorit
    @Query("SELECT * FROM favorite")
    fun getAllFavorites(): LiveData<List<Favorite>> // Suspend function, bukan LiveData

    // Mengambil data calon DPR berdasarkan ID favorit
    @Query("SELECT * FROM calon_dpr WHERE id IN (:favIds)")
    fun getFavoriteCalons(favIds: List<String>): List<CalonDPR>
}

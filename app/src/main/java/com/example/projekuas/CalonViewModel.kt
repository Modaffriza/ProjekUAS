package com.example.projekuas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

class CalonViewModel(application: Application) : AndroidViewModel(application) {
    val service = Executors.newSingleThreadExecutor()

    private val db = CalonDPRDatabase.getDatabase(application)
    private val _favoriteCalons = MutableLiveData<List<CalonDPR>>()
    val favoriteCalons: LiveData<List<CalonDPR>> = _favoriteCalons

    init {
//        loadFavoriteCalons()
    }

//    private fun loadFavoriteCalons() {
//        viewModelScope.launch {
//            // Ambil semua ID favorit
//            val favorites = db.calonDPRDao().getAllFavorites()
//            val favoriteIds = favorites.map { it._id } // Ambil daftar ID
//            val calonDetails = db.calonDPRDao().getFavoriteCalons(favoriteIds)
//            _favoriteCalons.postValue(calonDetails) // Update LiveData dengan detail
//        }
//    }
//
//    suspend fun addFavorite(calon: CalonDPR) {
//        service.execute {
//            db.calonDPRDao().insertFavorite(Favorite(_id = calon._id))
//        }
//        loadFavoriteCalons() // Refresh data setelah ditambahkan
//    }
//
//    suspend fun removeFavorite(calon: CalonDPR) {
//        service.execute {db.calonDPRDao().deleteFavorite(Favorite(id=calon.id, _id = calon._id))
//        }
//        loadFavoriteCalons() // Refresh data setelah dihapus
//    }
//
//    suspend fun isFavorite(calon: CalonDPR): Boolean {
//        val favorites = db.calonDPRDao().getAllFavorites()
//        return favorites.any { it._id == calon._id }
//    }
}

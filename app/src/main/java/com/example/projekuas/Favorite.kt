package com.example.projekuas

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favorite")
data class Favorite(

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("_id")
    val pid: String,

    @SerializedName("nama")
    val nama: String,

    @SerializedName("partai")
    val partai: String,

    @SerializedName("fotoUrl")
    val fotoUrl: String
)

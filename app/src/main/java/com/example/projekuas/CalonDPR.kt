package com.example.projekuas

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calon_dpr")
data class CalonDPR(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama: String,
    val partai: String,
    val fotoUrl: String

//    simpen key aja jangan ada attribute. Attribute lain bisa diambil menggunakan apui
)

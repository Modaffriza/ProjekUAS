package com.example.projekuas

import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("uasmobile")
    suspend fun getAllCalon(): Response<List<CalonDPR>>

    @POST("uasmobile")
    suspend fun addCalon(@Body calon: CalonDPR): Response<CalonDPR>

    @DELETE("uasmobile/{id}")
    suspend fun deleteCalon(@Path("id") id: Int): Response<Unit>
}

package com.example.projekuas

import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("YMBmm/uasmobile")
    suspend fun getAllCalon(): Response<List<CalonDPR>>

    @POST("YMBmm/uasmobile")
    suspend fun addCalon(@Body calon: CalonDPR): Response<CalonDPR>

    @DELETE("YMBmm/uasmobile/{id}")
    suspend fun deleteCalon(@Path("id") id: Int): Response<Unit>
}

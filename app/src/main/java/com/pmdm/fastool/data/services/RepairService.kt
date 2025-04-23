package com.pmdm.fastool.data.services

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface RepairService {
    @GET("reparaciones")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun getReparaciones(): Response<List<ReparacionApi>>
}
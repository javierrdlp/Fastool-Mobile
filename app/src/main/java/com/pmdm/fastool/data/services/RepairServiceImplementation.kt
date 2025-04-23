package com.pmdm.fastool.data.services

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepairServiceImplementation @Inject constructor(
    private  val repairService: RepairService
) {
    private val logTag: String = "OkHttp"

    suspend fun get(): List<ReparacionApi>{
        val mensajeError = "No se han podido obtener las reparaciones"
        try{
            val response = repairService.getReparaciones()
            if (response.isSuccessful){
                Log.d(logTag, response.toString())
                val dato = response.body()
                return dato ?: throw ApiServicesException("No hay datos")

            }else{
                val body = response.errorBody()?.string()
                Log.e(logTag, "$mensajeError (código ${response.code()}): $this\n${body}")
                throw ApiServicesException("$mensajeError - Código ${response.code()}")
            }
        } catch (e: Exception) {
            Log.e(logTag, "Error: ${e.localizedMessage}")
            throw ApiServicesException(mensajeError)
        }
    }
}
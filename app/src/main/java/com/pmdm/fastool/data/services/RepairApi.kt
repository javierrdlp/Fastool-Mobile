package com.pmdm.fastool.data.services

import java.time.ZonedDateTime

data class ReparacionApi(
    val id: Int,
    val descripcion: String,
    val horaInicio: ZonedDateTime,
    val horaFin: ZonedDateTime?,
    val matricula: MatriculaApi
)

data class MatriculaApi(
    val id: Int,
    val matricula: String,
    val marca: String,
    val modelo: String,
    val clienteId: ClienteApi
)

data class ClienteApi(
    val id: Int,
    val nombre: String,
    val email: String,
    val cif: String,
    val password: String?
)
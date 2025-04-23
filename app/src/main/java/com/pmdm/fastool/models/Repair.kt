package com.pmdm.fastool.models

import java.time.ZonedDateTime

data class Repair(
    val id: Int,
    val descripcion: String,
    val horaInicio: ZonedDateTime,
    val horaFin: ZonedDateTime?,
    val matricula: Matricula
)

data class Matricula(
    val id: Int,
    val matricula: String,
    val marca: String,
    val modelo: String,
    val clienteId: Cliente
)

data class Cliente(
    val id: Int,
    val nombre: String,
    val email: String,
    val cif: String,
    val password: String?
)


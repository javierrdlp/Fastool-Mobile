package com.pmdm.fastool.models

data class Repair(
    val id: Int,
    val matricula: String,
    val descripcion: String,
    val horaInicio: java.text.SimpleDateFormat,
    val horaFin: java.text.SimpleDateFormat?
)
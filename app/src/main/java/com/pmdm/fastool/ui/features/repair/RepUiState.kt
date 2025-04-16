package com.pmdm.fastool.ui.features.repair

data class RepUiState(
    val id: Int,
    val matricula: String,
    val descripcion: String,
    val horaInicio: java.text.SimpleDateFormat,
    val horaFin: java.text.SimpleDateFormat?
)
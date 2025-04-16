package com.pmdm.fastool.data.mocks

import java.text.SimpleDateFormat

data class RepairMock(
    val id: Int,
    val matricula: String,
    val descripcion: String,
    val horaInicio: SimpleDateFormat,
    val horaFin: SimpleDateFormat?
)
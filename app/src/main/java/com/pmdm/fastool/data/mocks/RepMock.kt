package com.pmdm.fastool.data.mocks

import java.text.SimpleDateFormat

data class RepMock(
    val id: Int,
    val matricula: String,
    val descripcion: String,
    val horaInicio: SimpleDateFormat,
    val horaFin: SimpleDateFormat?
)
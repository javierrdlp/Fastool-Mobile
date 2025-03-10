package com.pmdm.fastool.data.mocks

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

class RepDaoMock {
    @SuppressLint("SimpleDateFormat")
    private var reparaciones = mutableListOf<RepMock>(
        RepMock(
            id = 1,
            matricula = "1234ABC",
            descripcion = "Cambiar aceite y filtros",
            horaInicio = SimpleDateFormat("18/02/2025 10:30"),
            horaFin = SimpleDateFormat("19/02/2025 10:30")
        ),
        RepMock(
            id = 2,
            matricula = "1234ABC",
            descripcion = "Cambiar aceite y filtros2",
            horaInicio = SimpleDateFormat("18/02/2025 11:30"),
            horaFin = null
        ),
        RepMock(
            id = 3,
            matricula = "1234ABC",
            descripcion = "Cambiar aceite y filtros3",
            horaInicio = SimpleDateFormat("19/02/2025 10:30"),
            horaFin = SimpleDateFormat("20/02/2025 10:30")
        ),
        RepMock(
            id = 4,
            matricula = "5678ABC",
            descripcion = "Cambiar aceite y filtros4",
            horaInicio = SimpleDateFormat("18/02/2025 10:30"),
            horaFin = SimpleDateFormat("19/02/2025 10:30")
        ),
        RepMock(
            id = 5,
            matricula = "5678ABC",
            descripcion = "Cambiar aceite y filtros5",
            horaInicio = SimpleDateFormat("18/02/2025 10:30"),
            horaFin = SimpleDateFormat("19/02/2025 10:30")
        ),
        RepMock(
            id = 6,
            matricula = "1111AAA",
            descripcion = "Cambiar aceite y filtros6",
            horaInicio = SimpleDateFormat("18/02/2025 10:30"),
            horaFin = SimpleDateFormat("19/02/2025 10:30")
        )
    )

    fun get(): MutableList<RepMock> = reparaciones
    fun get(id: Int): RepMock? = reparaciones.find { r -> r.id == id}
    fun get(matricula: String): MutableList<RepMock> = reparaciones.filter {r -> r.matricula == matricula}.toMutableList()

}
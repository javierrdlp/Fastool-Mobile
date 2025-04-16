package com.pmdm.fastool.data.mocks

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

class RepairDaoMock {
    @SuppressLint("SimpleDateFormat")
    private var reparaciones = mutableListOf<RepairMock>(
        RepairMock(
            id = 1,
            matricula = "1234ABC",
            descripcion = "Cambiar aceite y filtros",
            horaInicio = SimpleDateFormat("18/02/2025 09:30"),
            horaFin = SimpleDateFormat("18/02/2025 10:30")
        ),
        RepairMock(
            id = 2,
            matricula = "1234CBA",
            descripcion = "Cambiar aceite y filtros2",
            horaInicio = SimpleDateFormat("18/02/2025 10:30"),
            horaFin = null
        ),
        RepairMock(
            id = 3,
            matricula = "4321ABC",
            descripcion = "Cambiar aceite y filtros3",
            horaInicio = SimpleDateFormat("19/02/2025 11:30"),
            horaFin = null
        ),
        RepairMock(
            id = 4,
            matricula = "5678ABC",
            descripcion = "Cambiar aceite y filtros4",
            horaInicio = SimpleDateFormat("19/02/2025 10:35"),
            horaFin = SimpleDateFormat("19/02/2025 12:30")
        ),
        RepairMock(
            id = 5,
            matricula = "5678CBA",
            descripcion = "Cambiar aceite y filtros5",
            horaInicio = SimpleDateFormat("19/02/2025 10:30"),
            horaFin = SimpleDateFormat("19/02/2025 13:30")
        ),
        RepairMock(
            id = 6,
            matricula = "1111AAA",
            descripcion = "Cambiar aceite y filtros6",
            horaInicio = SimpleDateFormat("20/02/2025 10:20"),
            horaFin = null
        ),
        RepairMock(
            id = 7,
            matricula = "1234ABC",
            descripcion = "Cambiar aceite y filtros",
            horaInicio = SimpleDateFormat("20/02/2025 10:40"),
            horaFin = SimpleDateFormat("20/02/2025 11:30")
        ),
        RepairMock(
            id = 8,
            matricula = "1234CBA",
            descripcion = "Cambiar aceite y filtros2",
            horaInicio = SimpleDateFormat("20/02/2025 11:30"),
            horaFin = null
        ),
        RepairMock(
            id = 9,
            matricula = "4321ABC",
            descripcion = "Cambiar aceite y filtros3",
            horaInicio = SimpleDateFormat("21/02/2025 08:30"),
            horaFin = SimpleDateFormat("21/02/2025 09:30")
        ),
        RepairMock(
            id = 10,
            matricula = "5678ABC",
            descripcion = "Cambiar aceite y filtros4",
            horaInicio = SimpleDateFormat("21/02/2025 10:15"),
            horaFin = SimpleDateFormat("21/02/2025 10:45")
        ),
        RepairMock(
            id = 11,
            matricula = "5678CBA",
            descripcion = "Cambiar aceite y filtros5",
            horaInicio = SimpleDateFormat("21/02/2025 10:30"),
            horaFin = null
        ),
        RepairMock(
            id = 12,
            matricula = "1111AAA",
            descripcion = "Cambiar aceite y filtros6",
            horaInicio = SimpleDateFormat("21/02/2025 12:30"),
            horaFin = SimpleDateFormat("21/02/2025 13:45")
        )
    )

    fun get(): MutableList<RepairMock> = reparaciones
    fun get(id: Int): RepairMock? = reparaciones.find { r -> r.id == id}
    fun get(matricula: String): MutableList<RepairMock> = reparaciones.filter { r -> r.matricula == matricula}.toMutableList()

}
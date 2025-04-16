package com.pmdm.fastool.data

import com.pmdm.fastool.data.mocks.RepairMock
import com.pmdm.fastool.models.Repair
import com.pmdm.fastool.ui.features.repair.RepUiState

fun RepairMock.toRep(): Repair = Repair(
   this.id,
    this.matricula,
    this.descripcion,
    this.horaInicio,
    this.horaFin
)

fun Repair.toRepMock(): RepairMock = RepairMock(
    this.id,
    this.matricula,
    this.descripcion,
    this.horaInicio,
    this.horaFin
)

fun Repair.toRepUiState(): RepUiState = RepUiState(
    this.id,
    this.matricula,
    this.descripcion,
    this.horaInicio,
    this.horaFin
)

fun RepUiState.toRep(): Repair = Repair(
    this.id,
    this.matricula,
    this.descripcion,
    this.horaInicio,
    this.horaFin
)

fun MutableList<RepairMock>.toRep() = this.map {it.toRep()}.toMutableList()
fun MutableList<Repair>.toReoUiState() = this.map { it.toRepUiState() }.toMutableList()

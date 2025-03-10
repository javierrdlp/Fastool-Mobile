package com.pmdm.fastool.data

import com.pmdm.fastool.data.mocks.RepMock
import com.pmdm.fastool.models.Rep
import com.pmdm.fastool.ui.features.reps.RepUiState

fun RepMock.toRep(): Rep = Rep(
   this.id,
    this.matricula,
    this.descripcion,
    this.horaInicio,
    this.horaFin
)

fun Rep.toRepMock(): RepMock = RepMock(
    this.id,
    this.matricula,
    this.descripcion,
    this.horaInicio,
    this.horaFin
)

fun Rep.toRepUiState(): RepUiState = RepUiState(
    this.id,
    this.matricula,
    this.descripcion,
    this.horaInicio,
    this.horaFin
)

fun RepUiState.toRep(): Rep = Rep(
    this.id,
    this.matricula,
    this.descripcion,
    this.horaInicio,
    this.horaFin
)

fun MutableList<RepMock>.toRep() = this.map {it.toRep()}.toMutableList()
fun MutableList<Rep>.toReoUiState() = this.map { it.toRepUiState() }.toMutableList()

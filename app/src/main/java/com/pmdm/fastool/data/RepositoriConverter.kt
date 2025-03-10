package com.pmdm.fastool.data

import com.pmdm.fastool.data.mocks.RepMock
import com.pmdm.fastool.models.Rep

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
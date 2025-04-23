package com.pmdm.fastool.data

import com.pmdm.fastool.data.services.ClienteApi
import com.pmdm.fastool.data.services.MatriculaApi
import com.pmdm.fastool.data.services.ReparacionApi
import com.pmdm.fastool.models.Cliente
import com.pmdm.fastool.models.Matricula
import com.pmdm.fastool.models.Repair
import com.pmdm.fastool.ui.features.repair.ClienteUi
import com.pmdm.fastool.ui.features.repair.MatriculaUi
import com.pmdm.fastool.ui.features.repair.RepUiState

fun ReparacionApi.toRepair(): Repair = Repair(
    id = id,
    descripcion = descripcion,
    horaInicio = horaInicio,
    horaFin = horaFin,
    matricula = matricula.toMatricula()
)

fun MatriculaApi.toMatricula(): Matricula = Matricula(
    id = id,
    matricula = matricula,
    marca = marca,
    modelo = modelo,
    clienteId = clienteId.toCliente()
)

fun ClienteApi.toCliente(): Cliente = Cliente(
    id = id,
    nombre = nombre,
    email = email,
    cif = cif,
    password = password
)

fun Repair.toRepUiState(): RepUiState = RepUiState(
    id = id,
    descripcion = descripcion,
    horaInicio = horaInicio,
    horaFin = horaFin,
    matricula = matricula.toMatriculaUi()
)

fun Matricula.toMatriculaUi(): MatriculaUi = MatriculaUi(
    id = id,
    matricula = matricula,
    marca = marca,
    modelo = modelo,
    clienteId = clienteId.toClienteUi()
)

fun Cliente.toClienteUi(): ClienteUi = ClienteUi(
    id = id,
    nombre = nombre,
    email = email,
    cif = cif,
    password = password
)

fun RepUiState.toRepair(): Repair = Repair(
    id = id,
    descripcion = descripcion,
    horaInicio = horaInicio,
    horaFin = horaFin,
    matricula = matricula.toMatricula()
)

fun MatriculaUi.toMatricula(): Matricula = Matricula(
    id = id,
    matricula = matricula,
    marca = marca,
    modelo = modelo,
    clienteId = clienteId.toCliente()
)

fun ClienteUi.toCliente(): Cliente = Cliente(
    id = id,
    nombre = nombre,
    email = email,
    cif = cif,
    password = password
)


fun MutableList<Repair>.toRepUiState() = this.map { it.toRepUiState() }.toMutableList()
fun MutableList<Repair>.toRepUiStateList(): MutableList<RepUiState> =
    this.map { it.toRepUiState() }.toMutableList()
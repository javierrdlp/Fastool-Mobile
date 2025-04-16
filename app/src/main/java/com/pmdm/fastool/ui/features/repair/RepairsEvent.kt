package com.pmdm.fastool.ui.features.repair

import com.pmdm.fastool.ui.features.repair.components.ScaffoldEvent

interface RepairsEvent {
    object OnClickFiltrar : RepairsEvent
    data class onBuscarChange(var matricula: String) : RepairsEvent
    data class OnClickBuscar(var busqueda: String) : RepairsEvent
}
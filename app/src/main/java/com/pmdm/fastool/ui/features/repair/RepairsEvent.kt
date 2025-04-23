package com.pmdm.fastool.ui.features.repair

interface RepairsEvent {
    object OnClickFiltrarRep : RepairsEvent
    object OnClickFiltrarDate : RepairsEvent
    data class OnBuscarChange(var matricula: String) : RepairsEvent
    data class OnClickBuscar(var busqueda: String) : RepairsEvent
}
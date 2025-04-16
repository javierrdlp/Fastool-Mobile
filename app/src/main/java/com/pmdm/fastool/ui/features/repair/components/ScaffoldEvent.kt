package com.pmdm.fastool.ui.features.repair.components

interface ScaffoldEvent {
    object CloseSession : ScaffoldEvent
    object ExitApplication : ScaffoldEvent
}
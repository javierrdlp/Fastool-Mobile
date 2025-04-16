package com.pmdm.fastool.ui.features.repair

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pmdm.fastool.data.RepairRepository
import com.pmdm.fastool.data.toReoUiState
import com.pmdm.fastool.ui.features.repair.components.ScaffoldEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RepairViewModel @Inject constructor(private val repository: RepairRepository) : ViewModel() {

    // Este será tu listado observable por Compose
    var repState = mutableStateListOf<RepUiState>()
        private set

    var filterState by mutableStateOf(false)
        private set

    var snackBarTextState by mutableStateOf("")
        private set
    var matriculaBuscar by mutableStateOf("")

    init {
        loadRepairs()
    }

    private fun loadRepairs() {
        repState.clear()
        repState.addAll(repository.get().toReoUiState())
    }

    fun onRepairsEvent(repairsEvent: RepairsEvent) {
        when (repairsEvent) {
            is RepairsEvent.OnClickFiltrar -> {

                if (!filterState) {
                    val sortedList = repState.sortedBy { it.horaFin != null }
                    repState.clear()
                    repState.addAll(sortedList)
                    filterState = true
                } else {
                    loadRepairs()
                    filterState = false
                }
            }
            is RepairsEvent.OnClickBuscar -> {
                println("buscando")
                val sortedList = repState.filter { it.matricula.contains(matriculaBuscar)  }
                repState.clear()
                repState.addAll(sortedList)
            }
            is RepairsEvent.onBuscarChange -> {
                if (repairsEvent.matricula.isEmpty()){
                    loadRepairs()
                    filterState = false
                }
                matriculaBuscar = repairsEvent.matricula
                println(matriculaBuscar)
            }
        }
    }


    fun onScaffoldEvent(scaffoldEvent: ScaffoldEvent) {
        when (scaffoldEvent) {
            is ScaffoldEvent.CloseSession -> {
                snackBarTextState = "Cerrando sesión."
            }

            is ScaffoldEvent.ExitApplication -> {
                snackBarTextState = "Saliendo de aplicación."
            }
        }
    }


}
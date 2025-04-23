package com.pmdm.fastool.ui.features.repair

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pmdm.fastool.data.RepairRepository
import com.pmdm.fastool.data.toRepUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepairViewModel @Inject constructor(private val repository: RepairRepository) : ViewModel() {

    var repState = mutableStateListOf<RepUiState>()
        private set

    var filterRepState by mutableStateOf(false)
        private set

    var filterDateState by mutableStateOf(false)
        private set

    var snackBarTextState by mutableStateOf("")
        private set
    var matriculaBuscar by mutableStateOf("")

    init {
        loadRepairs()
        println(repState)
    }

    private fun loadRepairs() {
        viewModelScope.launch {
            try {

                val repairs = repository.get()
                repState.clear()
                repState.addAll(repairs.map {
                    it.toRepUiState()
                })
            } catch (e: Exception) {
                // Manejo de error si algo falla en la llamada
                snackBarTextState = "Error al cargar reparaciones: ${e.localizedMessage}"
            }
        }
    }

    fun onRepairsEvent(repairsEvent: RepairsEvent) {
        when (repairsEvent) {
            is RepairsEvent.OnClickFiltrarRep -> {

                if (!filterRepState) {
                    val sortedList = repState.sortedBy { it.horaFin != null }
                    repState.clear()
                    repState.addAll(sortedList)
                    filterRepState = true
                    filterDateState = false
                } else {
                    loadRepairs()
                    filterRepState = false

                }
            }
            is RepairsEvent.OnClickFiltrarDate -> {

                if (!filterDateState) {
                    val sortedList = repState.sortedByDescending { it.horaInicio }

                    repState.clear()
                    repState.addAll(sortedList)
                    filterDateState = true
                    filterRepState = false
                } else {
                    loadRepairs()
                    filterDateState = false

                }
            }
            is RepairsEvent.OnClickBuscar -> {
                val sortedList = repState.filter { it.matricula.matricula.contains(matriculaBuscar)  }
                repState.clear()
                repState.addAll(sortedList)
            }
            is RepairsEvent.OnBuscarChange -> {
                if (repairsEvent.matricula.isEmpty()){
                    loadRepairs()
                    filterRepState = false
                }
                matriculaBuscar = repairsEvent.matricula.uppercase()
                println(matriculaBuscar)
            }

        }
    }

}
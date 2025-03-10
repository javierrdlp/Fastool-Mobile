package com.pmdm.fastool.ui.features.reps

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.pmdm.fastool.data.RepRepository
import com.pmdm.fastool.data.toReoUiState

class RepairViewModel():ViewModel() {
    private val repository: RepRepository = RepRepository()
    var repState by mutableStateOf(loadReparations())

    fun loadReparations() = repository.get().toReoUiState().toMutableStateList()
}
package com.pmdm.fastool.ui.features.repair.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pmdm.fastool.ui.features.repair.RepUiState
import com.pmdm.fastool.ui.features.repair.RepairViewModel
import com.pmdm.fastool.ui.theme.FasToolTheme

@Composable
fun RepairsList(
    modifier: Modifier = Modifier,
    listaReparaciones: List<RepUiState>
){
    Box(modifier = modifier.then(Modifier.fillMaxSize())){
        LazyColumn(
            contentPadding = PaddingValues(all = 4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        )
        {
            items(listaReparaciones.size) { repair ->
                RepairCard(repair = listaReparaciones[repair])
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepairsListPreview(){
    val repairViewModel: RepairViewModel = viewModel()
    FasToolTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            RepairsList(
                listaReparaciones = repairViewModel.repState,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
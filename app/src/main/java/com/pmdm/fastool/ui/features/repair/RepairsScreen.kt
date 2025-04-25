package com.pmdm.fastool.ui.features.repair

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pmdm.fastool.ui.theme.FasToolTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pmdm.fastool.ui.features.repair.components.RepairsList
import com.pmdm.fastool.ui.features.repair.components.SearchBar
import com.pmdm.fastool.ui.features.repair.components.SuperiorAppBar
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepairsScreen(
    modifier: Modifier = Modifier,
    listaReparaciones: List<RepUiState>,
    onRepairsEvent: (RepairsEvent) -> Unit,
    arrangeRepState: Boolean,
    arrangeDateState: Boolean
) {
    val comportamientoAnteScrollSup = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val context = LocalContext.current
    val activity = context as? Activity
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        modifier = modifier
            .nestedScroll(comportamientoAnteScrollSup.nestedScrollConnection)
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            SuperiorAppBar(
                onRepairsEvent = onRepairsEvent,
                comportamientoAnteScroll = comportamientoAnteScrollSup,
                onClickSalir = {activity?.finish()},
                arrangeDateState = arrangeDateState,
                arrangeRepState = arrangeRepState
            )
        },
        bottomBar = {
            SearchBar(
                onRepairsEvent = onRepairsEvent,
                onEmptySearch = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Introduce matrícula a buscar")
                    }
                }
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState) { snackbarData ->
                Snackbar(
                    containerColor = Color.Gray,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ){
                    Text(
                        text = snackbarData.visuals.message,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        },
        content = { innerPadding ->
           RepairsList(modifier = Modifier.padding(innerPadding),
               listaReparaciones = listaReparaciones )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TabScreenPreview() {
    FasToolTheme{
        val repairViewModel: RepairViewModel = viewModel()

        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            RepairsScreen(
                modifier = Modifier.padding(innerPadding),
                listaReparaciones = repairViewModel.repState,
                onRepairsEvent = repairViewModel::onRepairsEvent,
                arrangeRepState = repairViewModel.arrangeRepState,
                arrangeDateState = repairViewModel.arrangeDateState
            )
        }
    }
}
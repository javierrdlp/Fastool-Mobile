package com.pmdm.fastool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.pmdm.fastool.ui.features.repair.RepairViewModel
import com.pmdm.fastool.ui.features.repair.RepairsScreen
import com.pmdm.fastool.ui.features.splash.SplashScreen
import com.pmdm.fastool.ui.navigation.NavHostRepair
import com.pmdm.fastool.ui.theme.FasToolTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FasToolTheme {
                val repairViewModel: RepairViewModel = viewModel()
               Surface(modifier = Modifier.fillMaxSize()) {
                   val navController = rememberNavController()
                       NavHostRepair(navController = navController)
                    /*
                    RepairsScreen(
                        modifier = Modifier.padding(innerPadding),
                        listaReparaciones = repairViewModel.repState,
                        scaffoldEvent = repairViewModel::onScaffoldEvent,
                        onRepairsEvent = repairViewModel::onRepairsEvent
                    )
                    */
                }
            }
        }
    }
}
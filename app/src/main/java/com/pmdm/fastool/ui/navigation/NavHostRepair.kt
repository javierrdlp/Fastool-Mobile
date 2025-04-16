package com.pmdm.fastool.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.pmdm.fastool.ui.features.repair.RepairViewModel


@Composable
fun NavHostRepair(
    navController : NavHostController
){
    val repairViewModel = hiltViewModel<RepairViewModel>()
    NavHost(
        navController = navController,
        startDestination = SplashRoute
    ){
       splashScreenDestination(
           onNavigateRepairsScreen = {
               navController.navigate(RepairsRute)
           }
       )
       repairsScreenDestination(
           repairViewModel = repairViewModel
       )

    }

}
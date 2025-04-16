package com.pmdm.fastool.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pmdm.fastool.ui.features.splash.SplashScreen
import kotlinx.serialization.Serializable

@Serializable
object SplashRoute

fun NavGraphBuilder.splashScreenDestination(
    onNavigateRepairsScreen: () -> Unit
) {
    composable<SplashRoute> { backStackEntry ->
        SplashScreen(
            onNavigateToRepairScreen = onNavigateRepairsScreen)
    }
}
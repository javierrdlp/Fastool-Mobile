package com.pmdm.fastool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
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
               Surface(modifier = Modifier.fillMaxSize()) {
                   val navController = rememberNavController()
                       NavHostRepair(navController = navController)
                }
            }
        }
    }
}
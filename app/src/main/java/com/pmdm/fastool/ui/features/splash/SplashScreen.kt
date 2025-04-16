package com.pmdm.fastool.ui.features.splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pmdm.fastool.R
import com.pmdm.fastool.ui.features.repair.RepairViewModel

import com.pmdm.fastool.ui.theme.FasToolTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToRepairScreen: () -> Unit
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val wideLatin = FontFamily(Font(R.font.wide_latin))

    val infiniteTransition = rememberInfiniteTransition()
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = "Engine"
    )
    // Lanzamos una "espera" de 2 segundos y navegamos
    LaunchedEffect(Unit) {
        delay(5000L)
        onNavigateToRepairScreen()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF6495ED)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "FASTOOL",
                color = Color(0xFF060E88),
                style = MaterialTheme.typography.displaySmall,
                fontStyle = FontStyle.Italic,
                fontFamily = wideLatin
            )
            Text(
                text = "Garage Solutions",
                color = Color(0xFF060E88),
                fontSize = 13.sp,
                fontStyle = FontStyle.Italic,
                fontFamily = wideLatin
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(16.dp)),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Estado reparación."
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Default.Refresh, // Usa este o un recurso tuyo
                    contentDescription = "Flecha dando vueltas",
                    modifier = Modifier
                        .size(40.dp)
                        .rotate(rotation),
                    tint = Color(0xFF060E88)
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Cargando...",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color(0xFF060E88)
                )
            }
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview(){
    FasToolTheme{
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
           SplashScreen(
               modifier = Modifier.padding(innerPadding),
               onNavigateToRepairScreen = {}
            )
        }
    }
}
package com.pmdm.fastool.ui.features.repair.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.pmdm.fastool.R
import com.pmdm.fastool.ui.features.repair.RepUiState
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable
fun RepairCard(
    modifier: Modifier = Modifier,
    repair: RepUiState
) {
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        DialogoReparacion(
            repair = repair,
            onDismissRequest = { showDialog = false }
        )
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { showDialog = true },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF6495ED) // azul suave
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(Color.White.copy(alpha = 0.2f), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                RepairPicture(repair.horaFin)
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Matrícula:",
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
                )
                Text(
                    text = repair.matricula.matricula,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Inicio: ",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White
                        )
                    )
                    Text(
                        text = repair.horaInicio.format(DateTimeFormatter.ofPattern("HH:mm")),
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Fin: ",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White
                        )
                    )
                    repair.horaFin?.let {
                        Text(
                            text = it.format(DateTimeFormatter.ofPattern("HH:mm")),
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                    }
                }

            }
            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Fecha:",
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
                )
                Text(
                    text = repair.horaInicio.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(15.dp))

                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .align(Alignment.CenterHorizontally),
                    contentAlignment = Alignment.Center
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.repair_info),
                        contentScale = ContentScale.Crop,
                        contentDescription = "Estado reparación."
                    )
                }

            }
        }
    }
}

@Composable
fun DialogoReparacion(
    repair: RepUiState,
    onDismissRequest: () -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        val contexto = LocalContext.current

        val painterFoto = repair.matricula.marca.lowercase().let {
            run {
                val imageResource =
                    contexto.resources.getIdentifier(
                        repair.matricula.marca.lowercase(),
                        "drawable",
                        contexto.packageName
                    )
                painterResource(id = imageResource)
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF6495ED)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "- VEHÍCULO -",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color(0xFF060E88),
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Image(
                    modifier = Modifier
                        .width(60.dp)
                        .clip(CircleShape),
                    painter = painterFoto,
                    contentDescription = "Estado reparación."
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = repair.matricula.matricula,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = repair.matricula.modelo,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                )




                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "- CLIENTE -",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color(0xFF060E88),
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = repair.matricula.clienteId.nombre,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "- REPARACIÓN -",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color(0xFF060E88),
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = repair.descripcion,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }
    }
}


@Composable
fun RepairPicture(
    horaFin: ZonedDateTime?
) {
    val painterFoto: Painter = if (horaFin != null) {
        painterResource(id = R.drawable.repair)
    } else {
        painterResource(id = R.drawable.reapair_f)
    }
    Image(
        painter = painterFoto,
        contentScale = ContentScale.Crop,
        contentDescription = "Estado reparación."
    )
}



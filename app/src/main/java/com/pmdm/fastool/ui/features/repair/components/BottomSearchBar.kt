package com.pmdm.fastool.ui.features.repair.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.pmdm.fastool.ui.features.repair.RepairsEvent

@Composable
fun SearchBar(
    onRepairsEvent: (RepairsEvent) -> Unit,
    onEmptySearch: () -> Unit
) {
    var textoBusqueda by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    BottomAppBar(
        actions = {
            OutlinedTextField(
                value = textoBusqueda,
                onValueChange = { textoBusqueda = it
                                onRepairsEvent(RepairsEvent.OnBuscarChange(textoBusqueda))},
                singleLine = true,
                label = { Text("Matrícula") },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .height(56.dp),

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(top=5.dp),
                onClick = {
                    if (textoBusqueda.isNotBlank()) {
                        focusManager.clearFocus()
                        onRepairsEvent(RepairsEvent.OnClickBuscar(textoBusqueda))
                    } else {
                        onEmptySearch()
                    }
                },
                containerColor = if (textoBusqueda.isNotBlank()) Color(0xFF056ad8) else Color.Gray,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
            ) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Buscar",
                    tint = if (textoBusqueda.isNotBlank()) Color.White else Color.LightGray
                )
            }
        }
    )
}

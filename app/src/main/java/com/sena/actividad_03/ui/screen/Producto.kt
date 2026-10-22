package com.sena.actividad_03.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun Producto(
    onirDetalleProducto: (Int) -> Unit,
    onirVolverHome: () -> Unit
){
    var id by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hola desde Producto"
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = id,
            onValueChange = { nuevoValor ->
                id = nuevoValor
            },
            label = { Text("ID del producto") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onirDetalleProducto(id.toIntOrNull() ?: 0) }
        ) {
            Text(
                text = "Ir a producto"
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = onirVolverHome
        ) {
            Text(
                text = "Volver a home"
            )
        }
    }
}

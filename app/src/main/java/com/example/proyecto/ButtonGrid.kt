package com.example.proyecto

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

@Composable
fun ButtonGrid(
    onNavigateContacto: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            FuneralButton("Servicios Funerarios") { /* TODO */ }
            FuneralButton("Envío de Flores") { /* TODO */ }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            FuneralButton("Apoyo emocional\n(pueden ser rezos)") { /* TODO */ }
            FuneralButton("Contáctanos", onNavigateContacto)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            FuneralButton("Descargar Datos\n(ver offline)") { /* TODO */ }
        }
    }
}

@Composable
fun FuneralButton(
    text: String,
    onClick: () -> Unit
) {
    ElevatedButton(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .width(160.dp)
            .height(100.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = Color(0xFF5E2A36),
            contentColor = Color.White
        )
    ) {
        Text(text, textAlign = TextAlign.Center)
    }
}

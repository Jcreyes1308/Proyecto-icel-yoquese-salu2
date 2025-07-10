package com.example.proyecto

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.draw.clip
import androidx.compose.ui.Alignment

@Composable
fun ButtonGrid() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            FuneralButton("Servicios Funerarios")
            FuneralButton("Envío de Flores")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            FuneralButton("Apoyo emocional\n(pueden ser rezos)")
            FuneralButton("Contáctanos")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            FuneralButton("Descargar Datos\n(ver offline)")
        }
    }
}

@Composable
fun FuneralButton(text: String) {
    Button(
        onClick = { /* futura navegación */ },
        modifier = Modifier
            .padding(8.dp)
            .width(160.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(12.dp))
            .shadow(4.dp, RoundedCornerShape(12.dp)),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF5E2A36),
            contentColor = Color.White
        )
    ) {
        Text(text = text, textAlign = TextAlign.Center)
    }
}

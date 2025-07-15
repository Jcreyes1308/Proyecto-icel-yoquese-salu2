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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ButtonGrid(
    onNavigateContacto: () -> Unit,
    onNavigateServicios: () -> Unit,
    onNavigateFlores: () -> Unit,
    onNavigateApoyo: () -> Unit,
    onNavigateDescargar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            FuneralButton(
                text = "Servicios\nFunerarios",
                onClick = onNavigateServicios,
                icon = "⚰️",
                color = Color(0xFF5E2A36)
            )
            FuneralButton(
                text = "Envío de\nFlores",
                onClick = onNavigateFlores,
                icon = "🌸",
                color = Color(0xFF4A5B3A)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            FuneralButton(
                text = "Apoyo\nEmocional",
                onClick = onNavigateApoyo,
                icon = "🤝",
                color = Color(0xFF3A4A5B)
            )
            FuneralButton(
                text = "Contáctanos",
                onClick = onNavigateContacto,
                icon = "📞",
                color = Color(0xFF5B3A4A)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            FuneralButton(
                text = "Descargar\nDatos",
                onClick = onNavigateDescargar,
                icon = "💾",
                color = Color(0xFF3A5B5B)
            )
        }
    }
}

@Composable
fun FuneralButton(
    text: String,
    onClick: () -> Unit,
    icon: String,
    color: Color
) {
    ElevatedButton(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .width(160.dp)
            .height(120.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(16.dp)
            ),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = color,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 6.dp,
            pressedElevation = 12.dp,
            hoveredElevation = 8.dp
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = icon,
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = text,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                lineHeight = 16.sp
            )
        }
    }
}
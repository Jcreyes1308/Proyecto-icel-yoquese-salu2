package com.example.proyecto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Pantalla principal (HOME) que muestra el logo, los botones y el footer.
 * Recibe un callback por cada botón que abre otra pantalla.
 */
@Composable
fun HomeScreen(
    onNavigateContacto: () -> Unit,
    onNavigateApoyo: () -> Unit,
    onNavigateDescargar: () -> Unit,
    onNavigateFlores: () -> Unit,
    onNavigateServicios: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF3E1F27), Color(0xFF1E1E1E))
                )
            )
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            AppTopBar()

            Divider(color = Color.Gray, thickness = 1.dp)

            CementeryLogo()

            Spacer(modifier = Modifier.height(12.dp))

            ButtonGrid(
                onNavigateContacto = onNavigateContacto,
                onNavigateApoyo = onNavigateApoyo,
                onNavigateDescargar = onNavigateDescargar,
                onNavigateFlores = onNavigateFlores,
                onNavigateServicios = onNavigateServicios
            )

            FooterBar()
        }
    }
}
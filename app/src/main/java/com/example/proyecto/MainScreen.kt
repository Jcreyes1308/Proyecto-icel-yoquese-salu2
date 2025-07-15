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

@Composable
fun MainScreen(
    onNavigateContacto: () -> Unit,
    onNavigateServicios: () -> Unit,
    onNavigateFlores: () -> Unit,
    onNavigateApoyo: () -> Unit,
    onNavigateDescargar: () -> Unit,
    onNavigateQR: () -> Unit,
    onNavigateBuscar: () -> Unit,
    onNavigateFechas: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF3E1F27),
                        Color(0xFF2C1B1F),
                        Color(0xFF1E1E1E)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top bar con funcionalidad
            AppTopBar(
                onNavigateQR = onNavigateQR,
                onNavigateBuscar = onNavigateBuscar,
                onNavigateFechas = onNavigateFechas
            )

            Divider(
                color = Color.Gray.copy(alpha = 0.5f),
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            // Logo del cementerio
            CementeryLogo()

            // Espaciador
            Spacer(modifier = Modifier.height(16.dp))

            // Grid de botones principales
            ButtonGrid(
                onNavigateContacto = onNavigateContacto,
                onNavigateServicios = onNavigateServicios,
                onNavigateFlores = onNavigateFlores,
                onNavigateApoyo = onNavigateApoyo,
                onNavigateDescargar = onNavigateDescargar
            )

            // Espaciador
            Spacer(modifier = Modifier.height(16.dp))

            // Footer
            FooterBar()
        }
    }
}

package com.example.proyecto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Pantalla principal (HOME) que muestra el logo, botones y footer.
 */
@Composable
fun HomeScreen(
    onNavigateContacto: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF3E1F27),
                        Color(0xFF1E1E1E)
                    )
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

            ButtonGrid(onNavigateContacto = onNavigateContacto)

            FooterBar()
        }
    }
}

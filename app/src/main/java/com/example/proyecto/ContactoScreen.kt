package com.example.proyecto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactoScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contáctanos", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Volver", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF3E1F27)
                )
            )
        },
        containerColor = Color.Transparent
    ) { innerPadding ->
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
                .padding(innerPadding)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color(0xFF5E2A36),
                tonalElevation = 8.dp,
                shadowElevation = 8.dp,
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Contáctanos para cualquier duda o soporte.",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                    Divider(color = Color.Gray)
                    Text("Correo:", style = MaterialTheme.typography.bodyLarge, color = Color.LightGray)
                    Text("soporte@funeraria.com o yoquese", style = MaterialTheme.typography.bodyMedium, color = Color.White)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Teléfono:", style = MaterialTheme.typography.bodyLarge, color = Color.LightGray)
                    Text("+52 55 1234‑5678", style = MaterialTheme.typography.bodyMedium, color = Color.White)
                }
            }
        }
    }
}

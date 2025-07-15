package com.example.proyecto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiciosFunerariosScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Servicios Funerarios", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Volver")
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
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    ServiceCard(
                        title = "Servicios Básicos",
                        icon = "⚰️",
                        items = listOf(
                            "Preparación del cuerpo",
                            "Ataúd estándar",
                            "Velatorio 24 horas",
                            "Traslado al cementerio"
                        ),
                        price = "Desde $15,000 MXN"
                    )
                }

                item {
                    ServiceCard(
                        title = "Servicios Premium",
                        icon = "👑",
                        items = listOf(
                            "Ataúd de lujo",
                            "Velatorio 48 horas",
                            "Arreglos florales incluidos",
                            "Servicio de cafetería",
                            "Música ambiental"
                        ),
                        price = "Desde $35,000 MXN"
                    )
                }

                item {
                    ServiceCard(
                        title = "Cremación",
                        icon = "🔥",
                        items = listOf(
                            "Proceso de cremación",
                            "Urna básica incluida",
                            "Certificado de cremación",
                            "Entrega de cenizas"
                        ),
                        price = "Desde $8,000 MXN"
                    )
                }

                item {
                    ServiceCard(
                        title = "Servicios Adicionales",
                        icon = "➕",
                        items = listOf(
                            "Fotografía profesional",
                            "Video conmemorativo",
                            "Libro de condolencias",
                            "Transmisión en vivo",
                            "Catering especial"
                        ),
                        price = "Precios variables"
                    )
                }
            }
        }
    }
}

@Composable
fun ServiceCard(
    title: String,
    icon: String,
    items: List<String>,
    price: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF5E2A36)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(
                    text = icon,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(end = 12.dp)
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            items.forEach { item ->
                Row(
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {
                    Text(
                        text = "• ",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                    Text(
                        text = item,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = price,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFFD700)
            )
        }
    }
}
package com.example.proyecto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class FechaImportante(
    val titulo: String,
    val fecha: String,
    val descripcion: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FechasImportantesScreen(onBack: () -> Unit) {
    val fechasImportantes = listOf(
        FechaImportante(
            titulo = "Día de los Fieles Difuntos",
            fecha = "2 de Noviembre",
            descripcion = "Día tradicional para honrar a los difuntos con flores y oraciones"
        ),
        FechaImportante(
            titulo = "Día de Todos los Santos",
            fecha = "1 de Noviembre",
            descripcion = "Conmemoración de todos los santos conocidos y desconocidos"
        ),
        FechaImportante(
            titulo = "Miércoles de Ceniza",
            fecha = "14 de Febrero, 2024",
            descripcion = "Inicio del tiempo de Cuaresma en el calendario litúrgico"
        ),
        FechaImportante(
            titulo = "Semana Santa",
            fecha = "24-31 de Marzo, 2024",
            descripcion = "Semana de mayor importancia en el calendario cristiano"
        ),
        FechaImportante(
            titulo = "Pentecostés",
            fecha = "19 de Mayo, 2024",
            descripcion = "Conmemoración de la venida del Espíritu Santo"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Fechas Importantes", color = Color.White) },
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
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Tarjeta de encabezado
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = Color(0xFF5E2A36),
                    tonalElevation = 8.dp,
                    shadowElevation = 8.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Icon(
                                Icons.Filled.DateRange,
                                contentDescription = null,
                                tint = Color(0xFFD4AF37),
                                modifier = Modifier.size(32.dp)
                            )
                            Text(
                                text = "Fechas Litúrgicas y Conmemorativas",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White
                            )
                        }
                        Text(
                            text = "Días especiales para recordar y honrar a nuestros seres queridos",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.LightGray
                        )
                    }
                }

                // Lista de fechas importantes
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(fechasImportantes) { fecha ->
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = Color(0xFF5E2A36),
                            tonalElevation = 4.dp,
                            shadowElevation = 4.dp,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(20.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.Top
                                ) {
                                    Text(
                                        text = fecha.titulo,
                                        style = MaterialTheme.typography.titleSmall,
                                        color = Color.White,
                                        modifier = Modifier.weight(1f)
                                    )
                                    Surface(
                                        shape = RoundedCornerShape(8.dp),
                                        color = Color(0xFFD4AF37).copy(alpha = 0.2f)
                                    ) {
                                        Text(
                                            text = fecha.fecha,
                                            style = MaterialTheme.typography.bodySmall,
                                            color = Color(0xFFD4AF37),
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                        )
                                    }
                                }

                                Text(
                                    text = fecha.descripcion,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.LightGray,
                                    lineHeight = MaterialTheme.typography.bodyMedium.lineHeight
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
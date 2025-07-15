package com.example.proyecto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.FileDownload
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescargarDatosScreen(onBack: () -> Unit) {
    var isDownloading by remember { mutableStateOf(false) }
    var downloadProgress by remember { mutableStateOf(0f) }
    var downloadedFile by remember { mutableStateOf<String?>(null) }

    val dataTypes = listOf(
        DataType("📋", "Registro de Difuntos", "Lista completa de todas las personas sepultadas", "difuntos.pdf"),
        DataType("🗓️", "Fechas Importantes", "Calendario con fechas de fallecimiento y aniversarios", "fechas.xlsx"),
        DataType("🏛️", "Información del Cementerio", "Datos generales, historia y servicios", "cementerio_info.pdf"),
        DataType("📊", "Estadísticas", "Reportes y análisis de datos del cementerio", "estadisticas.xlsx"),
        DataType("🗺️", "Mapa de Lotes", "Plano detallado de la ubicación de lotes", "mapa_lotes.pdf"),
        DataType("📞", "Directorio de Contactos", "Lista de contactos de servicios y personal", "contactos.pdf")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Descargar Datos", color = Color.White, fontWeight = FontWeight.Bold) },
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
                            Color(0xFF2C1B1F),
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
                            modifier = Modifier.padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Filled.FileDownload,
                                contentDescription = "Descargar",
                                modifier = Modifier.size(48.dp),
                                tint = Color(0xFFFFD700)
                            )

                            Text(
                                text = "Centro de Descargas",
                                style = MaterialTheme.typography.headlineSmall,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                            )

                            Text(
                                text = "Descarga información importante del cementerio en diferentes formatos",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White.copy(alpha = 0.8f),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }

                items(dataTypes.size) { index ->
                    val dataType = dataTypes[index]
                    DataTypeCard(
                        dataType = dataType,
                        isDownloading = isDownloading && downloadedFile == dataType.fileName,
                        downloadProgress = downloadProgress,
                        onDownload = { file ->
                            isDownloading = true
                            downloadedFile = file.fileName

                            // Simular descarga
                            kotlinx.coroutines.MainScope().launch {
                                for (i in 0..100 step 10) {
                                    downloadProgress = i / 100f
                                    delay(200)
                                }
                                delay(500)
                                isDownloading = false
                                downloadedFile = null
                                downloadProgress = 0f
                            }
                        }
                    )
                }

                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF3A5B5B)
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(24.dp)
                        ) {
                            Text(
                                text = "ℹ️ Información Importante",
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )

                            val infoPoints = listOf(
                                "Los archivos se descargarán en formato PDF y Excel",
                                "Todos los datos están actualizados al día de hoy",
                                "La descarga requiere conexión a internet",
                                "Los archivos son seguros y están libres de virus",
                                "Contacta soporte si tienes problemas con las descargas"
                            )

                            infoPoints.forEach { point ->
                                Row(
                                    modifier = Modifier.padding(vertical = 4.dp)
                                ) {
                                    Text(
                                        text = "• ",
                                        color = Color(0xFFFFD700),
                                        fontSize = 16.sp
                                    )
                                    Text(
                                        text = point,
                                        color = Color.White,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DataTypeCard(
    dataType: DataType,
    isDownloading: Boolean,
    downloadProgress: Float,
    onDownload: (DataType) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF4A5B3A)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = dataType.icon,
                    fontSize = 32.sp,
                    modifier = Modifier.padding(end = 16.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = dataType.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = dataType.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.8f),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Text(
                        text = "Archivo: ${dataType.fileName}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.6f),
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            if (isDownloading) {
                Column(
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Descargando...",
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "${(downloadProgress * 100).toInt()}%",
                            color = Color(0xFFFFD700),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    LinearProgressIndicator(
                        progress = downloadProgress,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        color = Color(0xFFFFD700),
                        trackColor = Color.White.copy(alpha = 0.3f)
                    )
                }
            } else {
                Button(
                    onClick = { onDownload(dataType) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFD700),
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Download,
                        contentDescription = "Descargar",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Descargar",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

data class DataType(
    val icon: String,
    val title: String,
    val description: String,
    val fileName: String
)
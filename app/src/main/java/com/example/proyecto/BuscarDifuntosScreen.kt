package com.example.proyecto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuscarDifuntosScreen(onBack: () -> Unit) {
    var searchText by remember { mutableStateOf("") }
    var showResults by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Buscar Difuntos", color = Color.White) },
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
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Tarjeta de búsqueda
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = Color(0xFF5E2A36),
                    tonalElevation = 8.dp,
                    shadowElevation = 8.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "Buscar por nombre o apellido",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White
                        )

                        OutlinedTextField(
                            value = searchText,
                            onValueChange = { searchText = it },
                            label = { Text("Nombre del difunto", color = Color.LightGray) },
                            placeholder = { Text("Ingresa el nombre...", color = Color.Gray) },
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFFD4AF37),
                                unfocusedBorderColor = Color.Gray,
                                focusedTextColor = Color.White,
                                unfocusedTextColor = Color.White,
                                cursorColor = Color(0xFFD4AF37)
                            )
                        )

                        Button(
                            onClick = { showResults = searchText.isNotBlank() },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFD4AF37),
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Icon(Icons.Filled.Search, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Buscar", style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }

                // Resultados de búsqueda
                if (showResults) {
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = Color(0xFF5E2A36),
                        tonalElevation = 8.dp,
                        shadowElevation = 8.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(24.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Text(
                                text = "Resultados de búsqueda",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White
                            )
                            Divider(color = Color.Gray)

                            if (searchText.isNotBlank()) {
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(0xFF2A1F27)
                                    )
                                ) {
                                    Column(
                                        modifier = Modifier.padding(16.dp)
                                    ) {
                                        Text(
                                            text = "María González López",
                                            style = MaterialTheme.typography.bodyLarge,
                                            color = Color.White
                                        )
                                        Text(
                                            text = "Sección: A - Fila: 12 - Lote: 5",
                                            style = MaterialTheme.typography.bodyMedium,
                                            color = Color.LightGray
                                        )
                                        Text(
                                            text = "1945 - 2023",
                                            style = MaterialTheme.typography.bodySmall,
                                            color = Color.Gray
                                        )
                                    }
                                }
                            } else {
                                Text(
                                    text = "No se encontraron resultados",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.Gray
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
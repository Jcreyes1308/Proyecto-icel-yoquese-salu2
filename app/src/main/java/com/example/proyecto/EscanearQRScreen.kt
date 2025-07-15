package com.example.proyecto

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.QrCodeScanner
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
fun EscanearQRScreen(onBack: () -> Unit) {
    var isScanning by remember { mutableStateOf(false) }
    var scannedData by remember { mutableStateOf<PersonData?>(null) }
    var showScanner by remember { mutableStateOf(false) }

    // Datos de ejemplo que se "escanearían" del QR
    val samplePeople = listOf(
        PersonData(
            name = "María González López",
            birthDate = "15 de Marzo, 1945",
            deathDate = "22 de Septiembre, 2023",
            location = "Lote 45, Sección A",
            description = "Querida madre y abuela, siempre en nuestros corazones."
        ),
        PersonData(
            name = "Juan Carlos Hernández",
            birthDate = "8 de Julio, 1952",
            deathDate = "10 de Enero, 2024",
            location = "Lote 128, Sección B",
            description = "Esposo devoto y gran amigo, su legado perdura."
        ),
        PersonData(
            name = "Ana Patricia Ruiz",
            birthDate = "20 de Diciembre, 1967",
            deathDate = "5 de Noviembre, 2023",
            location = "Lote 89, Sección C",
            description = "Maestra ejemplar que tocó muchas vidas."
        )
    )

    LaunchedEffect(isScanning) {
        if (isScanning) {
            delay(3000) // Simular tiempo de escaneo
            scannedData = samplePeople.random()
            isScanning = false
            showScanner = false
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Escanear QR", color = Color.White, fontWeight = FontWeight.Bold) },
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                if (scannedData != null) {
                    // Mostrar información escaneada
                    PersonInfoCard(
                        person = scannedData!!,
                        onScanAgain = {
                            scannedData = null
                            showScanner = false
                        }
                    )
                } else if (showScanner || isScanning) {
                    // Mostrar escáner
                    QRScannerCard(
                        isScanning = isScanning,
                        onCancel = {
                            showScanner = false
                            isScanning = false
                        }
                    )
                } else {
                    // Mostrar instrucciones
                    InstructionsCard(
                        onStartScan = {
                            showScanner = true
                            isScanning = true
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun InstructionsCard(onStartScan: () -> Unit) {
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
                imageVector = Icons.Filled.QrCode,
                contentDescription = "QR Code",
                modifier = Modifier.size(64.dp),
                tint = Color(0xFFFFD700)
            )

            Text(
                text = "Escanear Código QR",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            )

            Text(
                text = "Apunta tu cámara hacia el código QR ubicado en las lápidas para obtener información detallada sobre la persona sepultada.",
package com.example.proyecto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnvioFloresScreen(onBack: () -> Unit) {
    var selectedFlower by remember { mutableStateOf("") }
    var recipientName by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var showOrderConfirmation by remember { mutableStateOf(false) }

    val flowerOptions = listOf(
        FlowerOption("🌹", "Rosas Rojas", "$350 MXN", "Símbolo de amor y respeto"),
        FlowerOption("🌼", "Margaritas", "$200 MXN", "Pureza y inocencia"),
        FlowerOption("🌻", "Girasoles", "$280 MXN", "Admiración y lealtad"),
        FlowerOption("🌺", "Hibisco", "$320 MXN", "Belleza delicada"),
        FlowerOption("🌷", "Tulipanes", "$300 MXN", "Amor perfecto"),
        FlowerOption("🌸", "Flores de Cerezo", "$380 MXN", "Vida efímera y belleza")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Envío de Flores", color = Color.White, fontWeight = FontWeight.Bold) },
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
            if (showOrderConfirmation) {
                OrderConfirmationCard(
                    onClose = { showOrderConfirmation = false },
                    flowerName = flowerOptions.find { it.emoji == selectedFlower }?.name ?: "",
                    recipientName = recipientName
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        Text(
                            text = "Selecciona un arreglo floral",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }

                    items(flowerOptions) { flower ->
                        FlowerCard(
                            flower = flower,
                            isSelected = selectedFlower == flower.emoji,
                            onSelect = { selectedFlower = flower.emoji }
                        )
                    }

                    item {
                        if (selectedFlower.isNotEmpty()) {
                            OrderFormCard(
                                recipientName = recipientName,
                                onRecipientNameChange = { recipientName = it },
                                message = message,
                                onMessageChange = { message = it },
                                onSubmit = { showOrderConfirmation = true }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FlowerCard(
    flower: FlowerOption,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        onClick = onSelect,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(0xFF5E2A36) else Color(0xFF4A5B3A)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isSelected) 12.dp else 6.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = flower.emoji,
                fontSize = 32.sp,
                modifier = Modifier.padding(end = 16.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = flower.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = flower.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.8f),
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    text = flower.price,
                    style = MaterialTheme.typography.titleSmall,
                    color = Color(0xFFFFD700),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            if (isSelected) {
                Text(
                    text = "✓",
                    fontSize = 24.sp,
                    color = Color(0xFFFFD700),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun OrderFormCard(
    recipientName: String,
    onRecipientNameChange: (String) -> Unit,
    message: String,
    onMessageChange: (String) -> Unit,
    onSubmit: () -> Unit
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
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                text = "Información del envío",
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = recipientName,
                onValueChange = onRecipientNameChange,
                label = { Text("Nombre del destinatario", color = Color.White) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color(0xFFFFD700),
                    unfocusedBorderColor = Color.White,
                    focusedLabelColor = Color(0xFFFFD700),
                    unfocusedLabelColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = message,
                onValueChange = onMessageChange,
                label = { Text("Mensaje de condolencias", color = Color.White) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color(0xFFFFD700),
                    unfocusedBorderColor = Color.White,
                    focusedLabelColor = Color(0xFFFFD700),
                    unfocusedLabelColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(bottom = 16.dp),
                maxLines = 4
            )

            Button(
                onClick = onSubmit,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFD700),
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp),
                enabled = recipientName.isNotBlank()
            ) {
                Text(
                    text = "Realizar Pedido",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun OrderConfirmationCard(
    onClose: () -> Unit,
    flowerName: String,
    recipientName: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF4A5B3A)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "✓",
                fontSize = 48.sp,
                color = Color(0xFFFFD700),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "¡Pedido Confirmado!",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Tu pedido de $flowerName para $recipientName ha sido procesado exitosamente.",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Tiempo estimado de entrega: 2-4 horas",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.8f),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Button(
                onClick = onClose,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFD700),
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Cerrar",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

data class FlowerOption(
    val emoji: String,
    val name: String,
    val price: String,
    val description: String
)
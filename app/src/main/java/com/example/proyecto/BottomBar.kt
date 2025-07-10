package com.example.proyecto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text

@Composable
fun BottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2C2C2E))
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        listOf("Términos", "Privacidad", "Sobre la app", "Versión").forEach {
            Text(it, color = Color.Gray, fontSize = 12.sp)
        }
    }
}

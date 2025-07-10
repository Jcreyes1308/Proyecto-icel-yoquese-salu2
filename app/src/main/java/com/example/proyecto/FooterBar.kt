package com.example.proyecto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.material3.MaterialTheme


@Composable
fun FooterBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF3E1F27))
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            FooterLink("Términos")
            FooterLink("Privacidad")
            FooterLink("Sobre la app")
            FooterLink("Versión 1.0")
        }
    }
}

@Composable
fun FooterLink(text: String) {
    Text(
        text = text,
        color = Color.White,
        style = MaterialTheme.typography.bodySmall
    )
}



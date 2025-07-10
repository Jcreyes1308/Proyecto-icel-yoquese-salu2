package com.example.proyecto

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun AppTopBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF3E1F27))
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "Logo Izquierdo",
                modifier = Modifier.size(32.dp)
            )

            Text(
                text = "Nombre de la App",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )

            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "Logo Derecho",
                modifier = Modifier.size(32.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TopBarButton("Escanear QR")
            TopBarButton("Buscar Difuntos")
            TopBarButton("Fechas Importantes")
        }
    }
}

@Composable
fun TopBarButton(text: String) {
    Button(
        onClick = { /* futura acción */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF5E2A36),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .height(36.dp)
    ) {
        Text(text, style = MaterialTheme.typography.bodySmall)
    }
}



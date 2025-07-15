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
import androidx.compose.ui.draw.shadow

@Composable
fun AppTopBar(
    onNavigateQR: () -> Unit = {},
    onNavigateBuscar: () -> Unit = {},
    onNavigateFechas: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF3E1F27))
            .padding(vertical = 8.dp)
            .shadow(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "Logo Izquierdo",
                modifier = Modifier.size(36.dp)
            )

            Text(
                text = "Cementerio Jose-San",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "Logo Derecho",
                modifier = Modifier.size(36.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TopBarButton(
                text = "Escanear QR",
                onClick = onNavigateQR,
                icon = "📱"
            )
            TopBarButton(
                text = "Buscar Difuntos",
                onClick = onNavigateBuscar,
                icon = "🔍"
            )
            TopBarButton(
                text = "Fechas Importantes",
                onClick = onNavigateFechas,
                icon = "📅"
            )
        }
    }
}

@Composable
fun TopBarButton(
    text: String,
    onClick: () -> Unit,
    icon: String
) {
    ElevatedButton(
        onClick = onClick,
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = Color(0xFF5E2A36),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .height(48.dp)
            .width(110.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = icon,
                fontSize = 16.sp
            )
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                fontSize = 10.sp
            )
        }
    }
}


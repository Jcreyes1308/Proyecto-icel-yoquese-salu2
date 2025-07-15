package com.example.proyecto

import androidx.compose.runtime.Composable

@Composable
fun AppRoot(
    pantallaActual: Pantalla,
    cambiarPantalla: (Pantalla) -> Unit
) {
    when (pantallaActual) {
        Pantalla.HOME -> MainScreen(
            onNavigateContacto = { cambiarPantalla(Pantalla.CONTACTO) }
        )

        Pantalla.CONTACTO -> ContactoScreen(
            onBack = { cambiarPantalla(Pantalla.HOME) }
        )
    }
}

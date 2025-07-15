package com.example.proyecto

import androidx.compose.runtime.Composable

@Composable
fun AppRoot(
    pantallaActual: Pantalla,
    cambiarPantalla: (Pantalla) -> Unit
) {
    when (pantallaActual) {
        Pantalla.HOME -> MainScreen(
            onNavigateContacto = { cambiarPantalla(Pantalla.CONTACTO) },
            onNavigateServicios = { cambiarPantalla(Pantalla.SERVICIOS_FUNERARIOS) },
            onNavigateFlores = { cambiarPantalla(Pantalla.ENVIO_FLORES) },
            onNavigateApoyo = { cambiarPantalla(Pantalla.APOYO_EMOCIONAL) },
            onNavigateDescargar = { cambiarPantalla(Pantalla.DESCARGAR_DATOS) },
            onNavigateQR = { cambiarPantalla(Pantalla.ESCANEAR_QR) },
            onNavigateBuscar = { cambiarPantalla(Pantalla.BUSCAR_DIFUNTOS) },
            onNavigateFechas = { cambiarPantalla(Pantalla.FECHAS_IMPORTANTES) }
        )

        Pantalla.CONTACTO -> ContactoScreen(
            onBack = { cambiarPantalla(Pantalla.HOME) }
        )

        Pantalla.SERVICIOS_FUNERARIOS -> ServiciosFunerariosScreen(
            onBack = { cambiarPantalla(Pantalla.HOME) }
        )

        Pantalla.ENVIO_FLORES -> EnvioFloresScreen(
            onBack = { cambiarPantalla(Pantalla.HOME) }
        )

        Pantalla.APOYO_EMOCIONAL -> ApoyoEmocionalScreen(
            onBack = { cambiarPantalla(Pantalla.HOME) }
        )

        Pantalla.DESCARGAR_DATOS -> DescargarDatosScreen(
            onBack = { cambiarPantalla(Pantalla.HOME) }
        )

        Pantalla.ESCANEAR_QR -> EscanearQRScreen(
            onBack = { cambiarPantalla(Pantalla.HOME) }
        )

        Pantalla.BUSCAR_DIFUNTOS -> BuscarDifuntosScreen(
            onBack = { cambiarPantalla(Pantalla.HOME) }
        )

        Pantalla.FECHAS_IMPORTANTES -> FechasImportantesScreen(
            onBack = { cambiarPantalla(Pantalla.HOME) }
        )
    }
}
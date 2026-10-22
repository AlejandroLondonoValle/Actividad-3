package com.sena.actividad_03.navegation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.sena.actividad_03.ui.screen.DetalleProductoScreen
import com.sena.actividad_03.ui.screen.Home
import com.sena.actividad_03.ui.screen.Producto

// Logica de implementacion de las rutas y trata la informacion que se mueve en las ventanas, consume al routes

@Composable
fun AppNavegation(
    modifier: Modifier = Modifier
){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Inicio,
        modifier = modifier
    ){
        composable<Inicio>{
            Home(
                onirProducto = {
                    navController.navigate(route = Productos)
                }
            )
        }

        composable<Productos>{
            Producto(
                onirDetalleProducto = { idProducto ->
                    navController.navigate(route = DetalleProducto(id = idProducto))
                },
                onirVolverHome = {
                    navController.popBackStack()
                }
            )
        }

        composable<DetalleProducto>{ backStackEntry ->
            val args = backStackEntry.toRoute<DetalleProducto>()
            DetalleProductoScreen(
                id = args.id
            )
        }
    }
}

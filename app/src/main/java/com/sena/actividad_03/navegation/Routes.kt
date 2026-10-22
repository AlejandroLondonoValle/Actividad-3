package com.sena.actividad_03.navegation

import kotlinx.serialization.Serializable

//Define las rutas especificas de mi aplicacion, una lista de mis rutas y si tiene o no tiene parametros

@Serializable
data object Inicio

@Serializable
data object Productos

@Serializable
data class DetalleProducto(
    val id : Int
)
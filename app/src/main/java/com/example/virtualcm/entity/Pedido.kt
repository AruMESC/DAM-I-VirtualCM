package com.example.virtualcm.entity

data class Pedido (
    val pedCli : Int = 0,
    val pedMonto : Double = 0.0,
    val pedCanti : Int = 0,
    val pedFecha : String = "",
    val cliID : Int = 0,
    val menuID : Int = 0,
    val cociID : Int = 0
)
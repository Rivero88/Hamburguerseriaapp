package com.example.hamburguerseriaapp.Data

data class Pedido (
    var productos: ArrayList<Producto>,
    var precioPedidoTotal: Int
)
package com.example.hamburguerseriaapp.Data

data class Pedido (
    var productos: ArrayList<ProductosPedidos>,
    var precioPedidoTotal: Int
)
package com.example.hamburguerseriaapp.Data

import com.example.hamburguerseriaapp.R

object DataSourcePedidos{
    var pedido1 = arrayListOf<ProductosPedidos>(
        ProductosPedidos(Producto(R.drawable.hamburguesa_simple,"Simple", 7, arrayListOf(Ingrediente("Carne de ternera"), Ingrediente("queso"), Ingrediente("lechuga"), Ingrediente("tomate"), Ingrediente("pepinillo"), Ingrediente("ketchup"))),3),
        ProductosPedidos(Producto(R.drawable.hamburguesa_doble,"Doble", 9, arrayListOf(Ingrediente("Doble de carne de ternera"), Ingrediente("queso"), Ingrediente("lechuga"), Ingrediente("tomate"), Ingrediente("pepinillo"), Ingrediente("ketchup"))),4)
    )

    var pedido2 = arrayListOf<ProductosPedidos>(
        ProductosPedidos(Producto(R.drawable.hamburguesa_mini,"Mini", 2, arrayListOf(Ingrediente("Mini-carne de ternera"), Ingrediente("queso"), Ingrediente("lechuga"), Ingrediente("tomate"), Ingrediente("pepinillo"), Ingrediente("ketchup"))),4),
            ProductosPedidos(Producto(R.drawable.hamburguesa_pescado,"Pescado", 9, arrayListOf(Ingrediente("Filete pescado"), Ingrediente("lechuga"), Ingrediente("tomate"), Ingrediente("mayonesa"))),4)
    )

    var pedidos = arrayListOf<Pedido>(Pedido(pedido1, 57),
        Pedido(pedido2, 44)
    )
}
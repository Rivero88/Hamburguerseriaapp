package com.example.hamburguerseriaapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.hamburguerseriaapp.Data.HamburgueseriaUIState
import com.example.hamburguerseriaapp.Data.HamburgueseriaViewModel
import com.example.hamburguerseriaapp.Data.Producto

@Composable
fun PantallaPedidoActual(onClickCambiarPantallaPedidoActual: () -> Unit,
                         uiState:HamburgueseriaUIState, viewModel: HamburgueseriaViewModel) {
    Column () {
        LazyVerticalGrid(columns = GridCells.Fixed(1),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center){
            items(uiState.pedidoActual.productos){ producto->
                if(producto.cantidad > 0) {
                    Column() {
                        Text(text = "Producto: ${producto.nombre}. Cantidad: ${producto.cantidad} unidades. Precio: ${producto.precio} €")
                        Button(onClick = { viewModel.eliminarProductoDelPedido(producto) }) {
                            Text(text = "Eliminar")
                        }
                    }
                }
            }
        }
        Text(text = "Total pedido: ${uiState.pedidoActual.precioPedidoTotal} €")
    }

}

package com.example.hamburguerseriaapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.hamburguerseriaapp.Data.HamburgueseriaUIState
import com.example.hamburguerseriaapp.Data.HamburgueseriaViewModel

@Composable
fun PantallaPedidoActual(onClickCambiarPantallaPedidoActual: () -> Unit,
                         uiState:HamburgueseriaUIState, viewModel: HamburgueseriaViewModel) {
    Column () {
        LazyVerticalGrid(columns = GridCells.Fixed(1),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier){
            items(uiState.pedidoActual.productos){ producto->
                if(producto.cantidad > 0) {
                    Column() {
                            Text(text = "Producto: ${producto.nombre}.",
                                modifier = Modifier
                                    .background(Color.Green))
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(text = "Cantidad: ${producto.cantidad} unidades.",
                                modifier = Modifier
                                    .background(Color.LightGray))
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(text = "Precio: ${producto.precio} €",
                                modifier = Modifier
                                    .background(Color.Red))
                        Spacer(modifier = Modifier.height(4.dp))
                        Button(onClick = { viewModel.eliminarProductoDelPedido(producto) }) {
                            Text(text = "Eliminar")
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        /**Button(onClick = { viewModel.anadirAPedido(producto) }) {
                            Text(text = "Añadir")
                        }*/
                    }
                }
            }
        }
        Text(text = "Total pedido: ${uiState.pedidoActual.precioPedidoTotal} €")
    }
}

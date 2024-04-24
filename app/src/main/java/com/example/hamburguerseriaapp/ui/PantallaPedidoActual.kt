package com.example.hamburguerseriaapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.hamburguerseriaapp.Data.HamburgueseriaUIState
import com.example.hamburguerseriaapp.Data.HamburgueseriaViewModel

@Composable
fun PantallaPedidoActual(onClickCambiarPantallaPedidoActual: () -> Unit, onClickCambiarPantallaPedidoHistorico: () -> Unit,
                         onClickCambiarPantallaPrincipal: () -> Unit, uiState:HamburgueseriaUIState,
                         viewModel: HamburgueseriaViewModel) {
    Column () {
        LazyVerticalGrid(columns = GridCells.Fixed(1),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier){
            items(uiState.pedidoActual.productos){ producto->
                if(producto.cantidad > 0) {
                    Column(Modifier) {
                            Text(text = "Producto: ${producto.nombre}.",
                                Modifier.background(Color.Green))
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(text = "Cantidad: ${producto.cantidad} unidades.",
                                Modifier.background(Color.LightGray))
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(text = "Precio: ${producto.precio} €",
                                Modifier.background(Color.Red))
                        Spacer(Modifier.height(10.dp))
                        Button(onClick = { viewModel.eliminarProductoDelPedido(producto) }) {
                                Text(text = "Eliminar")
                        }
                        Spacer(Modifier.height(10.dp))
                    }
                }
            }
        }
        Text(text = "Total pedido: ${uiState.pedidoActual.precioPedidoTotal} €",
            modifier = Modifier.background(Color.Gray))
        Spacer(Modifier.height(10.dp))
        if(uiState.pedidoActual.precioPedidoTotal > 0){
            Row (modifier = Modifier) {
                Button(onClick = {
                    viewModel.pagarYVaciarCarrito()
                    onClickCambiarPantallaPedidoHistorico.invoke()
                }, Modifier.fillMaxWidth()) {
                    Text(text = "Confirmar y pagar pedido")
                }
                Spacer(Modifier.width(6.dp))
                Button(onClick = { onClickCambiarPantallaPrincipal.invoke()
                                 },
                    Modifier.fillMaxWidth()) {
                    Text(text = "Volver")
                }
            }

        }

    }
}

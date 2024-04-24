package com.example.hamburguerseriaapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import com.example.hamburguerseriaapp.Data.Pedido

@Composable
fun PantallaPedidosHistoricos(onClickCambiarPantallaPedidoHistorico: () -> Unit,
                              onClickCambiarPantallaPrincipal: () -> Unit,
                              pedidosHistorico: ArrayList<Pedido>) {
    
    Column (modifier = Modifier){
        LazyVerticalGrid(columns = GridCells.Fixed(1),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center){
            items(pedidosHistorico){pedido->
                Column(Modifier.border(1.dp,Color.Black)
                    ) {
                    Text(text = "Pedido nº ${pedidosHistorico.indexOf(pedido)+1}",
                        Modifier.background(Color.Yellow))
                    Spacer(Modifier.height(7.dp))
                    Text(text = "Precio total del pedido: ${pedido.precioPedidoTotal} €",
                        Modifier.background(Color.LightGray))
                    Spacer(Modifier.height(12.dp))
                }
            }
        }
        Spacer(Modifier.height(20.dp))
        Text(text = "Precio total de pedidos realizados: ${ObtenerPrecioTotal(pedidosHistorico = pedidosHistorico)} €",
            Modifier.background(Color.Cyan))
        Spacer(Modifier.height(20.dp))
        Button(onClick = { onClickCambiarPantallaPrincipal.invoke() },
            Modifier.width(350.dp)
                .align(alignment = Alignment.CenterHorizontally)) {
            Text(text = "Volver")
        }
    }
}

@Composable
fun ObtenerPrecioTotal( pedidosHistorico: ArrayList<Pedido>): Int{
    var precioTotalTodosPedidosRealizados = 0
    for (pedido in pedidosHistorico){
        precioTotalTodosPedidosRealizados += pedido.precioPedidoTotal
    }
    return precioTotalTodosPedidosRealizados
}
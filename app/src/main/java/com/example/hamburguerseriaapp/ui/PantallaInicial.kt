package com.example.hamburguerseriaapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hamburguerseriaapp.Data.HamburgueseriaViewModel
import com.example.hamburguerseriaapp.Data.Producto

@Composable
private fun MyDialog(onClose: () -> Unit, producto: Producto, mostrarDialogo:Boolean ) {
    // ComposeDialog viene con AlertDialog, que puedes personalizar según las necesidades
    if (mostrarDialogo){
        AlertDialog(
            onDismissRequest = {
                // Llamamos a onClose cuando se solicita cerrar el diálogo
                onClose.invoke()
            },
            title = { Text("Ingredientes",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold)},
            text = { Text("${producto.toString()}",
                textAlign = TextAlign.Center,
                fontSize = 10.5.sp,
                fontWeight = FontWeight.SemiBold) },
            confirmButton = {
                Button(
                    onClick = {
                        onClose.invoke()
                    }, modifier = Modifier
                ) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        onClose.invoke()
                    }
                ) {
                    Text("Cancelar")
                }
            }
        )
    }
}

@Composable
fun PantallaInicial(onClickCambiarPantallaPedidoActual: () -> Unit, onClickCambiarPantallaPedidoHistorico: () -> Unit, productos: ArrayList<Producto>,
                     viewModel: HamburgueseriaViewModel) {
   
    Column (modifier = Modifier.fillMaxWidth()) {
        Text(text = "Hamburguesería Ester", modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.Yellow))
        VentanaProductos(productos = productos, viewModel)
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)){
            Button(onClick = { onClickCambiarPantallaPedidoActual.invoke() }) {
                Text(text = "Pedido actual")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = { onClickCambiarPantallaPedidoHistorico.invoke() }) {
                Text(text = "Histórico pedidos")
            }
        }
    }
}

@Composable
private fun VentanaProductos(productos: ArrayList<Producto>, viewModel: HamburgueseriaViewModel){
    LazyVerticalGrid(modifier = Modifier,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Center){
        items(productos){producto ->
            var mostrarDialogo by remember { mutableStateOf(false) }
            Card(modifier = Modifier
                .height(200.dp)
                .padding(5.dp)) {
                Image(painter = painterResource(id = producto.imagen),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(50.dp)
                        .width(250.dp))
                Text(text = "Nombre: ${producto.nombre}", modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Yellow))
                Text(text = "Precio: ${producto.precio} €", modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan))
                Column (){
                    Button(onClick = { viewModel.anadirAPedido(producto) }) {
                        Text(text ="Añadir a pedido")
                    }

                    Button(onClick = { mostrarDialogo=true }) {
                        Text(text ="Ver ingredientes")
                    }
                    MyDialog (onClose = {mostrarDialogo=false},producto = producto, mostrarDialogo = mostrarDialogo)
                }
            }
        }
    }
}


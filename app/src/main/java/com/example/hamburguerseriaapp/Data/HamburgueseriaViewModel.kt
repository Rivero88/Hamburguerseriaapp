package com.example.hamburguerseriaapp.Data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HamburgueseriaViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(HamburgueseriaUIState())
    val uiState: StateFlow<HamburgueseriaUIState> = _uiState.asStateFlow()

    fun anadirAPedido(producto: Producto){

        var pedidoActual: Pedido = _uiState.value.listadoDelPedido
        pedidoActual.productos.add(ProductosPedidos(producto, 1))

        _uiState.update {
            actualizacionPedido -> actualizacionPedido.copy(
                //listadoDelPedido = Pedido(pedidoActual.productos,)
            )
        }
    }

}
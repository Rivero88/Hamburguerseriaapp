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
         for(prod in _uiState.value.pedidoActual.productos){
            if(prod.nombre.equals(producto.nombre)){
                prod.cantidad += 1
                _uiState.value.pedidoActual.precioPedidoTotal += prod.precio
            }
        }
        _uiState.update {
            actualizacionPedido -> actualizacionPedido.copy(
            pedidoActual = _uiState.value.pedidoActual
            )
        }
    }

    fun eliminarProductoDelPedido (producto: Producto){

        var pedidoActual = _uiState.value.pedidoActual

        for(prod in pedidoActual.productos){
            if (prod.nombre.equals(producto.nombre)){
                prod.cantidad -= 1
                pedidoActual.precioPedidoTotal -= prod.precio
            }
        }
        _uiState.update {
                actualizacionPedido -> actualizacionPedido.copy(
            pedidoActual = pedidoActual
            )
        }
    }

}
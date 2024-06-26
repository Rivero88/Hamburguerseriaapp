package com.example.hamburguerseriaapp.Data

import androidx.lifecycle.ViewModel
import com.example.hamburguerseriaapp.R
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
        _uiState.update { uiState ->
            var productos = uiState.pedidoActual.productos
            var precioPedidoTotal = uiState.pedidoActual.precioPedidoTotal
            for(prod in productos){
                if (prod.nombre.equals(producto.nombre)){
                    prod.cantidad -= 1
                    precioPedidoTotal -= prod.precio
                }
            }
            uiState.copy(
                pedidoActual = Pedido(productos, precioPedidoTotal)
            )
        }
    }

    fun pagarYVaciarCarrito(){

        val pedidoActualCopia = _uiState.value.pedidoActual.copy()

        _uiState.value.historicoPedidos.add(pedidoActualCopia)

        for(producto in _uiState.value.pedidoActual.productos){
            producto.cantidad=0
        }
        _uiState.value.pedidoActual.precioPedidoTotal=0

        _uiState.update {
                actualizacionPedido -> actualizacionPedido.copy(
            pedidoActual = _uiState.value.pedidoActual,
            historicoPedidos = _uiState.value.historicoPedidos
        )
        }
    }

}
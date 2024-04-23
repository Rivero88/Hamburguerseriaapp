package com.example.hamburguerseriaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hamburguerseriaapp.Data.DataSource
import com.example.hamburguerseriaapp.Data.HamburgueseriaViewModel
import com.example.hamburguerseriaapp.Data.Producto
import com.example.hamburguerseriaapp.ui.PantallaInicial
import com.example.hamburguerseriaapp.ui.PantallaPedidoActual
import com.example.hamburguerseriaapp.ui.PantallaPedidosHistoricos
import com.example.hamburguerseriaapp.theme.HamburguerseriaappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HamburguerseriaappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Principal(productos = DataSource.productos)
                }
            }
        }
    }
}

enum class PrincipalScreen(@StringRes val title: Int) {
    PantallaPrincipal(title = R.string.p1),
    PantallaPedidoActual(title = R.string.p2),
    PantallaHistoricoPedidos(title = R.string.p3),
}

@Composable
fun Principal(navController: NavHostController = rememberNavController(), productos: ArrayList<Producto>) {
   val viewModelHamburgueseria: HamburgueseriaViewModel = viewModel()
   val uiState by viewModelHamburgueseria.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = PrincipalScreen.PantallaPrincipal.name,
        //modifier = Modifier.padding(innerPadding)
    ) {
        composable(route = PrincipalScreen.PantallaPrincipal.name) {
            PantallaInicial(
                onClickCambiarPantallaPedidoActual = { navController.navigate(PrincipalScreen.PantallaPedidoActual.name) },
                onClickCambiarPantallaPedidoHistorico = { navController.navigate(PrincipalScreen.PantallaHistoricoPedidos.name) },
                productos=productos, viewModelHamburgueseria)

        }
        composable(route = PrincipalScreen.PantallaPedidoActual.name) {
            PantallaPedidoActual( onClickCambiarPantallaPedidoActual = { navController.navigate(PrincipalScreen.PantallaPrincipal.name) }, uiState = uiState,
                viewModel = viewModelHamburgueseria)
        }
        composable(route = PrincipalScreen.PantallaHistoricoPedidos.name) {
            PantallaPedidosHistoricos { navController.navigate(PrincipalScreen.PantallaPrincipal.name) }
        }
    }
}


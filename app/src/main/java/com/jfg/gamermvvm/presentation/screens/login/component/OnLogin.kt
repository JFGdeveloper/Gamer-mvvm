package com.jfg.gamermvvm.presentation.screens.login.component

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.presentation.navigation.routes.Graph
import com.jfg.gamermvvm.presentation.navigation.routes.RootScreen
import com.jfg.gamermvvm.presentation.screens.Composables.MyProgressBar
import com.jfg.gamermvvm.presentation.screens.login.LoginViewModel

@Composable
fun OnLogin(controller: NavHostController,vm: LoginViewModel = hiltViewModel()) {

    val context = LocalContext.current

    when(val response = vm.loginResponse){
        Response.Loading -> {
           MyProgressBar()
        }
        is Response.Success -> {
            LaunchedEffect(Unit){
                controller.navigate(Graph.HOME){
                    popUpTo(Graph.AUTHENTICATION){
                        inclusive = true
                    }
                }
            }
        }
        is Response.Failure -> {
            Toast.makeText(context, response.exception?.message ?: "Error al logearte", Toast.LENGTH_SHORT).show()
        }

        else -> { Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter){
            Text(text = "Respuesta es null")
            Spacer(modifier = Modifier.height(50.dp))
            CircularProgressIndicator()
        }

        }

    }


}
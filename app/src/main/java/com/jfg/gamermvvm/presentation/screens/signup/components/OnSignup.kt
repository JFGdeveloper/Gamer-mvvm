package com.jfg.gamermvvm.presentation.screens.signup

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.presentation.navigation.routes.AuthScreen
import com.jfg.gamermvvm.presentation.navigation.routes.Graph
import com.jfg.gamermvvm.presentation.navigation.routes.RootScreen

@Composable
fun OnSignup(controller: NavHostController, vm: SignupViewModel = hiltViewModel()) {
    when(val response = vm.response){
        Response.Loading ->{
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        }
        is Response.Success ->{
            LaunchedEffect(Unit){
                vm.createUser()
                controller.navigate(Graph.HOME){
                    popUpTo(Graph.AUTHENTICATION){
                        inclusive = true
                    }
                }
            }
        }
        is Response.Failure ->{
            Toast.makeText(LocalContext.current, response.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG).show()
        }
        else -> {}

    }

}
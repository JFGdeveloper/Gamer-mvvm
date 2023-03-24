package com.jfg.gamermvvm.presentation.screens.signup

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.presentation.navigation.AuthScreen
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultTopAppbar
import com.jfg.gamermvvm.presentation.screens.signup.components.SignupContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignupScreen(controller: NavHostController) {
    Scaffold (
            topBar = {
                DefaultTopAppbar(
                        title = "Nuevo usuario",
                        controller = controller,
                        backAvailable = true,
                        screen = AuthScreen.Login
                )
            },
            content = {
                      SignupContent(paddingValues = it)
            },
            bottomBar = {},

    )

    // LOGICA PARA NAVEGAR
    OnSignup(controller = controller)
}
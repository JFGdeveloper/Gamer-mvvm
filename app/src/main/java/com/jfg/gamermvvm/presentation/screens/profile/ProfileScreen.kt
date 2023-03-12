package com.jfg.gamermvvm.presentation.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.presentation.navigation.AppScreen
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultButton

@Composable
fun ProfileScreen(controller: NavHostController,viewModel: ProfileViewModel = hiltViewModel()) {

    Scaffold(
            topBar = {},
            content = {
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(text = "PERFIL USUARIO")

                    DefaultButton(
                            modifier = Modifier.padding(it),
                            text = "Ir a login",
                            icon = Icons.Default.ArrowForward
                    ) {
                        viewModel.onLogout()
                        controller.navigate(AppScreen.Login.route){
                            popUpTo(AppScreen.Profile.route){ inclusive = true}
                        }
                    }
                }

            },
            bottomBar = {}
    )

}
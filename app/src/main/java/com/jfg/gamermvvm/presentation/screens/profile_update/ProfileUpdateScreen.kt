package com.jfg.gamermvvm.presentation.screens.profile_update

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.presentation.navigation.AppScreen
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultTopAppbar
import com.jfg.gamermvvm.presentation.screens.profile_update.components.ProfileUpdateContent
import com.jfg.gamermvvm.presentation.screens.profile_update.components.ValidateUpdate

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileUpdateScreen(controller: NavHostController, user: String) {
    Scaffold (
            topBar = {
                DefaultTopAppbar(title = "Editar", controller = controller, backAvailable = true, screen = AppScreen.Profile)
            },
            content = {
                      ProfileUpdateContent(paddingValues = it)
            },
            bottomBar = {},

    )

    // LOGICA PARA NAVEGAR
    ValidateUpdate()
}
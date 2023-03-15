package com.jfg.gamermvvm.presentation.screens.profile_edit

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.presentation.navigation.AppScreen
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultTopAppbar
import com.jfg.gamermvvm.presentation.screens.profile_edit.components.ProfileEditContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileEditScreen(controller: NavHostController) {
    Scaffold (
            topBar = {
                DefaultTopAppbar(title = "Editar", controller = controller, backAvailable = true, screen = AppScreen.Profile)
            },
            content = {
                      ProfileEditContent(paddingValues = it)
            },
            bottomBar = {},

    )

    // LOGICA PARA NAVEGAR
    OnEdit(controller = controller)
}
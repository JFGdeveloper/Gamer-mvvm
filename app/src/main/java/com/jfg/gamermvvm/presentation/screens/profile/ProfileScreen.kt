package com.jfg.gamermvvm.presentation.screens.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.presentation.screens.profile.components.ProfileContent

@Composable
fun ProfileScreen(controller: NavHostController,viewModel: ProfileViewModel = hiltViewModel()) {

    Scaffold(
            topBar = {},
            content = {
                ProfileContent(modifier = Modifier.padding(it), controller = controller, vm = viewModel)
            },
            bottomBar = {}
    )

}
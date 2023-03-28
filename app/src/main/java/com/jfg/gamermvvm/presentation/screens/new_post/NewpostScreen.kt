package com.jfg.gamermvvm.presentation.screens.new_post

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.presentation.navigation.routes.DetailScreen
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultButton
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultTopAppbar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NewPostScreen(controller: NavHostController, viewModel: NewPostViewModel = hiltViewModel()) {
    Scaffold(
            topBar = {
                DefaultTopAppbar(title = "Nuevo post", backAvailable = true, controller = controller)
            },
             content = {
                 NewPostContent(vm = viewModel)
             },
            bottomBar = {
                DefaultButton(
                        text = "Publicar",
                        icon = Icons.Default.ArrowForward,
                        modifier = Modifier.fillMaxWidth()
                ) {
                    viewModel.onNewPost()
                }
            }
    )
}
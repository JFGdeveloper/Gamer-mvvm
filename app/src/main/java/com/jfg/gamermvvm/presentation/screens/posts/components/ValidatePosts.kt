package com.jfg.gamermvvm.presentation.screens.posts.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.presentation.screens.Composables.MyProgressBar
import com.jfg.gamermvvm.presentation.screens.posts.PostViewModel

@Composable
fun ValidatePost(controller: NavHostController, viewModel: PostViewModel = hiltViewModel()) {
    when(val response = viewModel.response) {

        Response.Loading -> {
            MyProgressBar()
        }
        is Response.Success -> {
            PostComponent(controller = controller, posts = response.data, vm = viewModel)
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.exception?.message ?: "Error desconido", Toast.LENGTH_LONG).show()
        }
        else -> {}

    }




}
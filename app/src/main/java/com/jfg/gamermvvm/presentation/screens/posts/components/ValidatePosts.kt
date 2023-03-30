package com.jfg.gamermvvm.presentation.screens.posts.components

import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.presentation.screens.Composables.MyProgressBar
import com.jfg.gamermvvm.presentation.screens.posts.PostViewModel

@Composable
fun ValidatePost(viewModel: PostViewModel) {
    when(val response = viewModel.response) {

        Response.Loading -> {
            MyProgressBar()
        }
        is Response.Success -> {
            PostComponent(posts = response.data)
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.exception?.message ?: "Error desconido", Toast.LENGTH_LONG).show()
        }
        else -> {
            Toast.makeText(LocalContext.current, "Error null", Toast.LENGTH_LONG).show()

        }

    }




}
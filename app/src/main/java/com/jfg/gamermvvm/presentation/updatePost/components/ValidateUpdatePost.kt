package com.jfg.gamermvvm.presentation.updatePost.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.presentation.screens.Composables.MyProgressBar
import com.jfg.gamermvvm.presentation.updatePost.UpdatePostViewModel


@Composable
fun ValidateUpdatePost(viewModel: UpdatePostViewModel = hiltViewModel()) {
    when(val response = viewModel.updatePostResponse) {
        Response.Loading -> {
            MyProgressBar()
        }
        is Response.Success -> {
            viewModel.clearForm()
            Toast.makeText(LocalContext.current, "La publicacion Actualizada correctamente", Toast.LENGTH_LONG).show()
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.exception?.message ?: "Error desconido", Toast.LENGTH_LONG).show()
        }
        else -> {}

    }
}

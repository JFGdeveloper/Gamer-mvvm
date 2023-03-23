package com.jfg.gamermvvm.presentation.screens.profile_update.components

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
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.presentation.screens.Composables.MyProgressBar
import com.jfg.gamermvvm.presentation.screens.profile_update.ProfileUpdateViewModel

@Composable
fun ValidateUpdate(vm: ProfileUpdateViewModel = hiltViewModel()) {

    when(val response = vm.updateResponse){
        Response.Loading -> {
           MyProgressBar()
        }
        is Response.Success -> {
            Toast.makeText(LocalContext.current, "Usuario actualizado", Toast.LENGTH_LONG).show()

        }
        is Response.Failure -> {
        Toast.makeText(LocalContext.current, response.exception?.message ?: "Errror desconocido", Toast.LENGTH_LONG).show()
        }
        else -> {}
    }
}
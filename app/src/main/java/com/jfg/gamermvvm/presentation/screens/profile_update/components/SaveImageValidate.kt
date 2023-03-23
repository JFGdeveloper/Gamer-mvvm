package com.jfg.gamermvvm.presentation.screens.profile_update.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.presentation.screens.Composables.MyProgressBar
import com.jfg.gamermvvm.presentation.screens.profile_update.ProfileUpdateViewModel

@Composable
fun SaveImageValidate(vm: ProfileUpdateViewModel = hiltViewModel()) {
    when(val response = vm.saveImageResponse){

        Response.Loading-> {
            MyProgressBar()
        }
        is Response.Success -> {
            vm.onUpdateUser(response.data)
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, response.exception?.message ?: "ERROR DESCONOCIDO", Toast.LENGTH_SHORT).show()
        }
        else -> {}
    }
}
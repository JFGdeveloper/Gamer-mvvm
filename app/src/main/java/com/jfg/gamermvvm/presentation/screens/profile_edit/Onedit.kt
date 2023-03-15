package com.jfg.gamermvvm.presentation.screens.profile_edit

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.presentation.navigation.AppScreen
import com.jfg.gamermvvm.presentation.screens.Composables.MyProgressBar

@Composable
fun OnEdit(controller: NavHostController, vm: ProfileEditViewModel = hiltViewModel()) {
    when(val response = vm.response){
        Response.Loading ->{
            MyProgressBar()
        }
        is Response.Success ->{
            LaunchedEffect(Unit){
                controller.navigate(AppScreen.Profile.route){
                    popUpTo(AppScreen.ProfileEdit.route){
                        inclusive = true
                    }
                }
            }
        }
        is Response.Failure ->{
            Toast.makeText(LocalContext.current, response.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG).show()
        }
        else -> {}

    }

}
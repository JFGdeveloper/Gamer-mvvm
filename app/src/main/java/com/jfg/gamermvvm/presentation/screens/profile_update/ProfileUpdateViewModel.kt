package com.jfg.gamermvvm.presentation.screens.profile_update

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.model.User
import com.jfg.gamermvvm.domain.use_cases.user.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val userUseCases: UserUseCases,
    private val savedStateHandle: SavedStateHandle,
): ViewModel(){

    var state by mutableStateOf(ProfileUpdateState())
        private set

    var errorUsername by mutableStateOf("")
    private set


    // Parametro de la navegacion
    private val argument = savedStateHandle.get<String>("user")
    val user: User = User.fromJson(argument!!)

    var updateResponse by mutableStateOf<Response<Boolean>?>(null)
     private set

    var imageUri by mutableStateOf<Uri?>(null) // LA USO PARA LA GALERIA
    var hasImage by mutableStateOf(false) //LA USO PARA LA CAMRAR



    init {
        state = state.copy(username = user.username)
    }

    // CAMBIA EL VALOR DE VARIABLE
    fun onGalleryResult(uri: Uri?){
        hasImage = uri != null
        imageUri = uri
    }

    fun onCameraResult(result: Boolean){
        hasImage = result
    }

    // Le paso el valor del textfield
    fun onUpdateUser(){
        val myUser = User(
                id = user.id,
                username = state.username,
                image = ""
        )
        updateUser(myUser)
        Log.d("javi","ONUPDATE OK 2")
    }


    private fun updateUser(user: User) = viewModelScope.launch {
        updateResponse = Response.Loading
        val data: Response<Boolean> = userUseCases.update(user)
        updateResponse = data
        Log.d("javi","ONUPDATE OK 1")

    }


    fun onUsernameInput(username: String){
        state = state.copy(username = username)
    }




}
package com.jfg.gamermvvm.presentation.screens.profile_update

import android.content.Context
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
import com.jfg.gamermvvm.presentation.utils.ComposeFileProvider
import com.jfg.gamermvvm.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val userUseCases: UserUseCases,
    private val savedStateHandle: SavedStateHandle,
    @ApplicationContext private val context: Context
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

    var saveImageResponse by mutableStateOf<Response<String>?>(null)
     private set



    // OBJ DE LA CLASE UTILS
    val resultingActivityHandler = ResultingActivityHandler()

    private var file: File? = null




    init {
        Log.d("jf","valor recivido de profile image: ${user.image}")
        state = state.copy(username = user.username, image = user.image)
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null){
            file = ComposeFileProvider.createFileFromUri(context, result)
            Log.d("jf","valor de la imagen en pickImage() viewmodel: ${state.image}")
            state = state.copy(image = result.toString())
        }


    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            //state.image = ComposeFileProvider.getPathFromBitmap(context, result)
            file = File(state.image)
            Log.d("jf","valor de la imagen takephoto en viewmodel: ${state.image}")

        }

    }

    // Le paso el valor del textfield
    fun onUpdateUser(url: String){
        val myUser = User(
                id = user.id,
                username = state.username,
                image = url
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


    fun saveImage() = viewModelScope.launch {
        if (file != null){
            saveImageResponse = Response.Loading
            val result = userUseCases.saveImage(file!!)
            saveImageResponse = result
        }

    }




}
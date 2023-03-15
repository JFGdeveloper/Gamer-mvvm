package com.jfg.gamermvvm.presentation.screens.profile_edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.use_cases.auth.AuthUseCases
import com.jfg.gamermvvm.domain.use_cases.user.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val userUseCases: UserUseCases
): ViewModel(){

    var state by mutableStateOf(Profile_editState())
        private set

    // USERNAME
    var isUsernameValid by mutableStateOf(false)
    private set

    var errorUsername by mutableStateOf("")
    private set

    var response by mutableStateOf<Response<FirebaseUser>?>(null)
    private set


    fun onUsernameInput(username: String){
        state = state.copy(username = username)
    }



    fun onValidateUsername(){
        if (state.username.length >= 6){
            isUsernameValid = true
            errorUsername = ""

        }else{
            isUsernameValid = false
            errorUsername = "Minimo 6 caracteres"
        }
    }


}
package com.jfg.gamermvvm.presentation.screens.login

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    //EMAIL
    var email = mutableStateOf("")
    var isEmailValid = mutableStateOf(false)
    var errorEmail = mutableStateOf("")

    //PASS
    var pass = mutableStateOf("")
    var isPassValid = mutableStateOf(false)
    var errorPass = mutableStateOf("")

    //BUTTON
    var enableButton = false


    fun validateEmail(){
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()){
            isEmailValid.value = true
            errorEmail.value = ""
        }else{
            isEmailValid.value = false
            errorEmail.value = "Email no valido"
        }

        enableButton()
    }

    fun validatePassword(){
        if (pass.value.length >= 6){
            isPassValid.value = true
            errorPass.value = ""
        }else{
            isPassValid.value = false
            errorPass.value = "Minino 6 caracteres"
        }

        enableButton()
    }

    private fun enableButton(){
        enableButton = isEmailValid.value && isPassValid.value
    }
}
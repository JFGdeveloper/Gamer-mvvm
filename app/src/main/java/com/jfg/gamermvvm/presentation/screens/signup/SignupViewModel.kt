package com.jfg.gamermvvm.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.model.User
import com.jfg.gamermvvm.domain.use_cases.auth.AuthUseCases
import com.jfg.gamermvvm.domain.use_cases.user.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val userUseCases: UserUseCases
): ViewModel(){


    // USERNAME
    var username = mutableStateOf("")
    var isUsernameValid = mutableStateOf(false)
    var errorUsername = mutableStateOf("")

    //EMAIL
    var email = mutableStateOf("")
    var isEmailValid = mutableStateOf(false)
    var errorEmail = mutableStateOf("")

    //PASS
    var pass = mutableStateOf("")
    var isPassValid = mutableStateOf(false)
    var errorPass = mutableStateOf("")

    //CONFIRMPASS
    var confirmPass = mutableStateOf("")
    var isConfirmPassValid = mutableStateOf(false)
    var errorConfirmPass = mutableStateOf("")

    //BUTTON
    var enableButton = false

    private val _signupFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val signupFlow: StateFlow<Response<FirebaseUser>?> get() =  _signupFlow

    var user = User()


    fun onSignup(){
        user.username = username.value
        user.email = email.value
        user.password = pass.value
        signup(user)
    }

    // ME ASEGURO DE LLAMARLO CUANDO SE QUE LA RESPUESTA ES SUCCESS
    fun createUser() = viewModelScope.launch {
        user.id = authUseCases.getUser()!!.uid
        userUseCases.create(user)
    }



    private fun signup(user: User) = viewModelScope.launch{
        _signupFlow.value = Response.Loading
        val result = authUseCases.signup(user)
        _signupFlow.value = result
    }


    fun onValidateUsername(){
        if (username.value.length >= 6){
            isUsernameValid.value = true
            errorUsername.value = ""

        }else{
            isUsernameValid.value = false
            errorUsername.value = "Minimo 6 caracteres"
        }

        enableButton()
    }


    fun onValidateConfirmPassWord(){
        if (pass.value == confirmPass.value){
            isConfirmPassValid.value = true
            errorConfirmPass.value = ""

        }else{

            isConfirmPassValid.value = false
            errorConfirmPass.value = "La contaseña no coincide"
        }

        enableButton()
    }


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
        enableButton =
            isUsernameValid.value &&
            isEmailValid.value &&
            isPassValid.value &&
            isConfirmPassValid.value
    }
}
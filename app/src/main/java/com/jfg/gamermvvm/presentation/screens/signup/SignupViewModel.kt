package com.jfg.gamermvvm.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.model.User
import com.jfg.gamermvvm.domain.use_cases.auth.AuthUseCases
import com.jfg.gamermvvm.domain.use_cases.user.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val userUseCases: UserUseCases
): ViewModel(){

    var state by mutableStateOf(SignupState())
        private set

    // USERNAME
    var isUsernameValid by mutableStateOf(false)
    private set
    var errorUsername by mutableStateOf("")
    private set

    //EMAIL
    var isEmailValid by mutableStateOf(false)
    private set
    var errorEmail by mutableStateOf("")
    private set

    //PASS
    var isPassValid by mutableStateOf(false)
    private set
    var errorPass by mutableStateOf("")
    private set

    //CONFIRMPASS
    var isConfirmPassValid by mutableStateOf(false)
    private set
    var errorConfirmPass by mutableStateOf("")
    private set

    //BUTTON
    var enableButton = false

    var response by mutableStateOf<Response<FirebaseUser>?>(null)
    private set

    var user = User()

    fun onUsernameInput(username: String){
        state = state.copy(username = username)
    }
    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }
    fun onPasswordInput(pass: String){
        state = state.copy(password = pass)
    }
    fun oncConfirmPassInput(confirmPass: String){
        state = state.copy(confirmPass = confirmPass)
    }


    fun onSignup(){
        user.username = state.username
        user.email = state.email
        user.password = state.password
        signup(user)
    }

    // ME ASEGURO DE LLAMARLO CUANDO SE QUE LA RESPUESTA ES SUCCESS
    fun createUser() = viewModelScope.launch {
        user.id = authUseCases.getUser()!!.uid
        userUseCases.create(user)
    }



    private fun signup(user: User) = viewModelScope.launch{
        response = Response.Loading
        val result: Response<FirebaseUser> = authUseCases.signup(user)
        response = result
    }



    fun onValidateUsername(){
        if (state.username.length >= 6){
            isUsernameValid = true
            errorUsername = ""

        }else{
            isUsernameValid = false
            errorUsername = "Minimo 6 caracteres"
        }

        enableButton()
    }


    fun onValidateConfirmPassWord(){
        if (state.password == state.confirmPass){
            isConfirmPassValid = true
            errorConfirmPass = ""

        }else{

            isConfirmPassValid = false
            errorConfirmPass = "La contaseña no coincide"
        }

        enableButton()
    }


    fun validateEmail(){
        if (Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            isEmailValid = true
            errorEmail = ""
        }else{
            isEmailValid = false
            errorEmail = "Email no valido"
        }

        enableButton()
    }

    fun validatePassword(){
        if (state.password.length >= 6){
            isPassValid = true
            errorPass = ""
        }else{
            isPassValid = false
            errorPass = "Minino 6 caracteres"
        }

        enableButton()
    }

    private fun enableButton(){
        enableButton =
            isUsernameValid &&
            isEmailValid &&
            isPassValid &&
            isConfirmPassValid
    }
}
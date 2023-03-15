package com.jfg.gamermvvm.presentation.screens.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.use_cases.auth.AuthUseCases
import com.jfg.gamermvvm.domain.use_cases.auth.GetUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
): ViewModel() {

    //ESTADO DE LOS VALORES EN LOGIN
    var state by mutableStateOf(LoginState())
        private set


    //EMAIL
    var isEmailValid by mutableStateOf(false)
    var errorEmail by mutableStateOf("")

    //PASS
    var isPassValid by mutableStateOf(false)
    var errorPass by mutableStateOf("")

    //BUTTON
    var enableButton = false

/*  ALTERNATIVA AL DELEGADO
    private val _loginFlow= MutableStateFlow<Response<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Response<FirebaseUser>?> get() = _loginFlow
 */

    var loginResponse by mutableStateOf<Response<FirebaseUser>?>(null)
     private set

    // USER DE FIREBASE
    private var user: FirebaseUser? = authUseCases.getUser()

    init {
        if (user != null){
            loginResponse = Response.Success(user!!)
        }

    }



    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }

    fun onPassWordInput(pass: String){
        state = state.copy(password = pass)
    }

    fun onLogin() = viewModelScope.launch {
        loginResponse = Response.Loading
       val result = authUseCases.login.invoke(email = state.email, password = state.password)
        loginResponse = result
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
        enableButton = isEmailValid && isPassValid
    }
}
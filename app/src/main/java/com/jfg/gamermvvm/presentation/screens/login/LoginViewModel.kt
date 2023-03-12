package com.jfg.gamermvvm.presentation.screens.login

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
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

    private val _loginFlow= MutableStateFlow<Response<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Response<FirebaseUser>?> get() = _loginFlow

    // USER DE FIREBASE
    private var user: FirebaseUser? = authUseCases.getUser()

    init {
        if (user != null){
            _loginFlow.value = Response.Success(user!!)
        }
    }

    fun onLogin() = viewModelScope.launch {
        _loginFlow.value = Response.Loading
       val result = authUseCases.login.invoke(email = email.value, password = pass.value)
        _loginFlow.value = result
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
        enableButton = isEmailValid.value && isPassValid.value
    }
}
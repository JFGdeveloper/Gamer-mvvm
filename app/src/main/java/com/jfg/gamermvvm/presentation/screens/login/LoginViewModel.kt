package com.jfg.gamermvvm.presentation.screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    var email = mutableStateOf("")
    var pass = mutableStateOf("")
}
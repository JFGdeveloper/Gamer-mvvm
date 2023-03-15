package com.jfg.gamermvvm.presentation.screens.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.auth.User
import com.jfg.gamermvvm.domain.use_cases.auth.AuthUseCases
import com.jfg.gamermvvm.domain.use_cases.user.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCases: UserUseCases,
    private val authUseCases: AuthUseCases
): ViewModel() {

    var userData by mutableStateOf(com.jfg.gamermvvm.domain.model.User())
        private set

    val currentUser = authUseCases.getUser()

    init {
        getUserById()
    }

    fun getUserById()= viewModelScope.launch {
        useCases.getUserById(currentUser!!.uid).collect(){
            userData = it
        }
    }

    fun onLogout(){
        authUseCases.logout()
    }
}
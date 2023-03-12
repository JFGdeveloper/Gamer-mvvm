package com.jfg.gamermvvm.presentation.screens.profile

import androidx.lifecycle.ViewModel
import com.jfg.gamermvvm.domain.use_cases.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCases: AuthUseCases
): ViewModel() {

    fun onLogout(){
        useCases.logout()
    }
}
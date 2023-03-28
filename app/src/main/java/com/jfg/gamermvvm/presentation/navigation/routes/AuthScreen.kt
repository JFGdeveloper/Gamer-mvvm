package com.jfg.gamermvvm.presentation.navigation.routes

sealed class AuthScreen (val route: String){
    object Login: AuthScreen("login")
    object Signup: AuthScreen("signup")





}
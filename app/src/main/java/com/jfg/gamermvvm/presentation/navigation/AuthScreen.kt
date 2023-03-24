package com.jfg.gamermvvm.presentation.navigation

sealed class AuthScreen (val route: String){
    object Login: AuthScreen("login")
    object Signup: AuthScreen("signup")


    object Profile: AuthScreen("profile")
    object ProfileUpdate: AuthScreen("profile/edit/{user}"){
        fun sendUser(user:String)= "profile/edit/$user"
    }

}
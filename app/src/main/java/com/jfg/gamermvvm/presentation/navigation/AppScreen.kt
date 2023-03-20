package com.jfg.gamermvvm.presentation.navigation

sealed class AppScreen (val route: String){
    object Login: AppScreen("login")
    object Signup: AppScreen("signup")
    object Profile: AppScreen("profile")
    object ProfileUpdate: AppScreen("profile/edit/{user}"){
        fun sendUser(user:String)= "profile/edit/$user"
    }
}
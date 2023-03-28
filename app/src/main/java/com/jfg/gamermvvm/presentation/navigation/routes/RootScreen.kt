package com.jfg.gamermvvm.presentation.navigation.routes

sealed class RootScreen(val route: String){
    object Home: RootScreen("home")
}

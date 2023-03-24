package com.jfg.gamermvvm.presentation.navigation

sealed class RootScreen(val route: String){
    object Home: RootScreen("home")
}

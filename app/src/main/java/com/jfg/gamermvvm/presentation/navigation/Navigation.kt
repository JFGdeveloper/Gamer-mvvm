package com.jfg.gamermvvm.presentation.navigation

import androidx.annotation.NavigationRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jfg.gamermvvm.presentation.screens.login.LoginScreen
import com.jfg.gamermvvm.presentation.screens.login.LoginViewModel
import com.jfg.gamermvvm.presentation.screens.signup.SignupScreen

@Composable
fun Navigation(controller: NavHostController) {

    NavHost(navController = controller, startDestination = AppScreen.Login.route){

        composable(AppScreen.Login.route){
            LoginScreen(controller)
        }

        composable(AppScreen.Signup.route){
            SignupScreen(controller)
        }
    }

}
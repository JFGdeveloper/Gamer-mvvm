package com.jfg.gamermvvm.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jfg.gamermvvm.presentation.screens.login.LoginScreen
import com.jfg.gamermvvm.presentation.screens.profile.ProfileScreen
import com.jfg.gamermvvm.presentation.screens.profile_edit.ProfileEditScreen
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

        composable(AppScreen.Profile.route){
            ProfileScreen(controller)
        }

        composable(AppScreen.ProfileEdit.route){
            ProfileEditScreen(controller)
        }
    }

}
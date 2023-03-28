package com.jfg.gamermvvm.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jfg.gamermvvm.presentation.navigation.routes.AuthScreen
import com.jfg.gamermvvm.presentation.navigation.routes.Graph
import com.jfg.gamermvvm.presentation.screens.login.LoginScreen
import com.jfg.gamermvvm.presentation.screens.signup.SignupScreen



fun NavGraphBuilder.authNavGraph(controller: NavHostController){

    navigation(
            route = Graph.AUTHENTICATION,
            startDestination = AuthScreen.Login.route,
    ){

        composable(AuthScreen.Login.route){
            LoginScreen(controller)
        }

        composable(AuthScreen.Signup.route){
            SignupScreen(controller)
        }

    }
}
package com.jfg.gamermvvm.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jfg.gamermvvm.presentation.navigation.routes.AuthScreen
import com.jfg.gamermvvm.presentation.navigation.routes.Graph
import com.jfg.gamermvvm.presentation.navigation.routes.RootScreen
import com.jfg.gamermvvm.presentation.screens.home.HomeScreen
import com.jfg.gamermvvm.presentation.screens.profile_update.ProfileUpdateScreen


// GRAPH PRINCIPAL
@Composable
fun RootNavGraph(controller: NavHostController) {

    NavHost(
            navController = controller,
            route = Graph.ROOT,
            startDestination = Graph.AUTHENTICATION
    ){

        authNavGraph(controller)

        composable(Graph.HOME){
           HomeScreen()
        }

    }

}
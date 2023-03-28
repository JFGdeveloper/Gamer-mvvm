package com.jfg.gamermvvm.presentation.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.jfg.gamermvvm.presentation.navigation.routes.AuthScreen
import com.jfg.gamermvvm.presentation.navigation.routes.DetailScreen
import com.jfg.gamermvvm.presentation.navigation.routes.Graph
import com.jfg.gamermvvm.presentation.screens.profile_update.ProfileUpdateScreen

fun NavGraphBuilder.detailsNavGraph(controller: NavHostController){

    navigation(
            route = Graph.DETAILS,
            startDestination = DetailScreen.ProfileUpdate.route
    ){
        composable(
                DetailScreen.ProfileUpdate.route,
                arguments = listOf(navArgument("user"){
                    type = NavType.StringType
                })
        ){
            it.arguments?.getString("user")?.let {
                ProfileUpdateScreen(controller, user = it)
            }

        }

    }
}
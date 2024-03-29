package com.jfg.gamermvvm.presentation.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.jfg.gamermvvm.presentation.navigation.routes.DetailScreen
import com.jfg.gamermvvm.presentation.navigation.routes.Graph
import com.jfg.gamermvvm.presentation.screens.detailsPost.DetailsPostScreen
import com.jfg.gamermvvm.presentation.screens.new_post.NewPostScreen
import com.jfg.gamermvvm.presentation.screens.profile_update.ProfileUpdateScreen
import com.jfg.gamermvvm.presentation.updatePost.UpdatePostScreen

fun NavGraphBuilder.detailsNavGraph(controller: NavHostController){

    navigation(
            route = Graph.DETAILS,
            startDestination = DetailScreen.ProfileUpdate.route
    ){

        composable(DetailScreen.NewPost.route){
            NewPostScreen(controller)
        }

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

        composable(DetailScreen.DetailPost.route,
                   arguments = listOf(navArgument("post"){
                       type = NavType.StringType
                   })
       ){
            it.arguments?.getString("post")?.let { post ->
                DetailsPostScreen(controller,post = post)
            }
        }

        composable(DetailScreen.UpdatePost.route,
                   arguments = listOf(navArgument("post"){
                       type = NavType.StringType
                   })
       ){
            it.arguments?.getString("post")?.let { post ->
                UpdatePostScreen(controller,post)
            }
        }

    }
}
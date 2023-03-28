package com.jfg.gamermvvm.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jfg.gamermvvm.presentation.navigation.routes.Graph
import com.jfg.gamermvvm.presentation.navigation.routes.HomeBottomBarScreen
import com.jfg.gamermvvm.presentation.screens.my_posts.MyPostsScreen
import com.jfg.gamermvvm.presentation.screens.posts.PostsScreen
import com.jfg.gamermvvm.presentation.screens.profile.ProfileScreen

@Composable
fun HomeNavGraph(controller: NavHostController){
    NavHost(
            navController = controller,
            route = Graph.HOME,
            startDestination = HomeBottomBarScreen.Posts.route
    ){

        composable(HomeBottomBarScreen.Profile.route){
            ProfileScreen(controller)
        }


        composable(HomeBottomBarScreen.Posts.route){
            PostsScreen(controller)
        }

        composable(HomeBottomBarScreen.MyPost.route){
            MyPostsScreen(controller)
        }

        detailsNavGraph( controller)

    }
}
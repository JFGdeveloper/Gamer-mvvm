package com.jfg.gamermvvm.presentation.navigation.routes

sealed class DetailScreen(val route: String){

    object NewPost: DetailScreen("posts/new")
    object ProfileUpdate: DetailScreen("profile/edit/{user}"){
        fun sendUser(user:String)= "profile/edit/$user"
    }
}

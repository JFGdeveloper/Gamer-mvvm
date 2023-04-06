package com.jfg.gamermvvm.presentation.screens.posts

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.presentation.screens.posts.components.ValidateMyPost
import com.jfg.gamermvvm.presentation.screens.posts.components.ValidatePost

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PostsScreen(controller: NavHostController, vm: PostViewModel = hiltViewModel()) {

    Scaffold(
            content = {
                ValidatePost(controller = controller)

            }
    )
}
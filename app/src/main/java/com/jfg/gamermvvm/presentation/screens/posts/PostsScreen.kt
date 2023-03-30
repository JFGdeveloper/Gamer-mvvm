package com.jfg.gamermvvm.presentation.screens.posts

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.presentation.screens.posts.components.PostComponent
import com.jfg.gamermvvm.presentation.screens.posts.components.ValidatePost

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PostsScreen(controller: NavHostController, vm: PostViewModel = hiltViewModel()) {

    Scaffold(
            content = {
                ValidatePost(viewModel = vm)

            }
    )
}
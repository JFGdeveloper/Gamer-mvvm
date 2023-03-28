package com.jfg.gamermvvm.presentation.screens.my_posts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.presentation.navigation.routes.DetailScreen
import com.jfg.gamermvvm.presentation.screens.new_post.NewPostScreen

@Composable
fun MyPostsScreen(controller: NavHostController) {
    Scaffold(
            content = {
                Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        contentAlignment = Alignment.Center
                ){
                    Text(text = "Mis  Posts")
                }

            },
            floatingActionButton = {
                FloatingActionButton(
                        modifier = Modifier.padding(bottom = 50.dp),
                        onClick = {
                    controller.navigate(DetailScreen.NewPost.route)
                }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            },
            floatingActionButtonPosition = FabPosition.Center,

    )
}
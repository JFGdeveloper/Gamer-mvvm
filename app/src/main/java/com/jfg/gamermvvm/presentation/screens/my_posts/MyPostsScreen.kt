package com.jfg.gamermvvm.presentation.screens.my_posts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun MyPostsScreen(controller: NavHostController) {
    Scaffold(
            content = {
                Box(
                        modifier = Modifier.fillMaxSize()
                            .padding(it),
                        contentAlignment = Alignment.Center
                ){
                    Text(text = "Mis  Posts")
                }

            }
    )
}
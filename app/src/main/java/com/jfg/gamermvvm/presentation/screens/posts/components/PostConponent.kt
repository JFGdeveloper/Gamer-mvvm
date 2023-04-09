package com.jfg.gamermvvm.presentation.screens.posts.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.domain.model.Post
import com.jfg.gamermvvm.presentation.screens.posts.PostViewModel

@Composable
fun PostComponent(controller: NavHostController, posts: List<Post>,vm: PostViewModel) {

    LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 55.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
    ){
        items(posts){ post ->
           PostCard(controller = controller, post = post, viewModel = vm)
        }
    }

}
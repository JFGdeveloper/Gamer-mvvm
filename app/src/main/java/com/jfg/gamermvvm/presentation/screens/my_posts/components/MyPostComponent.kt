package com.jfg.gamermvvm.presentation.screens.posts.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
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
import com.jfg.gamermvvm.presentation.screens.my_posts.MyPostViewModel
import com.jfg.gamermvvm.presentation.screens.posts.PostViewModel

@Composable
fun MyPostComponent(controller: NavHostController, posts: List<Post>,vm: MyPostViewModel) {

    LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(bottom = 55.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
    ){
        items(posts){ post ->
           MyPostCard(controller = controller, post = post,vm)
        }
    }

}
package com.jfg.gamermvvm.presentation.screens.posts.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jfg.gamermvvm.domain.model.Post

@Composable
fun PostComponent(posts: List<Post>) {

    LazyColumn(
            modifier = Modifier.fillMaxWidth().padding(top = 12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
    ){
        items(posts){
            Text(text = it.name)
        }
    }

}
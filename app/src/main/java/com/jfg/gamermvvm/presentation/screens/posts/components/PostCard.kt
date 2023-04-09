package com.jfg.gamermvvm.presentation.screens.posts.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.jfg.gamermvvm.domain.model.Post
import com.jfg.gamermvvm.R
import com.jfg.gamermvvm.presentation.navigation.routes.DetailScreen
import com.jfg.gamermvvm.presentation.screens.posts.PostViewModel

@Composable
fun PostCard(controller: NavHostController, post: Post,viewModel: PostViewModel) {
    Card(
            modifier = Modifier
                .padding(4.dp)
                .clickable {
                    controller.navigate(DetailScreen.DetailPost.sendPost(post = post.toJson()))
                },
            border = BorderStroke(1.dp,Color.Blue),
            shape = RoundedCornerShape(8),
            elevation = 4.dp,

            ) {

        Column() {

            AsyncImage(
                    model = post.image,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp),
                    contentScale = ContentScale.Crop
            )

            Text(
                    text = post.name,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 2.dp),
                    fontWeight = FontWeight.Bold
            )
            Text(
                    text = post.user?.username ?: "nulo",
                    fontSize = 13.sp,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 2.dp)
            )
            Text(
                    text = post.description,
                    fontSize = 13.sp,
                    color = Color.Gray,
                    maxLines = 2,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)
            )
            
            Row(
                    modifier = Modifier.fillMaxWidth().padding(start = 18.dp, top = 3.dp, bottom = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
            ) {

                if (post.likes.contains(viewModel.currentUser?.uid)){
                    IconButton(
                            modifier = Modifier.size(24.dp),
                            onClick = { viewModel.deleteLike(post.id,viewModel.currentUser?.uid ?: "") }
                    ) {
                        Icon(painter = painterResource(id = R.drawable.ic_like), contentDescription = null)
                    }

                }else{
                    IconButton(
                            modifier = Modifier.size(24.dp),
                            onClick = { viewModel.like(post.id,viewModel.currentUser?.uid ?: "") }
                    ) {
                        Icon(painter = painterResource(id = R.drawable.ic_like_outline), contentDescription = null)
                    }

                }


                Text(text = post.likes.size.toString())
            }

        }


    }
}

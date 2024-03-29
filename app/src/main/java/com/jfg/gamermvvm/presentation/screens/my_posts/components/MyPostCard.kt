package com.jfg.gamermvvm.presentation.screens.posts.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.jfg.gamermvvm.domain.model.Post
import com.jfg.gamermvvm.presentation.navigation.routes.DetailScreen
import com.jfg.gamermvvm.presentation.screens.my_posts.MyPostViewModel
import com.jfg.gamermvvm.presentation.screens.posts.PostViewModel

@Composable
fun MyPostCard(controller: NavHostController, post: Post,vm: MyPostViewModel) {
    Card(
            modifier = Modifier
                .padding(4.dp),
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
                        .height(170.dp)
                        .clickable {
                            controller.navigate(DetailScreen.DetailPost.sendPost(post = post.toJson()))
                        },
                    contentScale = ContentScale.Crop
            )

            Text(
                    text = post.name,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 2.dp),
                    fontWeight = FontWeight.Bold
            )

            Text(
                    text = post.description,
                    fontSize = 13.sp,
                    color = Color.Gray,
                    maxLines = 2,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)
            )

            Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
            ) {

                IconButton(onClick = {
                    controller.navigate(DetailScreen.UpdatePost.sendPost(post.toJson()))
                }) {
                    Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(25.dp)
                    )
                }

                IconButton(onClick = { vm.delete(post.id) }) {
                    Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(25.dp)
                    )
                }



            }



        }


    }
}

package com.jfg.gamermvvm.presentation.screens.detailsPost.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.jfg.gamermvvm.R
import com.jfg.gamermvvm.presentation.screens.detailsPost.DetailPostViewModel

@Composable
fun DetailsPostContent(controller: NavHostController, vm: DetailPostViewModel = hiltViewModel()) {
    Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
    ) {
        Box() {

            AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    model = vm.post.image,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
            )

            IconButton(onClick = { controller.popBackStack() }) {
                Icon(
                        modifier = Modifier.size(35.dp),
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = Color.White
                )
            }

        }

        if (!vm.post.user?.username.isNullOrBlank()){
            Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 8.dp)
                        .fillMaxWidth()
                        .height(80.dp),
                    elevation = 8.dp
            ) {

                Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                            model = vm.post.user?.image ?: "",
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(text = vm.post.user?.username ?: "Name?", fontSize = 17.sp)
                        Text(text = vm.post.user?.email ?: "Email?", fontSize = 12.sp)
                    }
                }

            }// card del usuario
        }else{
            Spacer(modifier = Modifier.height(12.dp))
        }


        Text(
                text = vm.post.name,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 20.dp, top = 8.dp, bottom = 8.dp)
        )
        Card(
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .height(30.dp)
                    .width(150.dp)
                    .padding(start = 20.dp),
                contentColor = Color.White
        ) {
            Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.background(Color.Red)
            ) {
                Image(
                        painter = painterResource(
                                id = if (vm.post.category == "PC") R.drawable.icon_pc
                                else if (vm.post.category == "XBOX") R.drawable.icon_xbox
                                else if (vm.post.category == "PS4") R.drawable.icon_ps4
                                else if (vm.post.category == "NINTENDO") R.drawable.icon_nintendo
                                else R.drawable.icon_pc
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = "Ps4")

            }
        }// card del icon y nombre del juego

        Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 8.dp)
        )

        Text(
                text = "Description",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp, bottom = 12.dp)
        )
        Text(
                text = vm.post.description,
                fontSize = 15.sp,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
        )
    }
}

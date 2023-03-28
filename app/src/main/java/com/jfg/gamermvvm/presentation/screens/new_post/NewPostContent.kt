package com.jfg.gamermvvm.presentation.screens.new_post

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.jfg.gamermvvm.R
import com.jfg.gamermvvm.presentation.navigation.routes.DetailScreen
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultOutlineTextField
import com.jfg.gamermvvm.presentation.screens.Composables.DialogCapturePicture
import com.jfg.gamermvvm.presentation.ui.theme.Red500




@Composable
fun NewPostContent(vm: NewPostViewModel) {

    vm.resultingActivityHandler.handle()
    val stateDialog = remember { mutableStateOf(false) }

    DialogCapturePicture(
            state = stateDialog ,
            takePhoto = { vm.takePhoto() },
            pickerImage = { vm.pickImage()}
    )

    Box(modifier = Modifier
        .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ){

        Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
        ) {
            Box(
                    modifier = Modifier
                        .height(170.dp)
                        .background(Color.Red)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
            ){
                Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = CenterHorizontally
                ) {

                    if(vm.state.image != "" ){

                        AsyncImage(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .clickable { stateDialog.value = true },
                                contentScale= ContentScale.FillWidth,
                                model = vm.state.image,
                                contentDescription = "imagen perfil"
                        )

                    }else{

                        Image(
                                modifier = Modifier
                                    .height(100.dp)
                                    .clickable {
                                        // imagePiker.launch("image/*")
                                        //vm.pickImage()
                                        //vm.takePhoto()
                                        stateDialog.value = true
                                    },
                                painter = painterResource(id = R.drawable.add_image),
                                contentDescription = "control de xbox image"
                        )

                        Text(
                                text = "Selecciona una imagen",
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold

                        )

                    }


                }

            }

            DefaultOutlineTextField(
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 8.dp)
                        .fillMaxWidth(),
                    value = vm.state.name,
                    onValueChange = { vm.onNameInput(it)},
                    label = "Nombre del juego",
                    leadingIcon = Icons.Default.Face,
                    keyBoard = KeyboardType.Text,
                    errorMsg = "",
                    onValidateText = {}
            )

            DefaultOutlineTextField(
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    value = vm.state.description,
                    onValueChange = { vm.onDescriptionInput(it)},
                    leadingIcon = Icons.Default.List,
                    hideText = true,
                    label = "Description",
                    keyBoard = KeyboardType.Text,
                    errorMsg = "",
                    onValidateText = {}
            )

            Text(
                    text = "Categorias",
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .align(CenterHorizontally),
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
            )

            vm.radioOptions.forEach{ it ->
                Row(
                   verticalAlignment = CenterVertically
                ) {
                    RadioButton(
                            selected = it.category == vm.state.category,
                            onClick = {vm.onCategoryInput(it.category) }
                    )
                    Row(verticalAlignment = CenterVertically) {
                        Text(text = it.category, modifier = Modifier.width(100.dp))
                        Image(
                                painterResource(id = it.image),
                                contentDescription = null,
                                modifier = Modifier.height(40.dp)
                        )

                    }

                }
            }

        }

    }
}


@Preview
@Composable
fun PrevNewPost() {
    NewPostScreen(controller = rememberNavController())
}
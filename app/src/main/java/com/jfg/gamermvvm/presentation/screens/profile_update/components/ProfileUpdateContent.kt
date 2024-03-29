package com.jfg.gamermvvm.presentation.screens.profile_update.components

import android.app.Instrumentation.ActivityResult
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.jfg.gamermvvm.R
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultButton
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultOutlineTextField
import com.jfg.gamermvvm.presentation.screens.Composables.DialogCapturePicture
import com.jfg.gamermvvm.presentation.screens.profile_update.ProfileUpdateViewModel
import com.jfg.gamermvvm.presentation.ui.theme.DarkGray500
import com.jfg.gamermvvm.presentation.ui.theme.Red500
import com.jfg.gamermvvm.presentation.utils.ComposeFileProvider


@Composable
fun ProfileUpdateContent(
    paddingValues: PaddingValues,
    vm: ProfileUpdateViewModel = hiltViewModel(),
) {
    val state = vm.state
    vm.resultingActivityHandler.handle()
    val stateDialog = remember { mutableStateOf(false) }

    DialogCapturePicture(
            state = stateDialog ,
            takePhoto = { vm.takePhoto() },
            pickerImage = { vm.pickImage()}
    )

    Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
    ) {

        // BOX DEL BACKGROUND
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .background(Red500),
            contentAlignment = Alignment.TopCenter
        ){
            Column(modifier = Modifier.padding(top = 20.dp)) {

                if(vm.state.image != "" ){
                    Log.d("javi", "Profileupdatecontent image: ${vm.state.image}")

                    AsyncImage(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(100.dp)
                                .clickable { stateDialog.value = true },
                            contentScale= ContentScale.Crop,
                            model = vm.state.image,
                            contentDescription = "imagen perfil"
                    )

                }else{
                    Log.d("javi", "image: ${vm.state.image}")

                    Image(
                            modifier = Modifier
                                .height(100.dp)
                                .clickable {
                                    // imagePiker.launch("image/*")
                                    //vm.pickImage()
                                    //vm.takePhoto()
                                   stateDialog.value = true
                                },
                            painter = painterResource(id = R.drawable.user),
                            contentDescription = "control de xbox image"
                    )

                }
            }

        }

        // FORMULARIO
        Card(modifier = Modifier.padding(top = 130.dp, start = 40.dp, end = 40.dp), backgroundColor = DarkGray500, shape = RoundedCornerShape(8.dp)) {

            Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {

                Text(
                        modifier = Modifier.padding(top = 25.dp, bottom = 10.dp),
                        text = "Actualizar",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                )
                Text(
                        text = "Por favor rellena estos datos para continuar",
                        color = Color.Gray,
                        fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(8.dp))

                DefaultOutlineTextField(
                        modifier = Modifier
                            .padding(vertical = 3.dp)
                            .fillMaxWidth(),
                        value = state.username,
                        onValueChange = {vm.onUsernameInput(it)},
                        label = "Nombre de usuario",
                        leadingIcon = Icons.Default.Person,
                        keyBoard = KeyboardType.Text,
                        errorMsg = vm.errorUsername,
                        onValidateText = {}
                )


                DefaultButton(
                        text = "Actualizar",
                        icon = Icons.Default.ArrowForward,
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 45.dp)
                            .fillMaxWidth(),
                        onclick = {
                            vm.saveImage()
                        }

                )

            }

        }

    }

}




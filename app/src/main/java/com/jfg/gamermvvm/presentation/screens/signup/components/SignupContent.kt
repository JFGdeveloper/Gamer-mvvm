package com.jfg.gamermvvm.presentation.screens.signup.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.R
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.presentation.navigation.AppScreen
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultButton
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultOutlineTextField
import com.jfg.gamermvvm.presentation.screens.signup.SignupViewModel
import com.jfg.gamermvvm.presentation.ui.theme.DarkGray500
import com.jfg.gamermvvm.presentation.ui.theme.Red500


@Composable
fun SignupContent(
    paddingValues: PaddingValues,
    vm: SignupViewModel = hiltViewModel(),
    controller: NavHostController,
) {
    val signupFlow = vm.signupFlow.collectAsState()


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
                Image(
                        modifier = Modifier.height(100.dp),
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = "control de xbox image"
                )
            }

        }

        // FORMULARIO
        Card(modifier = Modifier.padding(top = 130.dp, start = 40.dp, end = 40.dp), backgroundColor = DarkGray500, shape = RoundedCornerShape(8.dp)) {

            Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {

                Text(
                        modifier = Modifier.padding(top = 25.dp, bottom = 10.dp),
                        text = "Registro",
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
                        value = vm.username.value,
                        onValueChange = {vm.username.value = it},
                        label = "Nombre de usuario",
                        leadingIcon = Icons.Default.Person,
                        keyBoard = KeyboardType.Text,
                        errorMsg = vm.errorUsername.value,
                        onValidateText = {vm.onValidateUsername()}
                )

                DefaultOutlineTextField(
                        modifier = Modifier
                            .padding(vertical = 3.dp)
                            .fillMaxWidth(),
                        value = vm.email.value,
                        onValueChange = {vm.email.value = it},
                        label = "Email",
                        leadingIcon = Icons.Default.Email,
                        keyBoard = KeyboardType.Email,
                        errorMsg = vm.errorEmail.value,
                        onValidateText = {vm.validateEmail()}
                )

                DefaultOutlineTextField(
                        modifier = Modifier
                            .padding(vertical = 3.dp)
                            .fillMaxWidth(),
                        value = vm.pass.value,
                        onValueChange = {vm.pass.value = it},
                        label = "Password",
                        leadingIcon = Icons.Default.Lock,
                        keyBoard = KeyboardType.Password,
                        errorMsg = vm.errorPass.value,
                        onValidateText = { vm.validatePassword()}
                )

                DefaultOutlineTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = vm.confirmPass.value,
                        onValueChange = { vm.confirmPass.value = it},
                        leadingIcon = Icons.Outlined.Lock,
                        hideText = true,
                        label = "Confirmar Password",
                        keyBoard = KeyboardType.Password,
                        errorMsg = vm.errorConfirmPass.value,
                        onValidateText = {vm.onValidateConfirmPassWord()}
                )

                DefaultButton(
                        text = "Incicia sesión",
                        icon = Icons.Default.ArrowForward,
                        modifier = Modifier
                            .padding(top = 8.dp, bottom = 5.dp)
                            .fillMaxWidth(),
                        enableButton = vm.enableButton
                ) {
                    vm.onSignup()
                }


            }


        }

    }


    signupFlow.value.let {
        when(it){
            Response.Loading ->{
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    CircularProgressIndicator()
                }
            }
            is Response.Success ->{
                LaunchedEffect(Unit){
                    vm.createUser()
                    controller.navigate(AppScreen.Profile.route){
                        popUpTo(AppScreen.Signup.route){
                            inclusive = true
                        }
                    }
                }
            }
            is Response.Failure ->{
                Toast.makeText(LocalContext.current, it.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG).show()
            }
            else -> {}

        }
    }


}




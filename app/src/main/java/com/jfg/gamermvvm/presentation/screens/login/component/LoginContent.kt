package com.jfg.gamermvvm.presentation.screens.login.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jfg.gamermvvm.R
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultButton
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultOutlineTextField
import com.jfg.gamermvvm.presentation.screens.login.LoginScreen
import com.jfg.gamermvvm.presentation.screens.login.LoginViewModel
import com.jfg.gamermvvm.presentation.ui.theme.DarkGray500
import com.jfg.gamermvvm.presentation.ui.theme.GamerMvvmTheme
import com.jfg.gamermvvm.presentation.ui.theme.Red500


@Composable
fun LoginContent(paddingValues: PaddingValues,vm: LoginViewModel = LoginViewModel()) {
    Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
    ) {

        BoxHeader()

        CardForm(vm)

    }

}

@Composable
fun BoxHeader() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(280.dp)
        .background(Red500),
        contentAlignment = Alignment.TopCenter
    ){
        Column(modifier = Modifier.padding(top = 20.dp)) {
            Image(
                    modifier = Modifier.height(130.dp),
                    painter = painterResource(id = R.drawable.control),
                    contentDescription = "control de xbox image"
            )
            Text(text = "Firebase mvvm")
        }

    }
}


@Composable
fun CardForm(vm: LoginViewModel) {

    Card(modifier = Modifier.padding(top = 220.dp, start = 40.dp, end = 40.dp), backgroundColor = DarkGray500, shape = RoundedCornerShape(8.dp)) {

        Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {

            Text(
                    modifier = Modifier.padding(top = 25.dp, bottom = 10.dp),
                    text = "Login",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
            )
            Text(
                    text = "Por favor inicia sesion para continuar",
                    color = Color.Gray,
                    fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(10.dp))

            DefaultOutlineTextField(
                    modifier = Modifier.padding(vertical = 10.dp).fillMaxWidth(),
                    value = vm.email.value,
                    onValueChange = {vm.email.value = it},
                    label = "Email",
                    leadingIcon = Icons.Default.Email,
                    keyBoard = KeyboardType.Email,
                    errorMsg = vm.errorEmail.value,
                    onValidateText = {vm.validateEmail()}
            )

            DefaultOutlineTextField(
                    modifier= Modifier.fillMaxWidth(),
                    value = vm.pass.value,
                    onValueChange = { vm.pass.value = it},
                    leadingIcon = Icons.Default.Lock,
                    hideText = true,
                    label = "Password",
                    keyBoard = KeyboardType.Password,
                    errorMsg = vm.errorPass.value,
                    onValidateText = {vm.validatePassword()}
            )

            DefaultButton(
                    text = "Incicia sesión aqui",
                    icon = Icons.Default.ArrowForward,
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .fillMaxWidth(),
                    enableButton = vm.enableButton

            ) {

            }


        }


    }


}



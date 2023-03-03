package com.jfg.gamermvvm.presentation.screens.signup.components

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jfg.gamermvvm.R
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultButton
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultOutlineTextField
import com.jfg.gamermvvm.presentation.ui.theme.DarkGray500
import com.jfg.gamermvvm.presentation.ui.theme.GamerMvvmTheme
import com.jfg.gamermvvm.presentation.ui.theme.Red500


@Composable
fun SignupContent(paddingValues: PaddingValues) {
    Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
    ) {

        BoxHeaderSignup()

        CardFormSignup()

    }

}

@Composable
fun BoxHeaderSignup() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(250.dp)
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
}


@Composable
fun CardFormSignup() {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var confirmPass by remember { mutableStateOf("") }

    Card(modifier = Modifier.padding(top = 150.dp, start = 40.dp, end = 40.dp), backgroundColor = DarkGray500, shape = RoundedCornerShape(8.dp)) {

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
            Spacer(modifier = Modifier.height(10.dp))

            DefaultOutlineTextField(
                    modifier = Modifier.padding(vertical = 10.dp).fillMaxWidth(),
                    value = name,
                    onValueChange = {name = it},
                    label = "Nombre de usuario",
                    leadingIcon = Icons.Default.Person,
                    keyBoard = KeyboardType.Text
            )

            DefaultOutlineTextField(
                    modifier = Modifier.padding(vertical = 10.dp).fillMaxWidth(),
                    value = email,
                    onValueChange = {email = it},
                    label = "Email",
                    leadingIcon = Icons.Default.Email,
                    keyBoard = KeyboardType.Email
            )

            DefaultOutlineTextField(
                    modifier = Modifier.padding(vertical = 10.dp).fillMaxWidth(),
                    value = pass,
                    onValueChange = {pass = it},
                    label = "Password",
                    leadingIcon = Icons.Default.Lock,
                    keyBoard = KeyboardType.Password
            )

            DefaultOutlineTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = confirmPass,
                    onValueChange = { confirmPass = it},
                    leadingIcon = Icons.Outlined.Lock,
                    hideText = true,
                    label = "Confirmar Password",
                    keyBoard = KeyboardType.Password
            )

            DefaultButton(
                    text = "Incicia sesión",
                    icon = Icons.Default.ArrowForward,
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .fillMaxWidth()
            ) {
               // TODO
            }


        }


    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewContent() {
    GamerMvvmTheme(darkTheme = true) {
    // A surface container using the 'background' color from the theme
    Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
    ) {
        SignupContent(paddingValues = PaddingValues())

    }
}


}
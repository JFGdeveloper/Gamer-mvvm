package com.jfg.gamermvvm.screens.login.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jfg.gamermvvm.R
import com.jfg.gamermvvm.screens.login.LoginScreen
import com.jfg.gamermvvm.ui.theme.DarkGray500
import com.jfg.gamermvvm.ui.theme.GamerMvvmTheme
import com.jfg.gamermvvm.ui.theme.Red500


@Composable
fun LoginContent(paddingValues: PaddingValues) {
    Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
    ) {

        BoxHeader()

        CardForm()

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
fun CardForm() {

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
            OutlinedTextField(
                    modifier = Modifier.padding(vertical = 10.dp),
                    value = "",
                    onValueChange = {},
                    placeholder = { Text(text = "Correo electronico") },
                    leadingIcon = {
                       Icon(imageVector = Icons.Default.ArrowForward , contentDescription = null)
                    }
            )
            OutlinedTextField(
                    modifier = Modifier.padding(vertical = 10.dp),
                    value = "",
                    onValueChange = {},
                    placeholder = { Text(text = "Correo electronico") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Lock , contentDescription = null)
                    }
            )
            Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 40.dp),
                    onClick = { /*TODO*/ }
            ) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
                Text(modifier = Modifier.padding(start = 3.dp), text = "Incio de sesión")
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
        LoginContent(paddingValues = PaddingValues())

    }
}


}
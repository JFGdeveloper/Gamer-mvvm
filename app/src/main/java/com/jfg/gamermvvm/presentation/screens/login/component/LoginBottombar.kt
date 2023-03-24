package com.jfg.gamermvvm.presentation.screens.login.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jfg.gamermvvm.presentation.navigation.AuthScreen

@Composable
fun LoginBottomBar(controller: NavController) {

    Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.Center
    ){
        Text(text = "No tinenes cuenta? ", color = Color.Gray, fontSize = 14.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text(   modifier = Modifier
            .clickable {
             controller.navigate(AuthScreen.Signup.route){
                 controller.popBackStack()
             }
        },
            text = "Registrate aqui",
            color = Color.Red,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewLoginBottomBar() {

    LoginBottomBar(rememberNavController())
}




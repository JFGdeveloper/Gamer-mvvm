package com.jfg.gamermvvm.screens.login.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginBottomBar() {

    Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.Center
    ){
        Text(text = "No tinenes cuenta? ", color = Color.Gray, fontSize = 14.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
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
    LoginBottomBar()
}




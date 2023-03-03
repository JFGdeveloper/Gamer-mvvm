package com.jfg.gamermvvm.presentation.screens.Composables

import android.graphics.Color
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jfg.gamermvvm.presentation.ui.theme.Red500

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier,
    color: androidx.compose.ui.graphics.Color = Red500,
    text: String,
    errorText: String = "",
    icon: ImageVector,
    enableButton: Boolean= true,
    onclick: ()->Unit
) {

    Column {

        Button(
                modifier = modifier,
                onClick = { onclick()},
                colors = ButtonDefaults.buttonColors(color),
                enabled = enableButton
        ) {
            Icon(imageVector = icon, contentDescription = null)
            Text(modifier = Modifier.padding(start = 3.dp), text = text)
        }


        Text(
                text = errorText,
                modifier = Modifier.padding(top = 3.dp),
                fontSize = 11.sp,
                color = androidx.compose.ui.graphics.Color.Red
        )

    }


}
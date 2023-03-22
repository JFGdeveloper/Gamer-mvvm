package com.jfg.gamermvvm.presentation.screens.Composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DialogCapturePicture(
    state: MutableState<Boolean>,
    takePhoto: ()->Unit,
    pickerImage: ()-> Unit
) {
    if (state.value){

        AlertDialog(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                onDismissRequest = { state.value = false },
                backgroundColor = Color.White,
                title = {
                    Text(text = "Selecionea un opción", fontSize = 20.sp)
                },
                buttons = {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(onClick = {
                            state.value = false
                            pickerImage()
                         }, modifier = Modifier.width(130.dp)) {
                            Text(text = "Galeria")
                        }

                        Button(onClick = {
                            state.value = false
                            takePhoto()
                         }, modifier = Modifier.width(130.dp)) {
                            Text(text = "Foto")

                        }
                    }
                }

        )

    }
}
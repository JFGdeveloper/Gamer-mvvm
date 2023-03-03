package com.jfg.gamermvvm.presentation.screens.Composables

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jfg.gamermvvm.presentation.ui.theme.Red500

@Composable
fun DefaultTopAppbar(
    title: String,
    backAvailable: Boolean = false,
    controller: NavController
) {
    TopAppBar (
      title = { Text(text = title, fontSize = 19.sp)},
      navigationIcon = {
          IconButton(onClick = {
              if (backAvailable){ controller.popBackStack()}
          }) {
              Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
          }
      },
      backgroundColor = Red500
    )
}
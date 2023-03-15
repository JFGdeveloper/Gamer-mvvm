package com.jfg.gamermvvm.presentation.screens.Composables

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jfg.gamermvvm.presentation.navigation.AppScreen
import com.jfg.gamermvvm.presentation.ui.theme.Red500

@Composable
fun DefaultTopAppbar(
    title: String,
    backAvailable: Boolean,
    controller: NavController,
    screen: AppScreen
) {
    TopAppBar (
      title = { Text(text = title, fontSize = 19.sp)},
      navigationIcon = {
          IconButton(onClick = {
              if (backAvailable){
                  controller.navigate(screen.route)
              }
          }) {
              Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
          }
      },
      backgroundColor = Red500
    )
}
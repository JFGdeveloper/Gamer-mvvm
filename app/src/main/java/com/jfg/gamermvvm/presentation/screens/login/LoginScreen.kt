package com.jfg.gamermvvm.presentation.screens.login


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jfg.gamermvvm.presentation.screens.login.component.LoginBottomBar

import com.jfg.gamermvvm.presentation.screens.login.component.LoginContent
import com.jfg.gamermvvm.presentation.ui.theme.GamerMvvmTheme

@Composable
fun LoginScreen(controller: NavController) {
    Scaffold(
            topBar = {},
            content = { LoginContent(it) },
            bottomBar = { LoginBottomBar(controller) }
    )
}


@Preview(showBackground = true, showSystemUi = true,)
@Composable
fun DefaultPreview() {
    GamerMvvmTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
        ) {
            LoginScreen(rememberNavController())
        }
    }
}


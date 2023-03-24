package com.jfg.gamermvvm.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.jfg.gamermvvm.presentation.navigation.RootNavGraph
import com.jfg.gamermvvm.presentation.ui.theme.GamerMvvmTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamerMvvmTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                val navHostController = rememberNavController()
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                ) {
                    RootNavGraph(controller = navHostController)
                }
            }
        }
    }
}





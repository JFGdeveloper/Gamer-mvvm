package com.jfg.gamermvvm.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jfg.gamermvvm.presentation.navigation.HomeNavGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(controller: NavHostController = rememberNavController()) {

    Scaffold {
        HomeNavGraph(controller = controller)
    }
}


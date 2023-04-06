package com.jfg.gamermvvm.presentation.screens.detailsPost

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.jfg.gamermvvm.presentation.screens.detailsPost.componentes.DetailsPostContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsPostScreen(controller: NavHostController, post: String) {

    Scaffold(content = {
        DetailsPostContent(controller = controller)
    })

}
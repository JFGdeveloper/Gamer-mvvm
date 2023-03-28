package com.jfg.gamermvvm.presentation.navigation.routes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class HomeBottomBarScreen(
    val route: String,
    val tittle: String,
    val icon: ImageVector,
){

    object Posts: HomeBottomBarScreen(
            route = "posts",
            tittle = "Publicar",
            icon = Icons.Default.List
    )

    object MyPost: HomeBottomBarScreen(
            route = "my_post",
            tittle = "Mis Posts",
            icon = Icons.Outlined.List
    )

    object Profile: HomeBottomBarScreen(
            route = "profile",
            tittle = "Perfil",
            icon = Icons.Default.Person
    )


}

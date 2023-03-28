package com.jfg.gamermvvm.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jfg.gamermvvm.presentation.navigation.HomeNavGraph
import com.jfg.gamermvvm.presentation.navigation.routes.HomeBottomBarScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(controller: NavHostController = rememberNavController()) {

    Scaffold(
            bottomBar = {
                BottomBar(navController = controller)
            }
    ) {
        HomeNavGraph(controller = controller)
    }
}




@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
            HomeBottomBarScreen.Posts,
            HomeBottomBarScreen.MyPost,
            HomeBottomBarScreen.Profile,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {

        BottomNavigation(
//            backgroundColor = Red500
        ){
            screens.forEach { screen ->
                AddItem(
                        screen = screen,
                        currentDestination = currentDestination,
                        navController = navController
                )
            }
        }

    }

}

@Composable
fun RowScope.AddItem(
    screen: HomeBottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {

    BottomNavigationItem(
            label = {
                Text(text = screen.tittle)
            },
            icon = {
                Icon(
                        imageVector = screen.icon,
                        contentDescription = "Navigation icon"
                )
            },
            selected = currentDestination?.hierarchy?.any {
                it.route == screen.route
            } == true,
            unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
            onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }
    )

}

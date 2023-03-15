package com.jfg.gamermvvm.presentation.screens.profile.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jfg.gamermvvm.R
import com.jfg.gamermvvm.presentation.navigation.AppScreen
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultButton
import com.jfg.gamermvvm.presentation.screens.profile.ProfileViewModel

@Composable
fun ProfileContent(modifier: Modifier = Modifier, controller: NavHostController,vm: ProfileViewModel) {
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(){
            Image(  modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
                    painter = painterResource(id = R.drawable.profile_background),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alpha = 0.6f

            )

            Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                        text = "Bienvenido",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(50.dp))
                Image(  modifier = Modifier.size(100.dp),
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = null
                )

            }

        }//box

        Spacer(modifier = Modifier.height(70.dp))
        Text(
                text = vm.userData.username,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
                text = vm.userData.email,
                color = Color.White,
                fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(12.dp))

        DefaultButton(text = "Editar datos", icon = Icons.Default.Edit, color = Color.White) {
            controller.navigate(AppScreen.ProfileEdit.route){
                popUpTo(AppScreen.ProfileEdit.route){inclusive = true}
            }
        }
        DefaultButton(text = "Cerrar sesion", icon = Icons.Default.Close) {
            vm.onLogout()
            controller.navigate(AppScreen.Login.route){
                popUpTo(AppScreen.Profile.route){
                    inclusive = true
                }
            }
        }
    }
}

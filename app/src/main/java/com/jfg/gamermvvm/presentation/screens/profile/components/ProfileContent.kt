package com.jfg.gamermvvm.presentation.screens.profile.components

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.jfg.gamermvvm.R
import com.jfg.gamermvvm.presentation.MainActivity
import com.jfg.gamermvvm.presentation.navigation.routes.AuthScreen
import com.jfg.gamermvvm.presentation.navigation.routes.DetailScreen
import com.jfg.gamermvvm.presentation.navigation.routes.Graph
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultButton
import com.jfg.gamermvvm.presentation.screens.profile.ProfileViewModel

@Composable
fun ProfileContent(modifier: Modifier = Modifier, controller: NavHostController,vm: ProfileViewModel) {

    // LA USARE PARA CUANDO CIERRO LOS GRAPH
    val activity = LocalContext.current as? Activity

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

                if (vm.userData.image != ""){
                    AsyncImage(model = vm.userData.image,
                               contentDescription = "Imagen usuario",
                               modifier= Modifier.size(120.dp).clip(CircleShape),
                               contentScale = ContentScale.Crop
                    )
                }else{
                    Image(  modifier = Modifier.size(120.dp),
                            painter = painterResource(id = R.drawable.user),
                            contentDescription = null
                    )

                }

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

            // ASEGURO QUE LA URL DE LA FOTO NO SE CONFUNDE CON LA URL DE AL NAVEGACION DE COMPOSE

            controller.navigate(DetailScreen.ProfileUpdate.sendUser(vm.userData.toJson())){
                popUpTo(DetailScreen.ProfileUpdate.route){inclusive = true}
            }
        }
        DefaultButton(text = "Cerrar sesion", icon = Icons.Default.Close) {
            vm.onLogout()
           // PARA VOLVER AL GRAPH ROOT TENGO QUE CERRAR LA ACTIVITY Y INICIARLA
            activity?.finish()
            activity?.startActivity(Intent(activity,MainActivity::class.java))
        }
    }
}

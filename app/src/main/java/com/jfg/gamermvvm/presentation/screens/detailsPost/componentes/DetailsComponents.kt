package com.jfg.gamermvvm.presentation.screens.detailsPost.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jfg.gamermvvm.R

@Composable
fun DetailsPostComponents() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState())) {
        Image(
                painter = painterResource(id = R.drawable.halo),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
        )

        Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 8.dp)
                    .fillMaxWidth()
                    .height(80.dp),
                elevation = 8.dp
        ) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
                Image(
                        painter = painterResource(id = R.drawable.halo),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(text = "name", fontSize = 17.sp)
                    Text(text = "email", fontSize = 12.sp)
                }
            }

        }// card del usuario
        
        Text(
                text = "Nombre del usuario",
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 20.dp, top = 8.dp, bottom = 8.dp)
        )
        Card(
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .height(30.dp)
                    .width(150.dp)
                    .padding(start = 20.dp) ,
                contentColor = Color.White
        ) {
            Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.background(Color.Red)
            ) {
                Image(
                        painter = painterResource(id = R.drawable.icon_xbox),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = "Ps4")
                
            }
        }// card del icon y nombre del juego

        Divider(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp))
        
        Text(text = "Description", fontSize = 17.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 20.dp))
        Text(
                text = "Es un hecho establecido hace demasiado tiempo que un lector se distraerá con el contenido del texto de un sitio mientras que mira su diseño. El punto de usar Lorem Ipsum es que tiene una distribución más o menos normal de las letras, al contrario de usar textos como por ejemplo \"Contenido aquí, contenido aquí\". Estos textos hacen parecerlo un español que se puede leer. Muchos paquetes de autoedición y editores de páginas web usan el Lorem Ipsum como su texto por defecto, y al hacer una búsqueda de \"Lorem Ipsum\" va a dar por resultado muchos sitios web que usan este texto si se encuentran en estado de desarrollo. Muchas versiones han evolucionado a través de los años, algunas veces por accidente, otras veces a propósito (por ejemplo insertándole humor y cosas por el estilo).",
                fontSize = 11.sp,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevDetails() {

    DetailsPostComponents()
}
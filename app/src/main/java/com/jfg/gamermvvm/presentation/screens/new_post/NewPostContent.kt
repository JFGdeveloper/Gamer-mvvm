package com.jfg.gamermvvm.presentation.screens.new_post

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.jfg.gamermvvm.R
import com.jfg.gamermvvm.presentation.navigation.routes.DetailScreen
import com.jfg.gamermvvm.presentation.screens.Composables.DefaultOutlineTextField
import com.jfg.gamermvvm.presentation.ui.theme.Red500

data class CategotyRadioButton(
    var category: String,
    var image : Int
)


@Composable
fun NewPostContent() {

    val radioOptions = listOf(
            CategotyRadioButton( "PC",R.drawable.icon_pc),
            CategotyRadioButton("MOBIL",R.drawable.icon_pc),
            CategotyRadioButton("XBOX",R.drawable.icon_xbox),
            CategotyRadioButton("Nintendo",R.drawable.icon_nintendo),
            CategotyRadioButton("PS4",R.drawable.icon_ps4),
            CategotyRadioButton("PS4",R.drawable.icon_ps4),
            CategotyRadioButton("PS4",R.drawable.icon_ps4),
            CategotyRadioButton("PS4",R.drawable.icon_ps4),
            CategotyRadioButton("PS4",R.drawable.icon_ps4),
            CategotyRadioButton("PS4",R.drawable.icon_ps4),
            CategotyRadioButton("PS4",R.drawable.icon_ps4)
    )

    Box(modifier = Modifier
        .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ){

        Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
        ) {
            Box(
                    modifier = Modifier
                        .height(170.dp)
                        .background(Color.Red)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
            ){
                Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                            modifier = Modifier.height(120.dp),
                            painter = painterResource(id = R.drawable.add_image),
                            contentDescription = "Selecciona una imagen"
                    )
                    Text(
                            text = "Selecciona una imagen",
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold

                    )
                }

            }

            DefaultOutlineTextField(
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 8.dp)
                        .fillMaxWidth(),
                    value ="",
                    onValueChange = {},
                    label = "Nombre del juego",
                    leadingIcon = Icons.Default.Face,
                    keyBoard = KeyboardType.Text,
                    errorMsg = "",
                    onValidateText = {}
            )

            DefaultOutlineTextField(
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    value = "",
                    onValueChange = {},
                    leadingIcon = Icons.Default.List,
                    hideText = true,
                    label = "Description",
                    keyBoard = KeyboardType.Text,
                    errorMsg = "",
                    onValidateText = {}
            )

            Text(
                    text = "Categorias",
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .align(CenterHorizontally),
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
            )

            radioOptions.forEach{dataClass ->
                Row(
                   verticalAlignment = CenterVertically
                ) {
                    RadioButton(selected = false, onClick = { /*TODO*/ })
                    Row(verticalAlignment = CenterVertically) {
                        Text(text = dataClass.category, modifier = Modifier.width(100.dp))
                        Image(
                                painterResource(id = dataClass.image),
                                contentDescription = null,
                                modifier = Modifier.height(40.dp)
                        )

                    }

                }
            }

        }

    }
}


@Preview
@Composable
fun PrevNewPost() {
    NewPostScreen(controller = rememberNavController())
}
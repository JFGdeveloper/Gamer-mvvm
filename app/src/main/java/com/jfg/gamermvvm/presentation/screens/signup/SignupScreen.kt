package com.jfg.gamermvvm.presentation.screens.signup

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignupScreen() {
    Scaffold (
            topBar = {},
            content = { Text(text = "SignupScreen")},
            bottomBar = {}
    )
}
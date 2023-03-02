package com.jfg.gamermvvm.presentation.screens.Composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun DefaultOutlineTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (value: String)-> Unit,
    placeHolder: String= "",
    label: String= "",
    leadingIcon: ImageVector?= null,
    hideText: Boolean= false,
    keyBoard: KeyboardType = KeyboardType.Text,
    singleLine: Boolean = true
) {
    OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = { onValueChange(it)},
            placeholder = { Text(text = placeHolder) },
            label = { Text(text = label)},
            leadingIcon = {
                if (leadingIcon != null) {
                    Icon(imageVector = leadingIcon, contentDescription = null)
                }
            },
            visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = keyBoard),
            singleLine = singleLine
    )
}
package com.jfg.gamermvvm.presentation.screens.new_post

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfg.gamermvvm.R
import com.jfg.gamermvvm.presentation.utils.ComposeFileProvider
import com.jfg.gamermvvm.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject


data class CategoryRadioButton(
    var category: String,
    var image : Int
)

@HiltViewModel
class NewPostViewModel @Inject constructor(
    @ApplicationContext private val context: Context

): ViewModel(){

    var state by mutableStateOf(State())

    val radioOptions = listOf(
            CategoryRadioButton("PC", R.drawable.icon_pc),
            CategoryRadioButton("MOBIL", R.drawable.icon_pc),
            CategoryRadioButton("XBOX", R.drawable.icon_xbox),
            CategoryRadioButton("Nintendo", R.drawable.icon_nintendo),
            CategoryRadioButton("PS4", R.drawable.icon_ps4),

    )

    // OBJ DE LA CLASE UTILS
    val resultingActivityHandler = ResultingActivityHandler()

    private var file: File? = null

    fun onNewPost(){
        Log.d("javi","name ${state.name}")
        Log.d("javi","description ${state.description}")
        Log.d("javi","category ${state.category}")
        Log.d("javi","image ${state.image}")
    }

    fun onNameInput(name: String){
        state = state.copy(name = name)
    }

    fun onDescriptionInput(description: String){
        state = state.copy(description = description)
    }

    fun onCategoryInput(category: String){
        state = state.copy(category = category)
    }

    fun onImageInput(image: String){
        state = state.copy(image = image)
    }


    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null){
            file = ComposeFileProvider.createFileFromUri(context, result)
            Log.d("jf", "valor de la imagen en pickImage() viewmodel: ${state.image}")
            state = state.copy(image = result.toString())
        }


    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            //state.image = ComposeFileProvider.getPathFromBitmap(context, result)
            file = File(state.image)
            Log.d("jf", "valor de la imagen takephoto en viewmodel: ${state.image}")

        }

    }




}
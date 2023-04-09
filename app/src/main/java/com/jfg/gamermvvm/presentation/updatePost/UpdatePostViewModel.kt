package com.jfg.gamermvvm.presentation.updatePost

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfg.gamermvvm.R
import com.jfg.gamermvvm.domain.model.Post
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.use_cases.auth.AuthUseCases
import com.jfg.gamermvvm.domain.use_cases.posts.PostUseCases
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
class UpdatePostViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val postsUseCases: PostUseCases,
    private val authUseCases: AuthUseCases,
    val savedStateHandle: SavedStateHandle
): ViewModel(){

    var state by mutableStateOf(UpdateState())

    var data = savedStateHandle.get<String>("post")
    var post = Post.fromJson(data!!)

    // RESPONSE
    var updatePostResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    //USER SESSION
    val currentUser = authUseCases.getUser()

    // OBJ DE LA CLASE UTILS
    val resultingActivityHandler = ResultingActivityHandler()

    private var file: File? = null

    val radioOptions = listOf(
            CategoryRadioButton("PC", R.drawable.icon_pc),
            CategoryRadioButton("MOBIL", R.drawable.icon_pc),
            CategoryRadioButton("XBOX", R.drawable.icon_xbox),
            CategoryRadioButton("Nintendo", R.drawable.icon_nintendo),
            CategoryRadioButton("PS4", R.drawable.icon_ps4),

    )

    init {
        state = state.copy(
                image = post.image,
                description = post.description,
                name = post.name,
                category = post.category
        )
    }



    private fun updatePost(post: Post) = viewModelScope.launch {
        updatePostResponse = Response.Loading
        val result = postsUseCases.updatePost(post, file) // la validacion esta hecha en el usecase
        updatePostResponse = result
    }

    fun onUpdatePost(){
        val post = Post(
                id = post.id,
                name = state.name,
                description = state.description,
                category = state.category,
                idUser = currentUser?.uid ?: ""
        )
        updatePost(post)
    }

    fun clearForm() {
        /*
        state = state.copy(
                name ="",
                category = "",
                description = "",
                image = ""
        )

         */
        updatePostResponse = null
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
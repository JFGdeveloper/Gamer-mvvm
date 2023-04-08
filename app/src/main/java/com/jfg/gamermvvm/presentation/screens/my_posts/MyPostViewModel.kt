package com.jfg.gamermvvm.presentation.screens.my_posts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfg.gamermvvm.domain.model.Post
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.use_cases.auth.AuthUseCases
import com.jfg.gamermvvm.domain.use_cases.posts.PostUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPostViewModel @Inject constructor(
    private val useCases: PostUseCases,
    private val authUseCases: AuthUseCases
): ViewModel() {

    var response by mutableStateOf<Response<List<Post>>?>(null)
    var responseDelete by mutableStateOf<Response<Boolean>?>(null)

    private val currentUser = authUseCases.getUser()


    init {
        getResponse() // aseguro que la response se rellene
    }

    private fun getResponse()= viewModelScope.launch{
        response = Response.Loading
        useCases.getPostsByUserId(currentUser?.uid ?: "").collect(){
            response = it
        }


    }

    fun delete(idPost: String) = viewModelScope.launch {
        responseDelete = Response.Loading
        val response = useCases.deletePost(idPost)
        responseDelete = response
    }


}
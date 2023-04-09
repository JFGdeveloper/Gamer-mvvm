package com.jfg.gamermvvm.presentation.screens.posts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfg.gamermvvm.domain.model.Post
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.model.User
import com.jfg.gamermvvm.domain.use_cases.auth.AuthUseCases
import com.jfg.gamermvvm.domain.use_cases.posts.PostUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val useCases: PostUseCases,
    private val authUser: AuthUseCases
): ViewModel() {

    var response by mutableStateOf<Response<List<Post>>?>(null)
    var likeResponse by mutableStateOf<Response<Boolean>?>(null)
    var deleteResponse by mutableStateOf<Response<Boolean>?>(null)
    var currentUser = authUser.getUser()

    init {
        getResponse() // aseguro que la response se rellene
    }

    private fun getResponse()= viewModelScope.launch{
        response = Response.Loading
        useCases.getPosts().collect(){
            response = it
        }


    }

    fun like(idPost: String, idUser: String)= viewModelScope.launch {
        likeResponse = Response.Loading
        val data = useCases.like(idPost,idUser)
        likeResponse = data
    }
    fun deleteLike(idPost: String, idUser: String)= viewModelScope.launch {
        deleteResponse = Response.Loading
        val data = useCases.deleteLike(idPost,idUser)
        deleteResponse = data
    }


}
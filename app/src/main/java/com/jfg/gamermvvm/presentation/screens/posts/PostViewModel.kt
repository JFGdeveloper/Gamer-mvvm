package com.jfg.gamermvvm.presentation.screens.posts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfg.gamermvvm.domain.model.Post
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.use_cases.posts.PostUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val useCases: PostUseCases
): ViewModel() {

    var response by mutableStateOf<Response<List<Post>>?>(null)

    init {
        getResponse() // aseguro que la response se rellene
    }

    fun getResponse()= viewModelScope.launch{
        response = Response.Loading
        useCases.getPosts().collect(){
            response = it
        }


    }


}
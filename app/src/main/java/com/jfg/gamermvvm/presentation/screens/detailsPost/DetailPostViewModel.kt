package com.jfg.gamermvvm.presentation.screens.detailsPost

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.jfg.gamermvvm.domain.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailPostViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel(){

    val data = savedStateHandle.get<String>("post")
    var post = Post.fromJson(data!!)

}
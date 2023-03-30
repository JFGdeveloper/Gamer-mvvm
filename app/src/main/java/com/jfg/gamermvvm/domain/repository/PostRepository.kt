package com.jfg.gamermvvm.domain.repository

import com.jfg.gamermvvm.domain.model.Post
import com.jfg.gamermvvm.domain.model.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface PostRepository {

    suspend fun create(post: Post, file: File): Response<Boolean>

    fun getPost(): Flow<Response<List<Post>>>

}
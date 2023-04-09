package com.jfg.gamermvvm.domain.repository

import com.jfg.gamermvvm.domain.model.Post
import com.jfg.gamermvvm.domain.model.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface PostRepository {

    fun getPost(): Flow<Response<List<Post>>>
    fun getPostsByUserId(idUser: String): Flow<Response<List<Post>>>
    suspend fun create(post: Post, file: File): Response<Boolean>
    suspend fun delete(idPost: String): Response<Boolean>
    suspend fun update(post: Post,file: File?): Response<Boolean>

}
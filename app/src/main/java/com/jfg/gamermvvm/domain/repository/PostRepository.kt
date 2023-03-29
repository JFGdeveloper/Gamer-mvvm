package com.jfg.gamermvvm.domain.repository

import com.jfg.gamermvvm.domain.model.Post
import com.jfg.gamermvvm.domain.model.Response
import java.io.File

interface PostRepository {

    suspend fun create(post: Post, file: File): Response<Boolean>

}
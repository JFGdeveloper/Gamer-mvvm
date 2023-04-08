package com.jfg.gamermvvm.domain.use_cases.posts

import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.repository.PostRepository
import javax.inject.Inject

class DeletePost @Inject constructor(
    private val repository: PostRepository
) {
    suspend operator fun invoke(idPost: String) = repository.delete(idPost)

}
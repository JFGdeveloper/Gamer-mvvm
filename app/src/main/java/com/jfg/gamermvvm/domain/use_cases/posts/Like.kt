package com.jfg.gamermvvm.domain.use_cases.posts

import com.jfg.gamermvvm.domain.repository.PostRepository
import javax.inject.Inject

class Like @Inject constructor(
    private val repo: PostRepository
) {
    suspend operator fun invoke(idPost: String, idUser: String) = repo.like(idPost,idUser)
}
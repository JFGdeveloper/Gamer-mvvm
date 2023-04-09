package com.jfg.gamermvvm.domain.use_cases.posts

import com.jfg.gamermvvm.domain.repository.PostRepository
import javax.inject.Inject

class DeleteLike @Inject constructor(
    private val repo: PostRepository
) {
    suspend operator fun invoke(idPost: String, idUser: String) = repo.deleteLike(idPost,idUser)
}
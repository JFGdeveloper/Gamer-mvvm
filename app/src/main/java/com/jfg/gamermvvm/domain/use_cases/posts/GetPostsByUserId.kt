package com.jfg.gamermvvm.domain.use_cases.posts

import com.jfg.gamermvvm.domain.repository.PostRepository
import javax.inject.Inject

class GetPostsByUserId @Inject constructor(
    private val repo: PostRepository
) {
    operator fun invoke(idUser: String) = repo.getPostsByUserId(idUser)
}
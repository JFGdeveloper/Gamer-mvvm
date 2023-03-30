package com.jfg.gamermvvm.domain.use_cases.posts

import com.jfg.gamermvvm.domain.repository.PostRepository
import javax.inject.Inject

class GetPosts @Inject constructor(
    private val repo: PostRepository
) {
    operator fun invoke() = repo.getPost()
}
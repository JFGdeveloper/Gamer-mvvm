package com.jfg.gamermvvm.domain.use_cases.posts

data class PostUseCases(
    val createPost: CreatePost,
    val getPosts: GetPosts,
    val getPostsByUserId: GetPostsByUserId,
    val deletePost: DeletePost,
    val updatePost: UpdatePost
)
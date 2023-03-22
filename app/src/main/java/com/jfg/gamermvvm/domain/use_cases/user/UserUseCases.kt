package com.jfg.gamermvvm.domain.use_cases.user

import javax.inject.Inject

data class UserUseCases @Inject constructor(
    val create: Create,
    val getUserById: GetUserById,
    val update: Update,
    val saveImage: SaveImage
)

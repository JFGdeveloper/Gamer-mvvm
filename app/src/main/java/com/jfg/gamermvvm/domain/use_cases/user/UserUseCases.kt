package com.jfg.gamermvvm.domain.use_cases.user

import javax.inject.Inject

data class UserUseCases @Inject constructor(
    val create: Create
)

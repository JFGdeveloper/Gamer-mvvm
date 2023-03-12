package com.jfg.gamermvvm.domain.use_cases.auth

import com.jfg.gamermvvm.domain.model.User
import com.jfg.gamermvvm.domain.repository.AuthRepository
import javax.inject.Inject

class Signup @Inject constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(user: User)= repository.signup(user = user)

}
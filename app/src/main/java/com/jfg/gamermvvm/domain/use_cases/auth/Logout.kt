package com.jfg.gamermvvm.domain.use_cases.auth

import com.jfg.gamermvvm.domain.repository.AuthRepository
import javax.inject.Inject


class Logout @Inject constructor(
    private val authRepository: AuthRepository
) {

    operator fun invoke() = authRepository.logout()
}
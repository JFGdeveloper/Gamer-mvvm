package com.jfg.gamermvvm.domain.use_cases.user

import com.jfg.gamermvvm.domain.model.User
import com.jfg.gamermvvm.domain.repository.UsersRepository
import javax.inject.Inject

class Update @Inject constructor(
    private val repository: UsersRepository
) {
    suspend operator fun invoke(user: User) = repository.updateUser(user)
}
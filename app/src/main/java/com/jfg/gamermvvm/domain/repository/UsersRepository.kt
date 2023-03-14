package com.jfg.gamermvvm.domain.repository

import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.model.User

interface UsersRepository {

    suspend fun createUser(user: User): Response<Boolean>
}
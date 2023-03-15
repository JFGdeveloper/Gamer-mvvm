package com.jfg.gamermvvm.domain.repository

import androidx.compose.runtime.snapshots.Snapshot
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

interface UsersRepository {

    suspend fun createUser(user: User): Response<Boolean>

    // AL SER UN FLOW NO NECESITA SUSPEND
    fun getUserById(id: String): Flow<User>
}
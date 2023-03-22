package com.jfg.gamermvvm.domain.repository

import androidx.compose.runtime.snapshots.Snapshot
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.io.File

interface UsersRepository {

    suspend fun createUser(user: User): Response<Boolean>

    suspend fun updateUser(user: User): Response<Boolean>

    suspend fun saveImage(fiel: File): Response<String>

    // AL SER UN FLOW NO NECESITA SUSPEND
    fun getUserById(id: String): Flow<User>
}
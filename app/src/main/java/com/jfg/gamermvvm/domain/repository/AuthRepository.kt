package com.jfg.gamermvvm.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.jfg.gamermvvm.domain.model.Response

interface AuthRepository {

    val currentUser: FirebaseUser?

    suspend fun login(email: String, pass: String): Response<FirebaseUser>
}
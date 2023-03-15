package com.jfg.gamermvvm.data.repository

import com.google.firebase.firestore.CollectionReference
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.model.User
import com.jfg.gamermvvm.domain.repository.AuthRepository
import com.jfg.gamermvvm.domain.repository.UsersRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val userRef: CollectionReference
): UsersRepository {

    override suspend fun createUser(user: User): Response<Boolean> {
        return try {
            user.password = ""
            userRef.document(user.id).set(user).await()
            Response.Success(true)
        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override fun getUserById(id: String): Flow<User> = callbackFlow{
        // pongo escuchador al document
        val snapshotListener = userRef.document(id).addSnapshotListener{ snapshot, e ->
            val user = snapshot?.toObject(User::class.java) ?: User()

            // emito resultado
            trySend(user)

        }

        // cierro los cotis
        awaitClose {
            snapshotListener.remove()
        }

    }


}
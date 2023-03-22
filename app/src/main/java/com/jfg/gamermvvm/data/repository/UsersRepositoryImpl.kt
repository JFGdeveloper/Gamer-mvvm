package com.jfg.gamermvvm.data.repository

import android.net.Uri
import androidx.lifecycle.Transformations.map
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.storage.StorageReference
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.model.User
import com.jfg.gamermvvm.domain.repository.AuthRepository
import com.jfg.gamermvvm.domain.repository.UsersRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.io.File
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val userRef: CollectionReference,
    private val storageUsersRef: StorageReference
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

    override suspend fun updateUser(user: User): Response<Boolean> {
        return try {
            val map: MutableMap<String,Any> = HashMap()
            map["username"] = user.username
            map["image"] = user.image

            userRef.document(user.id).update(map).await()
            Response.Success(true)

        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun saveImage(file: File): Response<String> {
        return try {
            val fromFile = Uri.fromFile(file)
            val ref = storageUsersRef.child(file.name)
            val uploadTask = ref.putFile(fromFile).await()
            val url = ref.downloadUrl.await()
            return Response.Success(url.toString())
        }
        catch (e: Exception) {
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
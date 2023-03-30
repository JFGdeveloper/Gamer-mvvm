package com.jfg.gamermvvm.data.repository

import android.net.Uri
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.storage.StorageReference
import com.jfg.gamermvvm.core.Constants.POSTS
import com.jfg.gamermvvm.domain.model.Post
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.repository.PostRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.io.File
import javax.inject.Inject
import javax.inject.Named

class PostRepositoryImpl @Inject constructor(
    @Named(POSTS) private val postsRef: CollectionReference,
    @Named(POSTS) private val storagePostsRef: StorageReference
):PostRepository {
    override suspend fun create(post: Post, file: File): Response<Boolean> {
        return try {
            // IMAGE
            val fromFile = Uri.fromFile(file)
            val ref = storagePostsRef.child(file.name)
            val uploadTask = ref.putFile(fromFile).await()
            val url = ref.downloadUrl.await()

            // DATA
            post.image = url.toString()
            postsRef.add(post).await() // add añade un id automaticamente
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override fun getPost(): Flow<Response<List<Post>>> = callbackFlow{
        val snapshotListener = postsRef.addSnapshotListener { snapshot, e ->

            val postsResponse = if (snapshot != null) {
                val posts = snapshot.toObjects(Post::class.java)

                Response.Success(posts)
            } else {
                Response.Failure(e)
            }
            trySend(postsResponse)


        }
        awaitClose {
            snapshotListener.remove()
        }

    }


}
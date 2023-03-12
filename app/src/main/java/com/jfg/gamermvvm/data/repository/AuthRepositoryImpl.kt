package com.jfg.gamermvvm.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.jfg.gamermvvm.domain.model.Response
import com.jfg.gamermvvm.domain.model.User
import com.jfg.gamermvvm.domain.repository.AuthRepository
import javax.inject.Inject
import kotlinx.coroutines.tasks.await


// MANEJO FIREBASE CON AWAIT() EN VEZ DE ADDSUCCESSLISTENER...
class AuthRepositoryImpl @Inject constructor(private val authFirebase: FirebaseAuth):AuthRepository {
    override val currentUser: FirebaseUser?
        get() = authFirebase.currentUser

    override suspend fun login(email: String, pass: String): Response<FirebaseUser> {

      return try {
          val result = authFirebase.signInWithEmailAndPassword(email,pass).await()
          Response.Success(result.user!!)

      }catch (e:Exception){
            e.printStackTrace()
          Response.Failure(e)
      }
    }

    override suspend fun signup(user: User): Response<FirebaseUser> {
      return  try {
            val result = authFirebase.createUserWithEmailAndPassword(user.email,user.password).await()
            Response.Success(result.user!!)

        }catch (e:Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override fun logout() {
        authFirebase.signOut()
    }


}
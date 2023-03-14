package com.jfg.gamermvvm.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.jfg.gamermvvm.core.Constants.USERS
import com.jfg.gamermvvm.data.repository.AuthRepositoryImpl
import com.jfg.gamermvvm.data.repository.UsersRepositoryImpl
import com.jfg.gamermvvm.domain.repository.AuthRepository
import com.jfg.gamermvvm.domain.repository.UsersRepository
import com.jfg.gamermvvm.domain.use_cases.auth.*
import com.jfg.gamermvvm.domain.use_cases.user.Create
import com.jfg.gamermvvm.domain.use_cases.user.UserUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providerFirebaseAuth():FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun providerAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun providerAutUseCase(repository: AuthRepository) =
        AuthUseCases(getUser = GetUser(repository),
                     login = Login(repository),
                     logout = Logout(repository),
                     signup = Signup(repository)
        )


    //USER
    @Provides
    fun providerFirebase():FirebaseFirestore = Firebase.firestore

    @Provides
    fun providerFirebaseRef(db: FirebaseFirestore): CollectionReference = db.collection(USERS)

    @Provides
    fun providerUserImpl(impl: UsersRepositoryImpl):UsersRepository = impl

    @Provides
    fun providerUserUseCases(repository: UsersRepository) = UserUseCases(
            create = Create(repository)
    )
}
package com.jfg.gamermvvm.di

import com.google.firebase.auth.FirebaseAuth
import com.jfg.gamermvvm.data.repository.AuthRepositoryImpl
import com.jfg.gamermvvm.domain.repository.AuthRepository
import com.jfg.gamermvvm.domain.use_cases.auth.AuthUseCase
import com.jfg.gamermvvm.domain.use_cases.auth.GetUser
import com.jfg.gamermvvm.domain.use_cases.auth.Login
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
        AuthUseCase(getUser = GetUser(repository), login = Login(repository))
}
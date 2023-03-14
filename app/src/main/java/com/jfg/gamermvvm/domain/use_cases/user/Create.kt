package com.jfg.gamermvvm.domain.use_cases.user

import com.jfg.gamermvvm.data.repository.UsersRepositoryImpl
import com.jfg.gamermvvm.domain.model.User
import com.jfg.gamermvvm.domain.repository.UsersRepository
import javax.inject.Inject


 class Create @Inject constructor(
    private val repository: UsersRepository
){
    suspend operator fun invoke(user: User){
        repository.createUser(user)
    }

}

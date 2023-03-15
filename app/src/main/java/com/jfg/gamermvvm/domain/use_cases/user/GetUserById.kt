package com.jfg.gamermvvm.domain.use_cases.user

import com.jfg.gamermvvm.domain.repository.UsersRepository
import javax.inject.Inject

class GetUserById @Inject constructor(
    private val repository: UsersRepository
) {

     operator fun invoke(id: String)= repository.getUserById(id = id)

}
package com.jfg.gamermvvm.domain.use_cases.auth

import com.jfg.gamermvvm.domain.repository.AuthRepository
import javax.inject.Inject

class GetUser @Inject constructor(private val repository: AuthRepository) {
    // NO HACE FALTA SUSPEND POR QUE ACCEDO A LA VARIABLE DE LA INTERFACE
    operator fun invoke()= repository.currentUser
}
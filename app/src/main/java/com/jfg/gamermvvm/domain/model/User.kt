package com.jfg.gamermvvm.domain.model

data class User(
    var username: String = "",
    var email: String = "",
    var password: String = "",
    var confirmPassword: String = ""
)

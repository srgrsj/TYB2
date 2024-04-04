package com.example.tyb2.domain.user.usecases

import com.example.tyb2.domain.user.model.User
import com.example.tyb2.domain.user.repository.UserRepository


class GetSignedInUserUseCase(private val repository: UserRepository) {
    operator fun invoke(): User? = repository.getSignedInUser()
}
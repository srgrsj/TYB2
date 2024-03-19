package com.example.tyb2.domain.user.usecases

import com.example.tyb2.domain.user.repository.UserRepository
class UpdateProfilePictureUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(id: String, profilePicValue: String) {
//        repository.updateProfilePicture(id, profilePicValue)
    }
}

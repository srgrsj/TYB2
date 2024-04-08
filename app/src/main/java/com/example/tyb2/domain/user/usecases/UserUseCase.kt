package com.example.tyb2.domain.user.usecases

data class UserUseCase(
    val addUserUseCase: AddUserUseCase,
    val userSignInUseCase: UserSignInUseCase,
    val userSignUpUseCase: UserSignUpUseCase,
    val userSignOutUseCase: UserSignOutUseCase,
    val readOnboardingIsShow: ReadOnboardingIsShow,
    val saveOnboardingIsShow: SaveOnboardingIsShow,
    val continueWithGoogleUseCase: ContinueWithGoogleUseCase,
    val getSignedInUserUseCase: GetSignedInUserUseCase,
    val updateProfilePictureUseCase: UpdateProfilePictureUseCase,
    val updateUserUseCase: UpdateUserUseCase,
    val getAvatarUseCase: GetAvatarUseCase,
    val setAvatarUseCase: SetAvatarUseCase,
)
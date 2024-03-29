package com.example.tyb2.data.user.repository

import android.content.Context
import android.content.Intent
import android.content.IntentSender
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.tyb2.R
import com.example.tyb2.data.user.AccountData
import com.example.tyb2.domain.user.model.AchievementType
import com.example.tyb2.domain.user.model.User
import com.example.tyb2.domain.user.repository.UserRepository
import com.example.tyb2.util.Constants
import com.example.tyb2.util.Resource
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import java.io.IOException
import java.util.UUID
import java.util.concurrent.CancellationException
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class UserRepositoryFirebaseImpl
@Inject constructor(
    private val context: Context,
    private val firebaseAuth: FirebaseAuth,
    databaseReference: DatabaseReference,
) : UserRepository {
    private var signInClient : SignInClient = Identity.getSignInClient(context)
    private val userDatabaseReference =
        databaseReference.child("users")


    override suspend fun insertUser(user: User) {
        user.id.let { userDatabaseReference.child(it).setValue(user) }
    }

//    override suspend fun updateProfilePicture(id: String, profilePicValue: String) {
//        val updates = HashMap<String, Any>()
//        updates["profilePictureUrl"] = profilePicValue
//        id.let { userDatabaseReference.child(it).updateChildren(updates) }
//    }
    override fun loginUser(email: String, password: String): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }
    }
    override fun registerUser(email: String, password: String): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }
    }
    override suspend fun continueWithGoogle(credential: AuthCredential): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())
            val result = firebaseAuth.signInWithCredential(credential).await()
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }
    }
    override fun singOutUser() {
        signInClient.signOut()
        firebaseAuth.signOut()
        AccountData.EMAIL = null
        AccountData.ID = null
    }
    override fun getSignedInUser(): User? = firebaseAuth.currentUser?.run {
        User(
            id = uid,
            email = email.toString()
        )
    }

    override fun updateAchievement(user: User, achievementType: AchievementType) {
        val updatedAchievements = user.achievements.map {
            if (it.achievementType == achievementType) {
                it.copy(isAchieved = true)
            } else {
                it
            }
        }
        val updatedUser = user.copy(achievements = updatedAchievements)
        //TODO
    }



    override suspend fun saveOnboardingIsShow() {
        context.TYBDatastore.edit {
            it[TYBKeys.ONBOARDING_IS_SHOW] = false
        }
    }
    override fun readOnboardingIsShow(): Flow<Boolean> =
        context.TYBDatastore.data.map {
            it[TYBKeys.ONBOARDING_IS_SHOW] ?: true
        }
    //TODO functions for change/get user gender
    private fun updateProfilePicture() {
        //TODO
    }
}

val Context.TYBDatastore: DataStore<Preferences> by preferencesDataStore(Constants.TYB_DATASTORE)

private object TYBKeys {
    val ONBOARDING_IS_SHOW = booleanPreferencesKey("onboarding_is_show")
}

//title = "Первый шаг", i = 0
//description = "Завершите свою первую тренировку",
//achievementType = AchievementType.FIRST_TRAIN
//),
//title = "Гармония тела", i = 1
//description = "Выполните тренировки на все группы мышцы",
//achievementType = AchievementType.FULL_MUSCLES
//),
//title = "Стабильность - залог успеха",i = 2
//description = "Тренируйтесь каждый день на протяжении недели",
//achievementType = AchievementType.WEEK_TRAINING
//),
//title = "Вселенский баланс",i = 3
//description = "Начните заниматься йогой",
//achievementType = AchievementType.FIRST_YOGA
//),
//title = "Полной грудью",i = 4
//description = "Попробуйте все виды йоги",
//achievementType = AchievementType.FULL_YOGA
//),
//title = "Не вижу препятствий",i = 5
//description = "Занимайтесь беспрерывно на протяжении месяца",
//achievementType = AchievementType.MONTH_TRAINING
//)
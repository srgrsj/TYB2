package com.example.tyb2.data.user.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.tyb2.data.user.AccountData
import com.example.tyb2.domain.user.model.User
import com.example.tyb2.domain.user.repository.UserRepository
import com.example.tyb2.util.Constants
import com.example.tyb2.util.Resource
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserRepositoryFirebaseImpl
@Inject constructor(
    private val context: Context,
    private val firebaseAuth: FirebaseAuth,
    databaseReference: DatabaseReference
) : UserRepository {
    private val userDatabaseReference =
        databaseReference.child("users")

    override suspend fun insertUser(user: User) {
        user.id.let { userDatabaseReference.child(it).setValue(user) }
    }

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

    override fun singOutUser() {
        firebaseAuth.signOut()
        AccountData.EMAIL = null
        AccountData.ID = null
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
}

val Context.TYBDatastore: DataStore<Preferences> by preferencesDataStore(Constants.TYB_DATASTORE)
private object TYBKeys {
    val ONBOARDING_IS_SHOW = booleanPreferencesKey("onboarding_is_show")
//    val IS_AUTHORIZED = booleanPreferencesKey("is_authorized")
}
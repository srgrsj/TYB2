package com.example.tyb2.data.user.repository

import android.content.Context
import android.content.Intent
import android.content.IntentSender
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.tyb2.R
import com.example.tyb2.data.user.AccountData
import com.example.tyb2.domain.user.model.SignInResult
import com.example.tyb2.domain.user.model.User
import com.example.tyb2.domain.user.repository.UserRepository
import com.example.tyb2.util.Constants
import com.example.tyb2.util.Resource
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions
import com.google.android.gms.auth.api.identity.SignInClient
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
    private lateinit var signInClient : SignInClient
//    private val signInClient: SignInClient
    private val userDatabaseReference =
        databaseReference.child("users")

//    private val auth = Firebase.auth

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
        signInClient.signOut()
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

    //TODO provide this usecase
//    override suspend fun continueWithGoogle(): IntentSender? {
//        val result = try {
//            signInClient.beginSignIn(
//                buildSignInRequest()
//            ).await()
//        } catch (e: Exception) {
//            e.printStackTrace()
//            if (e is CancellationException) throw e
//            null
//        }
//        return result?.pendingIntent?.intentSender
//    }
//    //TODO provide this usecase
//    fun getSignedInUser(): User? = firebaseAuth.currentUser?.run {
//        User(
//            id = uid,
//            email = email.toString()
//        )
//    }
//    //TODO provide this usecase
//    suspend fun getContinueWithGoogleFromIntent(intent: Intent): SignInResult {
//        val credential = signInClient.getSignInCredentialFromIntent(intent)
//        val googleIdToken = credential.googleIdToken
//        val googleCredentials = GoogleAuthProvider.getCredential(
//            googleIdToken, null
//        )
//        return try {
//            val user = firebaseAuth.signInWithCredential(googleCredentials).await().user
//            SignInResult(
//                user = user?.run {
//                    User(
//                        email = email.toString(),
//                        id = uid
//                    )
//                },
//                errorMessage = null
//            )
//        } catch (e: Exception) {
//            e.printStackTrace()
//            if (e is CancellationException) throw e
//            SignInResult(
//                user = null,
//                errorMessage = e.message
//            )
//        }
//    }
//
//    private fun buildSignInRequest(): BeginSignInRequest {
//        return BeginSignInRequest.Builder()
//            .setGoogleIdTokenRequestOptions(
//                GoogleIdTokenRequestOptions.builder()
//                    .setSupported(true)
//                    .setFilterByAuthorizedAccounts(false)
//                    .setServerClientId(context.getString(R.string.web_client_id))
//                    .build()
//            ).setAutoSelectEnabled(true)
//            .build()
//    }

    private fun updateProfilePicture() {
        //TODO
    }
}

val Context.TYBDatastore: DataStore<Preferences> by preferencesDataStore(Constants.TYB_DATASTORE)

private object TYBKeys {
    val ONBOARDING_IS_SHOW = booleanPreferencesKey("onboarding_is_show")
//    val IS_AUTHORIZED = booleanPreferencesKey("is_authorized")
}
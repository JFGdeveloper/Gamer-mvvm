package com.jfg.gamermvvm.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.jfg.gamermvvm.core.Constants.POSTS
import com.jfg.gamermvvm.core.Constants.USERS
import com.jfg.gamermvvm.data.repository.AuthRepositoryImpl
import com.jfg.gamermvvm.data.repository.PostRepositoryImpl
import com.jfg.gamermvvm.data.repository.UsersRepositoryImpl
import com.jfg.gamermvvm.domain.repository.AuthRepository
import com.jfg.gamermvvm.domain.repository.PostRepository
import com.jfg.gamermvvm.domain.repository.UsersRepository
import com.jfg.gamermvvm.domain.use_cases.auth.*
import com.jfg.gamermvvm.domain.use_cases.posts.CreatePost
import com.jfg.gamermvvm.domain.use_cases.posts.GetPosts
import com.jfg.gamermvvm.domain.use_cases.posts.PostUseCases
import com.jfg.gamermvvm.domain.use_cases.user.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //AUTH
    @Provides
    fun providerFirebaseAuth():FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun providerAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun providerAutUseCase(repository: AuthRepository) =
        AuthUseCases(getUser = GetUser(repository),
                     login = Login(repository),
                     logout = Logout(repository),
                     signup = Signup(repository)
        )

    //POST
    @Provides
    @Named(POSTS)
    fun provideStoragePostsRef(storage: FirebaseStorage): StorageReference = storage.reference.child(POSTS)

    @Provides
    @Named(POSTS)
    fun providePostsRef(db: FirebaseFirestore): CollectionReference = db.collection(POSTS)

    @Provides
    fun providePostsRepository(impl: PostRepositoryImpl): PostRepository = impl

    @Provides
    fun providePostsUseCases(repository: PostRepository) = PostUseCases(
            createPost = CreatePost(repository),
            getPosts = GetPosts(repository)
    )

    //FIREBASE
    @Provides
    fun providerFirebase():FirebaseFirestore = Firebase.firestore

    @Provides
    @Named(USERS)
    fun providerFirebaseRef(db: FirebaseFirestore): CollectionReference = db.collection(USERS)

    @Provides
    fun provideFirebaseStorage():FirebaseStorage = FirebaseStorage.getInstance()

    //USER
    @Provides
    @Named(USERS)
    fun provideStorageUserRef(storage: FirebaseStorage): StorageReference = storage.reference.child(USERS)

    @Provides
    fun providerUserImpl(impl: UsersRepositoryImpl):UsersRepository = impl

    @Provides
    fun providerUserUseCases(repository: UsersRepository) = UserUseCases(
            create = Create(repository),
            getUserById = GetUserById(repository),
            update = Update(repository),
            saveImage = SaveImage(repository)
    )
}
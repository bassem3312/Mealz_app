package com.bassem.mealzapp.di

import com.bassem.data.local.MealsCategoryDataBase
import com.bassem.data.remote.ApiService
import com.bassem.data.repository.MealsRepoImp
import com.bassem.domain.repo.MealsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


/**
 * @author Bassem Mohsen : basem3312@gmail.com on 3/15/2023.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(
        apiService: ApiService,
        mealsCategoryDataBase: MealsCategoryDataBase
    ): MealsRepository {
        return MealsRepoImp(apiService, mealsCategoryDataBase)
    }

}
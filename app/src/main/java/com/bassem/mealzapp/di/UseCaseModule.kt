package com.bassem.mealzapp.di

import com.bassem.domain.repo.MealsRepository
import com.bassem.domain.usercase.CashingMealzUseCase
import com.bassem.domain.usercase.GetMealzUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


/**
 * @author Bassem Mohsen : basem3312@gmail.com on 3/15/2023.
 */

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(mealsRepository: MealsRepository): GetMealzUseCase {
        return GetMealzUseCase(mealsRepository)
    }

    @Provides
    fun provideLocalUseCase(mealsRepository: MealsRepository): CashingMealzUseCase {
        return CashingMealzUseCase(mealsRepository)
    }
}
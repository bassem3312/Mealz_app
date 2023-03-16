package com.bassem.mealzapp.di

import android.content.Context
import androidx.room.Room
import com.bassem.data.local.MealsCategoryDAO
import com.bassem.data.local.MealsCategoryDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


/**
 * @author Bassem Mohsen : basem3312@gmail.com on 2/23/2023.
 */
@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideWordsDataBase(@ApplicationContext context: Context): MealsCategoryDataBase {
        return Room.databaseBuilder(context = context, MealsCategoryDataBase::class.java, "MealsCategory.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideWordsDao(mealsCategoryDB: MealsCategoryDataBase): MealsCategoryDAO {
        return mealsCategoryDB.categoryDAO()
    }

}
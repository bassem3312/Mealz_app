package com.bassem.domain.usercase

import com.bassem.domain.entity.Category
import com.bassem.domain.repo.MealsRepository


/**
 * @author Bassem Mohsen : basem3312@gmail.com on 3/15/2023.
 */
class CashingMealzUseCase(private val mealsRepository: MealsRepository) {

    suspend fun getAllCategoriesFromLocal() = mealsRepository.getMealsFromLocal()

    suspend fun saveCategoriesToLocal(categories: List<Category>) {
        mealsRepository.saveCategoriesToLocal(categories)
    }

    suspend fun saveCategoryToLocal(category: Category) {
        mealsRepository.saveCategoryToLocal(category)
    }
}
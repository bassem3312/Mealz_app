package com.bassem.domain.repo

import com.bassem.domain.entity.Category
import com.bassem.domain.entity.CategoryResponse


/**
 * @author Bassem Mohsen : basem3312@gmail.com on 3/15/2023.
 */
interface MealsRepository {
    suspend fun getMealsFromRemote(): CategoryResponse

     suspend fun getMealsFromLocal(): List<Category>

    suspend fun saveCategoriesToLocal(categories: List<Category>)

    suspend fun saveCategoryToLocal(category: Category)
}
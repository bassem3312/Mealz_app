package com.bassem.data.repository

import com.bassem.data.local.MealsCategoryDataBase
import com.bassem.data.remote.ApiService
import com.bassem.domain.entity.Category
import com.bassem.domain.entity.CategoryResponse
import com.bassem.domain.repo.MealsRepository


/**
 * @author Bassem Mohsen : basem3312@gmail.com on 3/15/2023.
 */
class MealsRepoImp(
    private val apiService: ApiService,
    private val categoryDataBase: MealsCategoryDataBase
) : MealsRepository {
    override suspend fun getMealsFromRemote(): CategoryResponse = apiService.getMeals()

    override suspend fun getMealsFromLocal(): List<Category> =
        categoryDataBase.categoryDAO().getAllCategories()


    override suspend fun saveCategoriesToLocal(categories: List<Category>) {
        categoryDataBase.categoryDAO().insertAllCategories(categories)
    }

    override suspend fun saveCategoryToLocal(category: Category) {
        categoryDataBase.categoryDAO().insertCategory(category)
    }
}
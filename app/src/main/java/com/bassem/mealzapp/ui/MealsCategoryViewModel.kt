package com.bassem.mealzapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bassem.domain.entity.Category
import com.bassem.domain.entity.CategoryResponse
import com.bassem.domain.usercase.CashingMealzUseCase
import com.bassem.domain.usercase.GetMealzUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @author Bassem Mohsen : basem3312@gmail.com on 3/15/2023.
 */
@HiltViewModel
class MealsCategoryViewModel @Inject constructor(
    private val getMealzUseCase: GetMealzUseCase,
    private val cashingMealzUseCase: CashingMealzUseCase
) :
    ViewModel() {

    private val _categories: MutableStateFlow<CategoryResponse?> = MutableStateFlow(null)
    val categories: StateFlow<CategoryResponse?> = _categories


    fun getMeals() {
        viewModelScope.launch {
            try {
                val allMealsCategory = getMealzUseCase()
                _categories.value = allMealsCategory
                cashingMealzUseCase.saveCategoriesToLocal(allMealsCategory.categories)
                cashingMealzUseCase.saveCategoryToLocal(
                    Category(
                        0,
                        idCategory = "22",
                        strCategory = "bassem",
                        strCategoryDescription = "Bassem",
                        strCategoryThumb = "Bassem"
                    )
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getCashedMeals() {
        viewModelScope.launch {
            _categories.value = CategoryResponse(cashingMealzUseCase.getAllCategoriesFromLocal())
        }
    }
}
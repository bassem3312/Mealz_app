package com.bassem.domain.usercase

import com.bassem.domain.repo.MealsRepository


/**
 * @author Bassem Mohsen : basem3312@gmail.com on 3/15/2023.
 */
class GetMealzUseCase(private val mealsRepository: MealsRepository) {
   suspend operator fun invoke() = mealsRepository.getMealsFromRemote()
}
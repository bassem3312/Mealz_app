package com.bassem.data.remote

import com.bassem.domain.entity.CategoryResponse
import retrofit2.http.GET


/**
 * @author Bassem Mohsen : basem3312@gmail.com on 3/15/2023.
 */
interface ApiService {

    @GET("categories.php")
    suspend fun getMeals(): CategoryResponse
}
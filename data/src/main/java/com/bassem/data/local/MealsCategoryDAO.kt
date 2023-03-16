package com.bassem.data.local;

import androidx.room.Dao
import androidx.room.Insert;
import androidx.room.OnConflictStrategy
import androidx.room.Query;

import com.bassem.domain.entity.Category;

/**
 * @author Bassem Mohsen : basem3312@gmail.com on 3/16/2023.
 */

@Dao
interface MealsCategoryDAO {
    @Query("SELECT * FROM category1")
  suspend  fun getAllCategories(): List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCategories(categories: List<Category>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

}

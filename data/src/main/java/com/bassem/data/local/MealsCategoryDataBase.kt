package com.bassem.data.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.bassem.domain.entity.Category


/**
 * @author Bassem Mohsen : basem3312@gmail.com on 3/16/2023.
 */

@Database(
    entities = [Category::class],
    version = 8,
//    autoMigrations = [AutoMigration(from = 2, to = 3)],
    exportSchema = false
)
abstract class MealsCategoryDataBase : RoomDatabase() {
    abstract fun categoryDAO(): MealsCategoryDAO
}
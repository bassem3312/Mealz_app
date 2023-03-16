package com.bassem.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Category1")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "id_category") val idCategory: String,
    @ColumnInfo(name = "str_category1") val strCategory: String,
    @ColumnInfo(name = "str_category_description") val strCategoryDescription: String,
    @ColumnInfo(name = "str_category_thumb") val strCategoryThumb: String
//    @ColumnInfo(name = "str_category_thumb1",defaultValue = "temp") val strCategoryThumb1: String?
)
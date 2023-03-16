package com.bassem.mealzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bassem.mealzapp.ui.MealsAdapter
import com.bassem.mealzapp.ui.MealsCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val categoryViewModel: MealsCategoryViewModel by viewModels<MealsCategoryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categoryViewModel.getCashedMeals()

        categoryViewModel.getMeals()

        val mealsAdapter = MealsAdapter()
        val rv: RecyclerView = findViewById(R.id.category_rv)
        rv.adapter = mealsAdapter

        lifecycleScope.launch {
            categoryViewModel.categories.collect {
                mealsAdapter.submitList(it?.categories)

                it?.categories?.forEach { it ->
                    Log.e("===", it.strCategory)
                }
            }
        }
    }
}
package com.bassem.mealzapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 * @author Bassem Mohsen : basem3312@gmail.com on 3/15/2023.
 */
@HiltAndroidApp
class MealzApp:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
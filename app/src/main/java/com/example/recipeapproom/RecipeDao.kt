package com.example.recipeapproom

import androidx.room.*

@Dao
interface RecipeDao {

    @Query("SELECT * FROM Recipe")
    fun getRecipe(): List<RecipeDetails>

    @Insert
    fun insertRecipe(note: RecipeDetails)

    @Delete
    fun deleteRecipe(note: RecipeDetails)

    @Update
    fun updateRecipe(note: RecipeDetails)
}
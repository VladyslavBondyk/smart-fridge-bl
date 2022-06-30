package com.spdu.repository;

import com.spdu.model.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientRepository {

    List<RecipeIngredient> get(List<Integer> recipeIds);
}

package com.spdu.service;

import com.spdu.model.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientService {

    List<RecipeIngredient> get(List<Integer> recipeIds);
}

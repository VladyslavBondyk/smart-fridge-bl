package com.spdu.repository;

import com.spdu.model.Recipe;

import java.util.List;

public interface RecipeRepository {

    List<Recipe> get(List<Integer> ids);
}

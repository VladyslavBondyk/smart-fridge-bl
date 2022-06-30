package com.spdu.service;

import com.spdu.model.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> get(List<Integer> ids);
}

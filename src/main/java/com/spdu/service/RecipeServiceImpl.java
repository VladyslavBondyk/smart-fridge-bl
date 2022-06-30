package com.spdu.service;

import com.spdu.model.Recipe;
import com.spdu.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> get(List<Integer> ids) {
        return recipeRepository.get(ids);
    }
}

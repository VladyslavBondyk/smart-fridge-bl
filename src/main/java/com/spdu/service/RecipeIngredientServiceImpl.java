package com.spdu.service;

import com.spdu.model.RecipeIngredient;
import com.spdu.repository.RecipeIngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {

    private final RecipeIngredientRepository recipeIngredientRepository;

    public RecipeIngredientServiceImpl(RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    @Override
    public List<RecipeIngredient> get(List<Integer> recipeIds) {
        return recipeIngredientRepository.get(recipeIds);
    }
}

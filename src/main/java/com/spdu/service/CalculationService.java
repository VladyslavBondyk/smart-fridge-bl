package com.spdu.service;

import com.spdu.model.FridgeProduct;
import com.spdu.model.RecipeIngredient;

import java.util.List;
import java.util.Map;

public interface CalculationService {

    Map<Integer, Double> calculateDifferenceAmount(List<FridgeProduct> allFridgeProducts,
                                                   List<RecipeIngredient> recipeIngredients);
}

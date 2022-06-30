package com.spdu.service;

import com.spdu.model.FridgeProduct;
import com.spdu.model.RecipeIngredient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.toMap;

@Service
public class CalculationServiceImpl implements CalculationService {

    public Map<Integer, Double> calculateDifferenceAmount(List<FridgeProduct> allFridgeProducts,
                                                          List<RecipeIngredient> recipeIngredients) {
        Map<Integer, Double> recipeIngredientAmountByProductId = getRecipeIngredientAmountByProductId(recipeIngredients);
        Map<Integer, Double> fridgeAmountByProductId = getFridgeAmountByProductId(allFridgeProducts);

        return recipeIngredientAmountByProductId.entrySet().stream()
            .collect(toMap(
                Map.Entry::getKey,
                recipeIngredient ->
                    getDifference(recipeIngredient.getValue(), fridgeAmountByProductId.get(recipeIngredient.getKey())))
            );
    }

    private Map<Integer, Double> getRecipeIngredientAmountByProductId(List<RecipeIngredient> recipeIngredients) {
        return recipeIngredients.stream()
            .collect(toMap(RecipeIngredient::getProductId, RecipeIngredient::getAmount, Double::sum));
    }

    private Map<Integer, Double> getFridgeAmountByProductId(List<FridgeProduct> fridgeProducts) {
        return fridgeProducts.stream()
            .collect(toMap(FridgeProduct::getProductId, FridgeProduct::getAmount));
    }

    private double getDifference(Double recipeIngredientAmount, Double fridgeAmount) {
        return Objects.nonNull(fridgeAmount)
            ? recipeIngredientAmount - fridgeAmount
            : recipeIngredientAmount;
    }
}

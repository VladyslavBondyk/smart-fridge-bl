package com.spdu.service;

import com.spdu.model.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Service
public class ShoppingListServiceImpl implements ShoppingListService {

    private final FridgeProductService fridgeProductService;
    private final RecipeIngredientService recipeIngredientService;
    private final OrderService orderService;
    private final CalculationService calculationService;

    public ShoppingListServiceImpl(FridgeProductService fridgeProductService,
                                   RecipeIngredientService recipeIngredientService,
                                   OrderService orderService,
                                   CalculationService calculationService) {
        this.fridgeProductService = fridgeProductService;
        this.recipeIngredientService = recipeIngredientService;
        this.orderService = orderService;
        this.calculationService = calculationService;
    }

    @Override
    public List<Order> getShoppingList(List<Integer> recipeIds) {
        List<FridgeProduct> allFridgeProducts = fridgeProductService.getAll();
        List<RecipeIngredient> recipeIngredients = recipeIngredientService.get(recipeIds);

        Map<Integer, Double> calculatedAmountByProductId =
            calculationService.calculateDifferenceAmount(allFridgeProducts, recipeIngredients);

        Map<Integer, Double> filteredAmountByProductId = getFilteredAmountByProductId(calculatedAmountByProductId);

        return orderService.get(filteredAmountByProductId);
    }

    @Override
    public List<Order> getSortedShoppingList(List<Order> orders) {
        return orders.stream()
            .sorted(Comparator.comparing(this::getProductCategoryTitle).thenComparing(this::getProductName))
            .toList();
    }

    @Override
    public BigDecimal getTotals(List<Order> orders) {
        return orders.stream()
            .map(this::getTotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getTotal(Order order) {
        Product product = order.getProduct();
        BigDecimal price = product.getPrice();
        double amount = order.getAmount();

        return price.multiply(BigDecimal.valueOf(amount));
    }

    private String getProductCategoryTitle(Order order) {
        Product product = order.getProduct();
        Category category = product.getCategory();

        return category.getTitle();
    }

    private String getProductName(Order order) {
        Product product = order.getProduct();

        return product.getName();
    }

    private Map<Integer, Double> getFilteredAmountByProductId(Map<Integer, Double> amountByProductId) {
        return amountByProductId.entrySet().stream()
            .filter(amountByProduct -> amountByProduct.getValue() > 0)
            .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}

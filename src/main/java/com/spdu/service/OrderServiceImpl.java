package com.spdu.service;

import com.spdu.model.Order;
import com.spdu.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

@Service
public class OrderServiceImpl implements OrderService {

    private final ProductService productService;

    public OrderServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<Order> get(Map<Integer, Double> amountByProductId) {
        Map<Integer, Product> productToOrderById = getProductById(amountByProductId.keySet());

        return amountByProductId.entrySet().stream()
            .map(recipeIngredient -> createOrder(recipeIngredient, productToOrderById))
            .toList();
    }

    private Order createOrder(Map.Entry<Integer, Double> recipeIngredient,
                              Map<Integer, Product> productToOrderById) {
        Product product = productToOrderById.get(recipeIngredient.getKey());
        Double amount = recipeIngredient.getValue();

        return new Order(product, amount);
    }

    private Map<Integer, Product> getProductById(Set<Integer> recipeIngredientProductIds) {
        List<Product> products = productService.get(recipeIngredientProductIds);

        return products.stream()
            .collect(toMap(Product::getId, Function.identity()));
    }
}

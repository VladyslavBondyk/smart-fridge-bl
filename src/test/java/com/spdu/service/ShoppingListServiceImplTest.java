package com.spdu.service;

import com.spdu.model.Category;
import com.spdu.model.Order;
import com.spdu.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ShoppingListServiceImplTest {

    @Mock
    private FridgeProductService fridgeProductService;
    @Mock
    private RecipeIngredientService recipeIngredientService;
    @Mock
    private OrderService orderService;
    @Mock
    private CalculationService calculationService;

    private ShoppingListService shoppingListService;

    @BeforeEach
    void setUp() {
        shoppingListService = new ShoppingListServiceImpl(
            fridgeProductService,
            recipeIngredientService,
            orderService,
            calculationService);
    }

    @Test
    void getSortedShoppingList() {
        List<Order> expectedResult = List.of(
            createOrder(createProduct("cheese", Category.DAIRY)),
            createOrder(createProduct("milk", Category.DAIRY)),
            createOrder(createProduct("apple", Category.FRUITS)),
            createOrder(createProduct("banana", Category.FRUITS))
        );

        List<Order> actualResult = shoppingListService.getSortedShoppingList(getOrders());

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getTotals() {
        BigDecimal expectedResult = new BigDecimal("187.50");

        List<Order> orders = List.of(
            createOrder(createProduct(new BigDecimal("100")), 0.1),
            createOrder(createProduct(new BigDecimal("55.5")), 1.0),
            createOrder(createProduct(new BigDecimal("61")), 2.0)
        );
        BigDecimal actualResult = shoppingListService.getTotals(orders);

        assertEquals(expectedResult, actualResult);
    }

    private List<Order> getOrders() {
        Product milk = createProduct("milk", Category.DAIRY);
        Product apple = createProduct("apple", Category.FRUITS);
        Product cheese = createProduct("cheese", Category.DAIRY);
        Product banana = createProduct("banana", Category.FRUITS);

        List<Order> orders = new ArrayList<>();
        orders.add(createOrder(milk));
        orders.add(createOrder(apple));
        orders.add(createOrder(cheese));
        orders.add(createOrder(banana));

        return orders;
    }

    private Order createOrder(Product product, Double amount) {
        return new Order(product, amount);
    }

    private Order createOrder(Product product) {
        return new Order(product, 1.0);
    }

    private Product createProduct(BigDecimal price) {
        Product product = new Product();
        product.setPrice(price);

        return product;
    }

    private Product createProduct(String name, Category category) {
        Product product = new Product();
        product.setName(name);
        product.setCategory(category);

        return product;
    }
}

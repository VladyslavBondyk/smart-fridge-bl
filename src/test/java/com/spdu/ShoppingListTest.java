package com.spdu;

import com.spdu.model.Category;
import com.spdu.model.Measure;
import com.spdu.model.Order;
import com.spdu.model.Product;
import com.spdu.service.ShoppingListService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static com.spdu.model.Category.*;
import static com.spdu.model.Measure.KILOGRAM;
import static com.spdu.model.Measure.PACK;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class ShoppingListTest {

    @Autowired
    private ShoppingListService shoppingListService;

    @Test
    @Transactional
    @Sql("shopping-list-data.sql")
    void getShoppingList() {
        Product eggs = createProduct(2, "Яйця", GROCERY, PACK, BigDecimal.valueOf(26.0));
        Product cheese = createProduct(4, "Сир голандський", DAIRY, KILOGRAM, BigDecimal.valueOf(140.0));
        Product sausage = createProduct(5, "Ковбаса Салямі", MEAT, KILOGRAM, BigDecimal.valueOf(185.0));
        Product corn = createProduct(6, "Кукурудза", GROCERY, KILOGRAM, BigDecimal.valueOf(60.0));

        List<Order> expectedResult = List.of(
            createOrder(eggs, 0.5),
            createOrder(cheese, 0.2),
            createOrder(sausage, 0.1),
            createOrder(corn, 0.15)
        );
        List<Order> actualResult = shoppingListService.getShoppingList(List.of(1));

        assertEquals(expectedResult, actualResult);
    }

    private Order createOrder(Product product, Double amount) {
        return new Order(product, amount);
    }

    private Product createProduct(Integer id,
                                  String name,
                                  Category category,
                                  Measure measure,
                                  BigDecimal price) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setCategory(category);
        product.setMeasure(measure);
        product.setPrice(price);

        return product;
    }
}

package com.spdu.repository;

import com.spdu.mapper.ProductMapper;
import com.spdu.model.Category;
import com.spdu.model.Measure;
import com.spdu.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
@ActiveProfiles("test")
class ProductRepositoryImplTest {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        ProductMapper productMapper = new ProductMapper();
        productRepository = new ProductRepositoryImpl(namedParameterJdbcTemplate, productMapper);
    }

    @Test
    @Sql("product-data.sql")
    void getAllWhenProductsExistShouldReturnActualResult() {
        List<Product> expectedResult = List.of(
            createProduct(1, "test-1"),
            createProduct(2, "test-2")
        );

        List<Product> actualResult = productRepository.get(List.of(1, 2));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getAllWhenProductsNotExistShouldReturnEmptyList() {
        List<Product> expectedResult = emptyList();

        List<Product> actualResult = productRepository.get(List.of(1, 2));

        assertEquals(expectedResult, actualResult);
    }

    private Product createProduct(int id, String name) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(BigDecimal.valueOf(50.0));
        product.setCategory(Category.GROCERY);
        product.setMeasure(Measure.KILOGRAM);

        return product;
    }
}

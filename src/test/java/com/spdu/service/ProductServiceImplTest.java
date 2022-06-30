package com.spdu.service;

import com.spdu.model.Category;
import com.spdu.model.Measure;
import com.spdu.model.Product;
import com.spdu.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    private static final int PRODUCT_ID = 1;

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    void getAllProductsByIdWhenProductsExistShouldReturnActualResult() {
        List<Product> expectedResult = List.of(createProduct());

        when(productRepository.get(Set.of(PRODUCT_ID))).thenReturn(List.of(createProduct()));

        List<Product> actualResult = productService.get(Set.of(PRODUCT_ID));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getAllProductsByIdWhenProductsExistShouldReturnEmptyMap() {
        List<Product> expectedResult = emptyList();

        when(productRepository.get(Set.of(PRODUCT_ID))).thenReturn(emptyList());

        List<Product> actualResult = productService.get(Set.of(PRODUCT_ID));

        assertEquals(expectedResult, actualResult);
    }

    private Product createProduct() {
        Product product = new Product();
        product.setId(1);
        product.setName("test");
        product.setPrice(BigDecimal.valueOf(50.0));
        product.setCategory(Category.GROCERY);
        product.setMeasure(Measure.KILOGRAM);

        return product;
    }
}

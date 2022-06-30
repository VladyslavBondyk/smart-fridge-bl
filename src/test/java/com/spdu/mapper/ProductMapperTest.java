package com.spdu.mapper;

import com.spdu.model.Category;
import com.spdu.model.Measure;
import com.spdu.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductMapperTest {

    @Mock
    private ResultSet resultSet;

    private ProductMapper productMapper;

    @BeforeEach
    void setUp() {
        productMapper = new ProductMapper();
    }

    @Test
    void mapRow() throws SQLException {
        Product expectedResult = createProduct();

        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name")).thenReturn("test");
        when(resultSet.getString("measure")).thenReturn("KILOGRAM");
        when(resultSet.getString("category")).thenReturn("GROCERY");
        when(resultSet.getDouble("price")).thenReturn(50.0);

        Product actualResult = productMapper.mapRow(resultSet, 0);

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

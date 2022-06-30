package com.spdu.mapper;

import com.spdu.model.Category;
import com.spdu.model.Measure;
import com.spdu.model.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setMeasure(Measure.valueOf(rs.getString("measure")));
        product.setCategory(Category.valueOf(rs.getString("category")));
        product.setPrice(BigDecimal.valueOf(rs.getDouble("price")));

        return product;
    }
}

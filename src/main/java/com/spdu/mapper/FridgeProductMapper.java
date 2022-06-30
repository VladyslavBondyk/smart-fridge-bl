package com.spdu.mapper;

import com.spdu.model.FridgeProduct;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FridgeProductMapper implements RowMapper<FridgeProduct> {

    @Override
    public FridgeProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
        FridgeProduct fridgeProduct = new FridgeProduct();
        fridgeProduct.setProductId(rs.getInt("product_id"));
        fridgeProduct.setAmount(rs.getDouble("amount"));

        return fridgeProduct;
    }
}

package com.spdu.repository;

import com.spdu.mapper.FridgeProductMapper;
import com.spdu.model.FridgeProduct;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FridgeProductRepositoryImpl implements FridgeProductRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final FridgeProductMapper fridgeProductMapper;

    public FridgeProductRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate, FridgeProductMapper fridgeProductMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.fridgeProductMapper = fridgeProductMapper;
    }

    @Override
    public List<FridgeProduct> getAll() {
        String sql = "SELECT product_id, amount FROM fridge_product";

        return jdbcTemplate.query(sql, fridgeProductMapper);
    }
}

package com.spdu.repository;

import com.spdu.mapper.ProductMapper;
import com.spdu.model.Product;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final ProductMapper productMapper;

    public ProductRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate, ProductMapper productMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> get(Collection<Integer> ids) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("ids", ids);

        String sql = "SELECT id, name, measure, category, price FROM product WHERE id IN (:ids)";

        return jdbcTemplate.query(sql, parameterSource, productMapper);
    }
}

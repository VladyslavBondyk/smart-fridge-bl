package com.spdu.repository;

import com.spdu.mapper.RecipeMapper;
import com.spdu.model.Recipe;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    public final RecipeMapper recipeMapper;

    public RecipeRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate, RecipeMapper recipeMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.recipeMapper = recipeMapper;
    }

    @Override
    public List<Recipe> get(List<Integer> ids) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("ids", ids);

        String sql = "SELECT id, name, product_id, amount FROM dish WHERE id IN (:ids)";

        return jdbcTemplate.query(sql, parameterSource, recipeMapper);
    }
}

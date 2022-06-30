package com.spdu.repository;

import com.spdu.mapper.RecipeIngredientMapper;
import com.spdu.model.RecipeIngredient;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecipeIngredientRepositoryImpl implements RecipeIngredientRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RecipeIngredientMapper recipeIngredientMapper;

    public RecipeIngredientRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate,
                                          RecipeIngredientMapper recipeIngredientMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.recipeIngredientMapper = recipeIngredientMapper;
    }

    @Override
    public List<RecipeIngredient> get(List<Integer> recipeIds) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("recipeIds", recipeIds);

        String sql = "SELECT recipe_id, product_id, amount FROM recipe_ingredient WHERE recipe_id IN (:recipeIds)";

        return jdbcTemplate.query(sql, parameterSource, recipeIngredientMapper);
    }
}

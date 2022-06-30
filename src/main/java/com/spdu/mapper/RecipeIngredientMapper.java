package com.spdu.mapper;

import com.spdu.model.RecipeIngredient;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RecipeIngredientMapper implements RowMapper<RecipeIngredient> {

    @Override
    public RecipeIngredient mapRow(ResultSet rs, int rowNum) throws SQLException {
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setRecipeId(rs.getInt("recipe_id"));
        recipeIngredient.setProductId(rs.getInt("product_id"));
        recipeIngredient.setAmount(rs.getDouble("amount"));

        return recipeIngredient;
    }
}

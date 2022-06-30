package com.spdu.mapper;

import com.spdu.model.Recipe;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RecipeMapper implements RowMapper<Recipe> {

    @Override
    public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
        Recipe recipe = new Recipe();
        recipe.setId(rs.getInt("id"));
        recipe.setName(rs.getString("name"));

        return recipe;
    }
}

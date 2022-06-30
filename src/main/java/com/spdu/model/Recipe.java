package com.spdu.model;

import java.util.List;
import java.util.Objects;

public class Recipe {

    private Integer id;
    private String name;
    private List<RecipeIngredient> recipeIngredients;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id.equals(recipe.id) && name.equals(recipe.name)
            && recipeIngredients.equals(recipe.recipeIngredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, recipeIngredients);
    }

    @Override
    public String toString() {
        return "Recipe{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", recipeIngredients=" + recipeIngredients +
            '}';
    }
}

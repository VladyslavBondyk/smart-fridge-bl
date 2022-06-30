package com.spdu.model;

import java.util.Objects;

public class RecipeIngredient {

    private Integer recipeId;
    private Integer productId;
    private double amount;

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(recipeId, that.recipeId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, productId, amount);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
            "recipeId=" + recipeId +
            ", productId=" + productId +
            ", amount=" + amount +
            '}';
    }
}

package com.spdu.model;

import java.util.Objects;

public class FridgeProduct {

    private Integer productId;
    private double amount;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FridgeProduct that = (FridgeProduct) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, amount);
    }

    @Override
    public String toString() {
        return "FridgeProduct{" +
            "productId=" + productId +
            ", amount=" + amount +
            '}';
    }
}

package com.spdu.model;

import java.util.Objects;

public class Order {

    private final Product product;
    private final double amount;

    public Order(Product product, double amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order that = (Order) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, amount);
    }

    @Override
    public String toString() {
        return "Order{" +
            "product=" + product +
            ", amount=" + amount +
            '}';
    }
}

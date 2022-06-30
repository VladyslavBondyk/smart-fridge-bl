package com.spdu.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Measure measure;
    private Category category;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id)
            && Objects.equals(name, product.name)
            && Objects.equals(price, product.price)
            && measure == product.measure
            && category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, measure, category);
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", measure=" + measure +
            ", category=" + category +
            '}';
    }
}

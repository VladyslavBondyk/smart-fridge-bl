package com.spdu.repository;

import com.spdu.model.Product;

import java.util.Collection;
import java.util.List;

public interface ProductRepository {

    List<Product> get(Collection<Integer> ids);
}

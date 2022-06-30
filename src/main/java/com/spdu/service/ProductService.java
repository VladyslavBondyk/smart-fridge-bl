package com.spdu.service;

import com.spdu.model.Product;

import java.util.Collection;
import java.util.List;

public interface ProductService {

    List<Product> get(Collection<Integer> ids);
}

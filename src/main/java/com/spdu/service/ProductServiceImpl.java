package com.spdu.service;

import com.spdu.model.Product;
import com.spdu.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> get(Collection<Integer> ids) {
        return productRepository.get(ids);
    }
}

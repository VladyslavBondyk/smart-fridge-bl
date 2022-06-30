package com.spdu.service;

import com.spdu.model.FridgeProduct;
import com.spdu.repository.FridgeProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FridgeProductServiceImpl implements FridgeProductService {

    private final FridgeProductRepository fridgeProductRepository;

    public FridgeProductServiceImpl(FridgeProductRepository fridgeProductRepository) {
        this.fridgeProductRepository = fridgeProductRepository;
    }

    @Override
    public List<FridgeProduct> getAll() {
        return fridgeProductRepository.getAll();
    }
}

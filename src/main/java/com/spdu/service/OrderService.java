package com.spdu.service;

import com.spdu.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Order> get(Map<Integer, Double> amountByProductId);
}

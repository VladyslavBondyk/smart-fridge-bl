package com.spdu.service;

import com.spdu.model.Order;

import java.math.BigDecimal;
import java.util.List;

public interface PrintService {

    void print(List<Order> sortedShoppingList, BigDecimal totals);
}

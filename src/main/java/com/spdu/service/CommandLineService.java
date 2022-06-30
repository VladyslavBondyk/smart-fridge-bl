package com.spdu.service;

import com.spdu.model.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CommandLineService implements CommandLineRunner {

    private final ShoppingListService shoppingListService;
    private final PrintService printService;

    public CommandLineService(ShoppingListService shoppingListService,
                              PrintService printService) {
        this.shoppingListService = shoppingListService;
        this.printService = printService;
    }

    @Override
    public void run(String... args) {
        List<Order> shoppingList = shoppingListService.getShoppingList(List.of(1, 2, 3, 4));
        List<Order> sortedShoppingList = shoppingListService.getSortedShoppingList(shoppingList);
        BigDecimal totals = shoppingListService.getTotals(shoppingList);

       printService.print(sortedShoppingList, totals);
    }
}

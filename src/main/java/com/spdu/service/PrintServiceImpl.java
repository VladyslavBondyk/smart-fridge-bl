package com.spdu.service;

import com.spdu.model.Order;
import com.spdu.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

@Service
public class PrintServiceImpl implements PrintService {

    private static final DecimalFormat FORMAT = new DecimalFormat("0.00");

    @Override
    public void print(List<Order> sortedShoppingList, BigDecimal totals) {
        System.out.println("шопінг-ліст:");
        String titleFormat = String.format(
            "%-3s %-20s %-10s %-10s %-10s %-15s",
            "№",
            "Назва продукта",
            "Ціна (грн)",
            "Кількість",
            "Сума (грн)",
            "Категорія"
        );
        System.out.println(titleFormat);

        print(sortedShoppingList);

        System.out.println("===================================================================");
        String totalsFormat = String.format("До сплати %s грн.", FORMAT.format(totals));
        System.out.println(totalsFormat);
    }


    private void print(List<Order> orders) {
        int count = 1;
        for (Order order : orders) {
            double amount = order.getAmount();
            Product product = order.getProduct();
            BigDecimal price = product.getPrice();
            String format = String.format(
                "%-3s %-20s %-10s %-3s %-5s %-10s %-5s",
                count++,
                product.getName(),
                FORMAT.format(price),
                FORMAT.format(amount),
                product.getMeasure().getTitle(),
                FORMAT.format(price.multiply(BigDecimal.valueOf(amount))),
                product.getCategory().getTitle()
            );

            System.out.println(format);
        }
    }
}

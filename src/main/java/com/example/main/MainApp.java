package com.example.main;

import com.example.dao.ProductDAO;
import com.example.dao.OrderDAO;
import com.example.entity.*;

import java.time.LocalDate;
import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAO();
        OrderDAO orderDAO = new OrderDAO();

        // Create Products
        Product p1 = new Product();
        p1.setProductName("Laptop");
        p1.setPrice(60000);

        Product p2 = new Product();
        p2.setProductName("Mouse");
        p2.setPrice(500);

        productDAO.saveProduct(p1);
        productDAO.saveProduct(p2);

        // Create Order
        Order order = new Order();
        order.setCustomerName("Gopal");
        order.setOrderDate(LocalDate.now());

        // Order Items
        OrderItem item1 = new OrderItem();
        item1.setProduct(p1);
        item1.setOrder(order);
        item1.setQuantity(1);

        OrderItem item2 = new OrderItem();
        item2.setProduct(p2);
        item2.setOrder(order);
        item2.setQuantity(2);

        order.getItems().add(item1);
        order.getItems().add(item2);

        orderDAO.saveOrder(order);

        System.out.println("Order saved successfully!");
    }
}
package com.example.dao;

import com.example.entity.OrderItem;
import com.example.util.JPAUtil;

import jakarta.persistence.EntityManager;

public class OrderItemDAO {

    public void saveOrderItem(OrderItem item) {

        EntityManager entityManager = JPAUtil.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(item);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
package com.example.dao;

import com.example.entity.Order;
import com.example.util.JPAUtil;

import jakarta.persistence.EntityManager;
import java.util.List;

public class OrderDAO {

    public void saveOrder(Order order) {

        EntityManager entityManager = JPAUtil.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public List<Order> getAllOrders() {

        EntityManager entityManager = JPAUtil.getEntityManager();

        List<Order> orders =
                entityManager.createQuery("from Order", Order.class).getResultList();

        entityManager.close();
        return orders;
    }
}
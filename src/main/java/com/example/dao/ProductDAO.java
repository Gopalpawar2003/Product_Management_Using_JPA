package com.example.dao;

import com.example.entity.Product;
import com.example.util.JPAUtil;

import jakarta.persistence.EntityManager;
import java.util.List;

public class ProductDAO {

    public void saveProduct(Product product) {

        EntityManager entityManager = JPAUtil.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public List<Product> getAllProducts() {

        EntityManager entityManager = JPAUtil.getEntityManager();

        List<Product> list =
                entityManager.createQuery("from Product", Product.class).getResultList();

        entityManager.close();
        return list;
    }
}
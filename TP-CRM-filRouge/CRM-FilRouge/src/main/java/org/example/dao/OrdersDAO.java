package org.example.dao;

import org.example.entity.Client;
import org.example.entity.Order;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class OrdersDAO {

    public static void create(Order orderToCreate){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(orderToCreate);
        tx.commit();
    }

    public static Order findById(long id){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Order order = entityManager.find(Order.class, id);

        return order;
    }

    public static List<Order> findAll(){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select o from Order o");
        return findAllQuery.getResultList();
    }


    public static void delete(Order order){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(order);
        tx.commit();
    }

    public static void deleteById(long id){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Order orderToDelete = findById(id);
        delete(orderToDelete);

    }

    public static void updateOrder(long id, Order orderNewData){

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Order orderToUpdate = OrdersDAO.findById(id);
        orderToUpdate.setNotNullData(orderNewData);
        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(orderToUpdate);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }

    }

}

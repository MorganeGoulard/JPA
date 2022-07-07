package org.example.dao;

import org.example.entity.Customer;
import org.example.entity.Payment;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PaymentDao {

    public static void createPayment(Payment paymentToCreate) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(paymentToCreate);
        tx.commit();
    }

    public static Payment findById(long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Payment payment = entityManager.find(Payment.class, id );

        return payment;
    }

    public static List<Payment> findAll(){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select p from Payment p");
        return findAllQuery.getResultList();
    }

    public static void deletePayment(Payment paymentToDelete){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(paymentToDelete);
        tx.commit();
    }

    public static void deletePaymentById(long id){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Payment paymentToDelete = findById(id);
        deletePayment(paymentToDelete);
    }

    public static void updatePayment (long id, Payment newPaymentData){

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Payment paymentToUpdate = findById(id);
        paymentToUpdate.setNotNullData(newPaymentData);
        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(paymentToUpdate);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        }

    }

}

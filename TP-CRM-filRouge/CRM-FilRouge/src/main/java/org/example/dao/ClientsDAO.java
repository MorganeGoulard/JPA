package org.example.dao;

import org.example.entity.Client;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ClientsDAO {

    public static void create(Client clientToCreate){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(clientToCreate);
        tx.commit();
    }

    public static Client findById(long id){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Client client = entityManager.find(Client.class, id);

        return client;
    }

    public static List<Client> findAll(){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select c from Client c");
        return findAllQuery.getResultList();
    }

    public static void delete(Client client){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(client);
        tx.commit();
    }

    public static void deleteById(long id){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Client clientToDelete = findById(id);
        delete(clientToDelete);

    }

    public static void updateClient(long id, Client clientNewData){

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Client clientToUpdate = ClientsDAO.findById(id);
        clientToUpdate.setNotNullData(clientNewData);
        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(clientToUpdate);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }

    }

}

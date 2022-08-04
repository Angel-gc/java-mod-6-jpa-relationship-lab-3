package org.example;

import Model.Cat;
import Model.Owner;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {
        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Owner owner = new Owner();
        Cat cat = new Cat();

        cat.setName("Mozart");
        owner.setName("Adrian");

        cat.addOwner(owner);
        owner.addCat(cat);

        entityManager.persist(cat);
        entityManager.persist(owner);

        transaction.commit();
        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}
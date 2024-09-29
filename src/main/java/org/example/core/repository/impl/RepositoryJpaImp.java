package org.example.core.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.example.core.repository.Repository;


public abstract class RepositoryJpaImp<T> implements Repository<T> {
    protected EntityManager em;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgresUnit");

    public RepositoryJpaImp() {
        if (em==null) {
            em = emf.createEntityManager();
        }
    }

    @Override
    public void insert(T data) {

        try {
            em.getTransaction().begin();
            em.merge(data);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    // @Override
    // public List<T> selectAll() {
    //     return  this.em.createQuery("SELECT c FROM Client c", type).getResultList();
    // }
    
}

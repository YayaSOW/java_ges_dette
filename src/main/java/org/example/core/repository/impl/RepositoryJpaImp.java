package org.example.core.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.example.core.repository.Repository;
import java.util.List;
public abstract class RepositoryJpaImp<T> implements Repository<T> {
    protected EntityManager em;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlUnit");
    protected Class<T> type;

    public RepositoryJpaImp(Class<T> type) {
        if (em == null) {
            em = emf.createEntityManager();
        }
        this.type = type;
    }

    @Override
    public void insert(T data) {

        try {
            em.getTransaction().begin();
            em.merge(data);
            // em.persist(data);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    } 

    @Override
    public List<T> selectAll() {
        String sql = String.format("SELECT c FROM %s c", type.getName());
        return this.em.createQuery(sql, type)
                .getResultList();
    }

}

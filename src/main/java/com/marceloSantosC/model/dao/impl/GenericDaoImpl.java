package com.marceloSantosC.model.dao.impl;

import com.marceloSantosC.model.dao.GenericDao;
import com.marceloSantosC.model.entity.GenericEntity;
import com.marceloSantosC.utils.JpaUtil;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public abstract class GenericDaoImpl<E extends GenericEntity<PK>, PK> implements GenericDao<E, PK> {

    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        if (this.entityManager == null || !this.entityManager.isOpen()) {
            this.setEntityManager(JpaUtil.getEntityManager());
        }
        return this.entityManager;
    }

    protected abstract Class<E> getEntityClass();

    @Override
    public E getById(PK id) {
        return this.getEntityManager().find(this.getEntityClass(), id);
    }

    @Override
    public E save(E entity) {
        this.getEntityManager().getTransaction().begin();
        entity = this.getEntityManager().merge(entity);
        try {
            this.getEntityManager().getTransaction().commit();
        } catch (RollbackException exception) {
            return null;
        }
        return entity;
    }

    @Override
    public List<E> getAll(Integer firstResult, Integer maxResults) {
        String className = this.getEntityClass().getSimpleName();
        TypedQuery<E> query = this.getEntityManager().createQuery("FROM " + className, this.getEntityClass());
        if (maxResults != null) query.setMaxResults(maxResults);
        if (firstResult != null) query.setFirstResult(firstResult);
        return Optional.ofNullable(query.getResultList()).orElse(new ArrayList<>());
    }

    @Override
    public Boolean delete(PK id) {
        try {
            E entity = this.getById(id);
            if (entity == null) return null;
            this.getEntityManager().getTransaction().begin();
            this.getEntityManager().remove(entity);
            this.getEntityManager().getTransaction().commit();
            return true;
        } catch (RollbackException exception) {
            this.getEntityManager().getTransaction().rollback();
            return false;
        }
    }

    @Override
    public E update(E entity, PK id) {
        entity.setPrimaryKey(id);
        return this.save(entity);
    }
}

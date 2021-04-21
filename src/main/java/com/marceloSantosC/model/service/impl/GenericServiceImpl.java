package com.marceloSantosC.model.service.impl;

import com.marceloSantosC.model.dao.GenericDao;
import com.marceloSantosC.model.entity.GenericEntity;
import com.marceloSantosC.model.service.GenericService;

import java.util.List;
import java.util.function.Consumer;

public abstract class GenericServiceImpl<E extends GenericEntity<PK>, PK> implements GenericService<E, PK> {

    public abstract GenericDao<E, PK>  getDao();

    @Override
    public E getById(PK id) {
        return this.getDao().getById(id);
    }

    @Override
    public E save(E entity, Consumer<E> beforeUpdate, Consumer<E> afterUpdate) {
        if (beforeUpdate != null) beforeUpdate.accept(entity);
        this.save(entity);
        if (afterUpdate != null) afterUpdate.accept(entity);
        return entity;
    }

    @Override
    public E update(E entity, PK id) {
        return this.getDao().update(entity, id);
    }

    @Override
    public E save(E entity) {
        return this.getDao().save(entity);
    }

    @Override
    public List<E> getAll(Integer firstResult, Integer maxResults) {
        return this.getDao().getAll(firstResult, maxResults);
    }

    @Override
    public Boolean delete(PK id) {
        return this.getDao().delete(id);
    }
}

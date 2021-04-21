package com.marceloSantosC.model.dao;

import com.marceloSantosC.model.entity.GenericEntity;

import java.util.List;

public interface GenericDao<E extends GenericEntity<PK>, PK> {

     E getById(PK id);

     E save(E entity);

     List<E> getAll(Integer firstResult, Integer maxResults);

    Boolean delete(PK id);

    E update(E entity, PK id);
}

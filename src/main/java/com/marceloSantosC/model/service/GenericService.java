package com.marceloSantosC.model.service;

import java.util.List;
import java.util.function.Consumer;

public interface GenericService<E, PK> {

    E getById(PK id);

    E save(E entity);

    E save(E entity, Consumer<E> beforeUpdate, Consumer<E> afterUpdate);

    E update(E entity, PK id);

    List<E> getAll(Integer firstResult, Integer maxResults);

    Boolean delete(PK id);
}

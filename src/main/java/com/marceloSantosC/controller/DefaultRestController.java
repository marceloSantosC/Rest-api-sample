package com.marceloSantosC.controller;

import com.marceloSantosC.model.service.GenericService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class DefaultRestController<E, PK> {

    public abstract GenericService<E, PK> getService();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<E>> get(@RequestParam(required = false) Integer firstResult,
                                       @RequestParam(required = false) Integer maxResults) {

        List<E> entities = this.getService().getAll(firstResult, maxResults);
        if (entities.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(entities);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<E> getById(@PathVariable PK id) {

        try {
            E entity = this.getService().getById(id);
            if (entity == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return ResponseEntity.ok(entity);
        } catch (Exception exception) {
            exception.printStackTrace(System.err);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable PK id) {

        Boolean result = this.getService().delete(id);
        if (result == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        if (!result) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<E> save(@RequestBody E entity) {

        entity = this.getService().save(entity);
        if (entity == null) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody E entity, @PathVariable PK id) {

        entity = this.getService().update(entity, id);
        if (entity == null) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

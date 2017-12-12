package com.embedded.workshop.controller;

import com.embedded.workshop.exception.EventException;
import com.embedded.workshop.service.impl.GenericServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public abstract class GenericController<T, R extends JpaRepository<T, Integer>> implements CrudController<T> {
    private GenericServiceImpl<T,R> service;

    GenericController(GenericServiceImpl<T, R> service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public ResponseEntity<T> create(@RequestBody T t) {
        return new ResponseEntity<T>(service.create(t), HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    @Override
    public ResponseEntity<T> update(@PathVariable("id") Integer id, @RequestBody T t) throws EventException {
        T updateT = service.getById(id);
        if(updateT == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.update(t), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<T>> all() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @Override
    public ResponseEntity<T> getById(@PathVariable("id") Integer id) throws EventException {
        T t = service.getById(id);
        if(t == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(t, HttpStatus.OK);
    }
}

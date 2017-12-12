package com.embedded.workshop.controller;

import com.embedded.workshop.exception.EventException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudController<T> {
    ResponseEntity<T> create(T t);
    ResponseEntity<T> update(Integer id, T t) throws EventException;
    ResponseEntity<Void> delete(Integer id);
    ResponseEntity<List<T>> all();
    ResponseEntity<T> getById(Integer id) throws EventException;
}

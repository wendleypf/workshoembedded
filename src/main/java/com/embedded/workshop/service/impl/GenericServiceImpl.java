package com.embedded.workshop.service.impl;

import com.embedded.workshop.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class GenericServiceImpl<T, R extends JpaRepository<T, Integer>> implements CrudService<T> {
    @Autowired
    protected R repository;

    @Override
    public T create(T t) {
        return repository.save(t);
    }

    @Override
    public T update(T t) {
        return repository.save(t);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public void removeById(Integer id) {
        if(repository.exists(id)){
            repository.delete(id);
        }
    }

    @Override
    public void removeAll() {
        repository.deleteAll();
    }
}

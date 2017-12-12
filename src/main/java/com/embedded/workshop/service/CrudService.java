package com.embedded.workshop.service;

import java.util.List;

public interface CrudService<T> {
    T create(T t);

    T update(T t);

    List<T> getAll();

    T getById(Integer id);

    void removeById(Integer id);

    void removeAll();
}

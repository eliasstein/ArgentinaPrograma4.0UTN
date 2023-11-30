package com.proyecto.services;

import java.util.List;

public interface BaseService<E> {
    public List<E> findAll() throws Exception;
    public E findById(int id) throws Exception;
    public E save(E entity) throws Exception;
    public E update(int id, E entity) throws Exception;
    public boolean delete(int id) throws Exception;
}


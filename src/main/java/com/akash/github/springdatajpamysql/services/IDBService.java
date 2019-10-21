package com.akash.github.springdatajpamysql.services;

import java.util.Collection;

public interface IDBService<T> {

    Collection<T> fetchAll();

    T fetchById(Long id);

    T save(T t);

    T update(T t);

    void deleteById(Long id);
}

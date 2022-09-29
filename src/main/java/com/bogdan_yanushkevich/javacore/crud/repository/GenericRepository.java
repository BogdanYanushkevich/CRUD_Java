package com.bogdan_yanushkevich.javacore.crud.repository;

import java.util.List;

public interface GenericRepository<T, ID> {

    T create(T obj);

    T read(Long ID);

    T update(T obj);

    void delete(T obj);

    List<T> getALl();

}

package com.vini.mysite.core.dao;

public interface GenericDao< T > {
  
    T create(T t);

    void delete(Object id);

    T findById(Object id);

    T update(T t);   
}
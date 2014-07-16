package com.vini.mysite.core.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDaoImpl< T > implements GenericDao< T > {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class< T > type;

    @SuppressWarnings("unchecked")
	public GenericDaoImpl() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) type;
        this.type = (Class) pt.getActualTypeArguments()[0];
    }

   
    public T create(final T t) {
        this.entityManager.persist(t);
        return t;
    }

    public void delete(final Object id) {
        this.entityManager.remove(this.entityManager.getReference(type, id));
    }

    public T findById(final Object id) {
        return (T) this.entityManager.find(type, id);
    }

    public T update(final T t) {
        return this.entityManager.merge(t);    
    }
   

}
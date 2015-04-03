package com.summer.common.repository;

import com.summer.common.domain.IdEntity;
import com.summer.common.utils.ReflectionUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Allen on 2015/3/24.
 */
public class CrudRepositoryImpl
        <T extends IdEntity,PK extends Serializable> implements CrudRepository<T,PK> {

    protected Class<T> entityClass;

    @Autowired
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public CrudRepositoryImpl() {
        entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public T get(PK id) {
        return (T)getCurrentSession().get(entityClass,id);
    }

    public T load(PK id) {
        return (T)getCurrentSession().load(entityClass,id);
    }

    @Override
    public T save(T entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public void update(T entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void delete(PK id) {
        Session session = getCurrentSession();
        session.delete(session.load(entityClass, (Long) id));
    }

    @Override
    public List<T> getAll() {
        return getCurrentSession().createCriteria(entityClass).list();
    }

    @Override
    public List<T> query(String sql, Object[] params) {
        Query query = getCurrentSession().createQuery(sql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i,params[i]);
        }
        return query.list();
    }

}

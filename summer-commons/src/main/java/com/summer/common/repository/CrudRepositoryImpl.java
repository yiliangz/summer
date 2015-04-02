package com.summer.common.repository;

import com.summer.common.annotation.MyBatisRepository;
import com.summer.common.domain.IdEntity;
import com.summer.common.utils.ReflectionUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
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

    protected HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public CrudRepositoryImpl() {
        entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected HibernateTemplate getHibernateTemplate() {
        if (hibernateTemplate == null) {
            hibernateTemplate = new HibernateTemplate(sessionFactory);
        }
//        hibernateTemplate.setCheckWriteOperations(false);
        return hibernateTemplate;
    }

    public T get(PK id) {
        return getHibernateTemplate().get(entityClass,id);
    }
    public T load(PK id) {
        return getHibernateTemplate().load(entityClass,id);
    }

    @Override
    public T save(T entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public void delete(PK id) {
        hibernateTemplate = getHibernateTemplate();
        Session sesison = sessionFactory.getCurrentSession();
        Object entity = sesison.get(entityClass, (Long) id);
        sesison.delete(entity);
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public List<T> query(String sql, Object[] params) {
        return null;
    }

}

package com.summer.common.repository;

import com.summer.common.domain.IdEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Allen on 2015/3/24.
 */
public abstract class CrudRepositoryImpl
        <PK extends Serializable,T extends IdEntity> implements CrudRepository<PK,T> {

    @Resource
    private SessionFactory sessionFactory;

    private HibernateTemplate hibernateTemplate;

    private HibernateTemplate getHibernateTemplate() {
        if (hibernateTemplate == null) {
            hibernateTemplate = new HibernateTemplate(sessionFactory);
        }
        return hibernateTemplate;
    }

    @Override
    public T get(PK id) {
//        return getHibernateTemplate().get(,id);
        return null;
    }

    @Override
    public T save(T entity) {
        return null;
    }

    @Override
    public void delete(PK id) {

    }

    @Override
    public List<T> getAll() {
        return null;
    }

}

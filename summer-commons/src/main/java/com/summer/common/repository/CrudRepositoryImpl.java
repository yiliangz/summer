package com.summer.common.repository;

import com.summer.common.page.Page;
import com.summer.common.page.PageImpl;
import com.summer.common.page.PageRequest;
import com.summer.common.persistence.CriteriaParser;
import com.summer.common.persistence.IdEntity;
import com.summer.common.utils.ReflectionUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2015/3/24.
 */
public class CrudRepositoryImpl
        <T extends IdEntity, PK extends Serializable> implements CrudRepository<T, PK> {

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
        return (T) getCurrentSession().get(entityClass, id);
    }

    public T load(PK id) {
        return (T) getCurrentSession().load(entityClass, id);
    }

    @Override
    public T save(T entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    public List<T> saveEntities(List<T> entities) {
        for (T entity : entities) {
            save(entity);
        }
        return entities;
    }

    @Override
    public void update(T entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(PK id) {
        getCurrentSession().delete(get(id));
    }

    @Override
    public List<T> getAll() {
        return getCurrentSession().createCriteria(entityClass).list();
    }

    @Override
    public List<T> query(String sql, Object[] params) {
        Query query = getCurrentSession().createQuery(sql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        return query.list();
    }

    @Override
    public long getCount(Map<String, String> searchParams) {
        return getCount(getCriteria(searchParams));
    }

    public long getCount(Criteria criteria) {
        return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public Page<T> getPage(PageRequest<T> page) {
        Criteria criteria = getCriteria(page.getSearchParams());

        //取得符合searchParams参数的结果集的总行数
        long total = getCount(criteria);

        page.calculatePage(total);

        //设置页码及以排序
        CriteriaParser.parsePageParams(criteria,page);

        page.setContent(criteria.list());
        return new PageImpl<T>(page);
    }

    public Criteria getCriteria(Map<String, String> searchParams) {
        return CriteriaParser.parse(searchParams, entityClass, getCurrentSession());
    }

}

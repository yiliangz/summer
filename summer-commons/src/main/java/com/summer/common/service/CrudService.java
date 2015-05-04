package com.summer.common.service;

import com.summer.common.page.Page;
import com.summer.common.page.PageRequest;
import com.summer.common.persistence.IdEntity;
import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2015/3/24.
 */
public interface CrudService <T extends IdEntity,PK extends Serializable> {

    public T get(PK id);

    public T save(T entity);

    public List<T> saveEntities(List<T> entities);

    public void update(T entity);

    public void update(PK id,Map<String,String> entityMap);

    public void delete(PK id);

    public List<T> getAll();

    public List<T> query(String sql,Object[] params);

    public long getCount(Map<String, String> searchParams);

    public Page getPage(PageRequest<T> page);

    public long getCount(Criteria criteria);

}

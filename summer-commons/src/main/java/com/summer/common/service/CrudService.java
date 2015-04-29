package com.summer.common.service;

import com.summer.common.persistence.IdEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2015/3/24.
 */
public interface CrudService <T extends IdEntity,PK extends Serializable> {

    public T get(PK id);

    public T save(T entity);

    public void update(T entity);

    public void update(PK id,Map<String,String> entityMap);

    public void delete(PK id);

    public List<T> getAll();

    public List<T> query(String sql,Object[] params);

}

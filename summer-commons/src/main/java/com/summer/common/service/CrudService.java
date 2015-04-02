package com.summer.common.service;

import com.summer.common.domain.IdEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Allen on 2015/3/24.
 */
public interface CrudService <T extends IdEntity,PK extends Serializable> {

    public T get(PK id);

    public T save(T entity);

    public void delete(PK id);

    public List<T> getAll();

    public List<T> query(String sql,Object[] params);

}

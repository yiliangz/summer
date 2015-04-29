package com.summer.common.repository;

import com.summer.common.persistence.IdEntity;
import com.summer.common.page.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Allen on 2015/3/24.
 */
public interface CrudRepository <T extends IdEntity,PK extends Serializable> {

    public T get(PK id);

    public T load(PK id);

    public T save(T entity);

    public void update(T entity);

    public void delete(PK id);

    public List<T> getAll();

    public List<T> query(String sql,Object[] params);

    public Page getPage();
}

package com.summer.common.repository;

import com.summer.common.domain.IdEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Allen on 2015/3/24.
 */
public interface CrudRepository <PK extends Serializable,T extends IdEntity> {

    public T get(PK id);

    public T save(T entity);

    public void delete(PK id);

    public List<T> getAll();

}

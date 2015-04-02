package com.summer.common.service;

import com.summer.common.domain.IdEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Allen on 2015/4/1.
 */
public class CrudServiceImpl<T extends IdEntity,PK extends Serializable>
        implements CrudService<T,PK> {

//    @Autowired
//    protected CrudRepository<T,PK> crudRepository;

    @Override
    public T get(PK id) {
//        T entity = crudRepository.get(id);
//        return entity;
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

    @Override
    public List<T> query(String sql, Object[] params) {
        return null;
    }

}

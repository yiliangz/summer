package com.summer.common.service;

import com.summer.common.domain.IdEntity;
import com.summer.common.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Allen on 2015/4/1.
 */
public abstract class CrudServiceImpl<T extends IdEntity,PK extends Serializable>
        implements CrudService<T,PK> {

    @Resource
    public CrudRepository<T,PK> crudRepository;

    @Override
    public T get(PK id) {
        return crudRepository.get(id);
    }

    @Override
    public T save(T entity) {
        return crudRepository.save(entity);
    }

    @Override
    public void delete(PK id) {
        crudRepository.delete(id);
    }

    @Override
    public List<T> getAll() {
        return crudRepository.getAll();
    }

    @Override
    public List<T> query(String sql, Object[] params) {
        return crudRepository.query(sql,params);
    }

}

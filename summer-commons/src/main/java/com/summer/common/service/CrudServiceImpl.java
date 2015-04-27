package com.summer.common.service;

import com.summer.common.domain.IdEntity;
import com.summer.common.repository.CrudRepository;
import com.summer.common.utils.ReflectionUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

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
    public void update(T entity) {
        crudRepository.update(entity);
    }

    @Override
    public void update(PK id,Map<String,String> entityMap) {
        T entity = get(id);
        try {
            BeanUtils.copyProperties(entity,entityMap);
            crudRepository.update(entity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        crudRepository.update(entity);
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

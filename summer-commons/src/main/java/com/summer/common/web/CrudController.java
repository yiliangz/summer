package com.summer.common.web;

import com.summer.common.domain.IdEntity;
import com.summer.common.domain.ResponseMessage;
import com.summer.common.service.CrudService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2015/3/25.
 */
public abstract class CrudController <T extends IdEntity,PK extends Serializable>{

    @Resource
    protected CrudService<T,PK> crudService;

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public Object get(@PathVariable PK id) {
        return crudService.get(id);
    }

    @RequestMapping(value = "/all")
    @ResponseBody
    public List<T> getAll() {
        return crudService.getAll();
    }

    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object save(@RequestBody T entity) {
        return crudService.save(entity);
    }

    @RequestMapping(value = "/update/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object update(@PathVariable PK id,@RequestBody Map<String,String> entityMap) {
        crudService.update(id,entityMap);
        return new ResponseMessage(true,"保存成功");
    }

    /**
     * 按id删除对象
     * @param id
     */
    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable PK id) {
        crudService.delete(id);
    }

}

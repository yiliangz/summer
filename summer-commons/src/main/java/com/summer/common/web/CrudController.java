package com.summer.common.web;

import com.summer.common.page.Page;
import com.summer.common.page.PageRequest;
import com.summer.common.persistence.IdEntity;
import com.summer.common.extend.ResponseMessage;
import com.summer.common.service.CrudService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2015/3/25.
 */
public abstract class CrudController <T extends IdEntity,PK extends Serializable>{

    @Resource
    protected CrudService<T,PK> crudService;


    /**
     * 返回主键为id的json数据
     * @param id    主键
     * @return  Object
     * */
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


    /**
     * 保存entity对象
     * @param entity    要保存的entity对象
     * @return  Object  返回保存后的entity的json对象
     * */
    @RequestMapping(value = "/save",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object save(@RequestBody T entity) {
        return crudService.save(entity);
    }


    /**
     * 更新主键为id的对象
     * @param id           主键
     * @param entityMap    Map格式的数据
     * @return  Object
     * */
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


    /**
     * 分页的访问方式如下:
     *  {
     *     page : 1,
     *     size : 10,
     *     searchParams:   { name_eq : "Computer",  team.age_lt : 6 },
     *     sort:           { name : asc,  team.englishName : desc }
     *  }
     *
     * @param page  PageRequest对象用来接收前端传送过来的数据
     * @return Page PageImpl对象
     */
    @RequestMapping(value = "/page",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page page(@RequestBody PageRequest<T> page) {
        return crudService.getPage(page);
    }

}

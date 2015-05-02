package com.summer.common.page;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2015/4/28.
 */
public class PageRequest<T> extends AbstractPage<T> {

    /* sort  用于接收前端传过来的排序信息 */
    private Map<String,String> sort = Maps.newHashMap();

    /* sorts 由sort解析得到 */
    private List<Sort> sorts = Lists.newArrayList();

    private Map<String,String> searchParams = Maps.newHashMap();

    public PageRequest() {

    }

    public PageRequest(long page) {
        this.page = page;
    }

    public Map<String, String> getSort() {
        return sort;
    }

    public void setSort(Map<String, String> sort) {
        this.sort = sort;
    }

    public Map<String, String> getSearchParams() {
        return searchParams;
    }

    public void setSearchParams(Map<String, String> searchParams) {
        this.searchParams = searchParams;
    }

    public List<Sort> getSorts() {
        if(sorts.size() == 0) {
            setSorts(Sort.parse(sort));
        }
        return sorts;
    }

    public void setSorts(List<Sort> sorts) {
        this.sorts = sorts;
    }

    public void addSort(Sort sort) {
        sorts.add(sort);
    }

}

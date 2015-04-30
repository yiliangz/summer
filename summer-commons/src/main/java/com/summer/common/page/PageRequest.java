package com.summer.common.page;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2015/4/28.
 */
public class PageRequest<T> extends AbstractPage<T> {

    private List<Sort> sorts = Lists.newArrayList();

    private Map<String,String> searchParams = Maps.newHashMap();

    public PageRequest() {

    }

    public PageRequest(long page) {
        this.page = page;
    }


    public Map<String, String> getSearchParams() {
        return searchParams;
    }

    public void setSearchParams(Map<String, String> searchParams) {
        this.searchParams = searchParams;
    }

    public List<Sort> getSorts() {
        return sorts;
    }

    public void setSorts(List<Sort> sorts) {
        this.sorts = sorts;
    }

    public void addSort(Sort sort) {
        sorts.add(sort);
    }

}

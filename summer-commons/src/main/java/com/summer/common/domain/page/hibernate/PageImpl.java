package com.summer.common.domain.page.hibernate;

import com.summer.common.domain.page.Page;

import java.util.List;

/**
 * Created by Allen on 2015/4/27.
 */
public class PageImpl<T> implements Page<T> {

    private List<T> content;

    private long current;

    private long total;

    private long totalPage;

    @Override
    public Page nextPage() {
        return null;
    }

    @Override
    public Page prevPage() {
        return null;
    }

    @Override
    public List<T> getContent() {
        return null;
    }

    @Override
    public boolean isFirst() {
        return false;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public long getTotal() {
        return 0;
    }

    @Override
    public long getCurrent() {
        return 0;
    }

    @Override
    public long getTotalPage() {
        return 0;
    }

}

package com.summer.common.page;

import java.util.List;

/**
 * Created by Allen on 2015/4/27.
 */
public abstract class AbstractPage<T> implements Page<T> {

    private List<T> content;

    private long current;

    private long total;

    private long totalPage;

    private long size;

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

}

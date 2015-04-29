package com.summer.common.page;

import java.util.List;

/**
 * Created by Allen on 2015/4/27.
 */
public interface Page<T> {

    public Page nextPage();

    public Page prevPage();

    public List<T> getContent();

    public boolean isFirst();

    public boolean hasNext();

    public long getTotal();

    public long getCurrent();

    public long getSize();

    public long getPageCount();

    public long getPage();

}

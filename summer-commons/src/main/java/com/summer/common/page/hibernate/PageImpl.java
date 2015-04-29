package com.summer.common.page.hibernate;

import com.summer.common.page.AbstractPage;
import com.summer.common.page.Page;

import java.util.List;

/**
 * Created by Allen on 2015/4/27.
 */
public class PageImpl<T> extends AbstractPage<T> implements Page<T> {

    @Override
    public List<T> getContent() {
        return null;
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
    public long getSize() {
        return 0;
    }

    @Override
    public long getPageCount() {
        return 0;
    }

    @Override
    public long getPage() {
        return 0;
    }

}

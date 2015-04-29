package com.summer.common.page;

import java.util.Map;

/**
 * Created by Allen on 2015/4/28.
 */
public class PageRequest {

    private long page;

    private long size;

    private Map<String,String> searchParams;

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Map<String, String> getSearchParams() {
        return searchParams;
    }

    public void setSearchParams(Map<String, String> searchParams) {
        this.searchParams = searchParams;
    }

}

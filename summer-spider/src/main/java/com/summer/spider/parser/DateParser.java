package com.summer.spider.parser;

import java.util.Date;

/**
 * Created by Allen on 2015/4/20.
 */
public interface DateParser {

    public Long getLong(String data);

    public Double getDouble(String data);

    public Date getDate(String data);

}

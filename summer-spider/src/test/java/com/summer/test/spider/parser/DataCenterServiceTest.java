package com.summer.test.spider.parser;

import org.junit.Test;

/**
 * Created by Allen on 2015/4/21.
 */
public class DataCenterServiceTest extends BaseSpringContext {

    /**
     *  DataCenterService,其中sync()方法为总入口,作用是同步并持久化数据
     * */
    @Test
    public void test() {
        dataCenterService.sync();
    }

}

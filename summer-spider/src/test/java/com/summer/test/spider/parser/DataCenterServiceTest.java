package com.summer.test.spider.parser;

import com.summer.spider.service.DataCenterService;
import org.junit.Test;

/**
 * Created by Allen on 2015/4/21.
 */
public class DataCenterServiceTest {

    /**
     *  DataCenterService,其中sync()方法为总入口,作用是同步并持久化数据
     * */
    @Test
    public void test() {

        DataCenterService service = new DataCenterService();
        service.sync();

    }

}

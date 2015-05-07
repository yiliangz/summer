package com.summer.test.spider.parser;

import org.junit.Test;

/**
 * Created by Allen on 2015/4/21.
 */
public class DataCenterServiceTest extends BaseSpringContext {

    /**
     *  1、DataCenterService,其中sync()方法为总入口,作用是同步并持久化数据
     *  2、该同步网络访问量较大,防止不小心使用mvn install命令自动运行该测试所以在不使用的时候注释
     *  3、请使用: mvn clean install -Dmaven.test.skip=true以避开运行测试用例
     */
    @Test
    public void test() {
//        dataCenterService.sync();
    }

}

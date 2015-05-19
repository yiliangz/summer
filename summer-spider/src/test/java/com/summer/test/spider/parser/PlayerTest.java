package com.summer.test.spider.parser;

import org.junit.Test;

/**
 * Created by Allen on 2015/5/20.
 */
public class PlayerTest extends BaseSpringContext {

    @Test
    public void testGet() {
        playerService.get(1L);
    }

}

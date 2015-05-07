package com.summer.test.commons.util;

import com.summer.common.constant.EncodingConstant;
import com.summer.common.utils.HttpUrlContextUtils;
import org.junit.Test;

/**
 * Created by Allen on 2015/5/6.
 */
public class HttpUrlContextUtilsTest {

    @Test
    public void test() {
        String playerUrl = "http://nba.sports.sina.com.cn/star/Stephen-Curry.shtml";
        String playerHtml = HttpUrlContextUtils.getResponseText(playerUrl, null, EncodingConstant.GB_ENCODING);
        System.out.println(playerHtml);
    }

}

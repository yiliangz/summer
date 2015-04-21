package com.summer.test.spider.parser;

import com.summer.spider.parser.CssSelector;
import com.summer.spider.parser.HtmlParser;
import com.summer.spider.parser.DataCenterParser;
import org.junit.Test;

/**
 * Created by Allen on 2015/4/17.
 */
public class DataCenterParserTest extends BaseSpringContext{

    @Test
    public void testParseElements() {
        HtmlParser parser =
                new DataCenterParser().init(HtmlContext.getDataCenterHtml(), CssSelector.Center.dataCenter);
        parser.parse();
    }

}

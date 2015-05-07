package com.summer.test.spider.parser;

import com.summer.spider.domain.Division;
import com.summer.spider.domain.Region;
import com.summer.spider.parser.CssSelector;
import com.summer.spider.parser.DataCenterParser;
import com.summer.spider.parser.HtmlParser;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Allen on 2015/4/17.
 */
public class DataCenterParserTest extends BaseSpringContext {

    @Test
    public void testParseElements() {
        HtmlParser parser =
                new DataCenterParser().init(HtmlContext.getDataCenterHtml(), CssSelector.Center.dataCenter);
//        parser.parse();
    }

    @Test
    public void testGet() {
        List<Division> divisions = divisionService.getAll();
        List<Region> regions = regionService.getAll();
    }

}

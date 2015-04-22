package com.summer.test.spider.parser;

import com.summer.common.utils.HttpUrlContextUtils;
import com.summer.spider.parser.HtmlParser;
import com.summer.spider.parser.TeamParser;
import org.junit.Test;

/**
 * Created by Allen on 2015/4/17.
 */
public class TeamParserTest {


    public void parse(String html) {
        HtmlParser parser = new TeamParser().init(html);
        parser.parse();
    }

    @Test
    public void parseViaArchive() throws Exception {
        String result = HtmlContext.getTeamHtml();
        parse(result);
    }

    @Test
    public void parseViaHttp() throws Exception {
        String result = HttpUrlContextUtils.getResponseText("http://nba.sports.sina.com.cn/team/Spurs.shtml", null, "gb2312");

    }

}


package com.summer.test.spider.parser;

import com.summer.common.utils.HttpUrlContextUtils;
import com.summer.common.utils.RegexUtils;
import com.summer.spider.domain.Team;
import com.summer.spider.parser.CssSelector;
import com.summer.spider.parser.HtmlParser;
import com.summer.spider.parser.TeamParser;
import org.jsoup.nodes.Element;
import org.junit.Test;

/**
 * Created by Allen on 2015/4/17.
 */
public class TeamParserTest {

    @Test
    public void parse() {
//        String result = HttpUrlContextUtils.getResponseText("http://nba.sports.sina.com.cn/team/Spurs.shtml", null, "gb2312");
        HtmlParser parser = new TeamParser().init(HtmlContext.getTeamHtml());
        parser.parse();
    }

}


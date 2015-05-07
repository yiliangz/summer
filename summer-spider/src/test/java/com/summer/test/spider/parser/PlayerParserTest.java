package com.summer.test.spider.parser;

import com.summer.spider.domain.Player;
import com.summer.spider.parser.PlayerParser;
import org.junit.Test;

/**
 * Created by Allen on 2015/5/6.
 */
public class PlayerParserTest {


    @Test
    public void test() {
        PlayerParser parser = new PlayerParser();
        parser.init(HtmlContext.getPlayerHtml());
        parser.defaultInitialization(new Player());
        parser.parse();

    }

}

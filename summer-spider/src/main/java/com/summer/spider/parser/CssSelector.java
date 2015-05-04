package com.summer.spider.parser;

/**
 * Created by Allen on 2015/4/15.
 */
public class CssSelector {

    public class Center {

        public final static String dataCenter = "#main table";

        public final static String Region = "tr:eq(0) td";

        public final static String division = "tr:eq(1) td";

        public final static String row = "tr:gt(1)";

        public final static String team = "td a";

    }


    /**
     * jsoup的selector有别区jquery的selector
     * 每次要注意取:eq(n)时jsoup是将所有当前元素都选择第n个得出的集合,而在jquery是先选出集合再从集合中取第n个
     * */
    public class Team {

        /* 球队信息(有英文名) */
        public final static String teamBoard = "#left";

        public final static String englishName = "div:eq(0) div:eq(0) p";

        /* 球队信息 begin */
        public final static String team = "#left > #table730middle";


    }

}

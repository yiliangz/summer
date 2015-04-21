package com.summer.test.spider.parser;

import com.summer.common.utils.IOStreamUtils;
import com.summer.common.utils.RegexUtils;

/**
 * Created by Allen on 2015/4/17.
 */
public class HtmlContext {

    public static final String dataCenterHtml = "html/DataCenterExample.txt";

    public static final String teamHtml = "html/TeamExample.txt";

    public static String getDataCenterHtml() {
        return readHtml(dataCenterHtml);
    }

    public static String getTeamHtml() {
        return readHtml(teamHtml);
    }

    public static String readHtml(String fileClassPath) {
        return IOStreamUtils.readClassPathTxtFile(fileClassPath);
    }

}

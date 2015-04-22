package com.summer.spider.utils;

import com.summer.common.utils.IOStreamUtils;

/**
 * Created by Allen on 2015/4/21.
 */
public class FilePathUtils {

    public static final String PREFIX = "/summer";

    public static final String IMAGE_PATH = "/champions/src/main/webapp/dist/image";

    public static String getPrefixPath() {
        String classPath = IOStreamUtils.getClassPath();
        return classPath.substring(0,classPath.indexOf(PREFIX)+PREFIX.length());
    }

    public static String getPrefixImagePath() {
        return getPrefixPath() + IMAGE_PATH;
    }

}

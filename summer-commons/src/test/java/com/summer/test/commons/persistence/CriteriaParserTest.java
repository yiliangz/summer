package com.summer.test.commons.persistence;

import com.google.common.collect.Maps;
import com.summer.common.persistence.SearchFilter;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2015/4/29.
 */
public class CriteriaParserTest {

    @Test
    public void testParse() {
        Map<String,Object> searchParams = Maps.newHashMap();
        searchParams.put("lt_name","computer");

//        List list = SearchFilter.parse(searchParams);
    }

}

package com.summer.test.commons.util;

import com.summer.common.utils.DateUtils;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Allen on 2015/4/20.
 */
public class DateUtilsTest {

    @Test
    public void testDateFormat() {
        DateFormat format = new SimpleDateFormat("yyyy-M-d");
        Calendar c = Calendar.getInstance();
        c.set(2014,2,3);
        System.out.println(format.format(c.getTime()));
    }

    @Test
    public void parserDate() throws ParseException {
        System.out.println(DateUtils.parseDate("2014-1-2",DateUtils.NO_ZERO_DATE_FORMAT));
    }

}

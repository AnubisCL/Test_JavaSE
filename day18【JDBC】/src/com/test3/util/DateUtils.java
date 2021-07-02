package com.test3.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @Author: Anubis
* @Date: 2021-07-02 下午 9:00
*/public class DateUtils {

    public static java.sql.Date StringToSQLDate(String birth) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(birth);
        long parseTime = parse.getTime();
        return new java.sql.Date(parseTime);

    }

}

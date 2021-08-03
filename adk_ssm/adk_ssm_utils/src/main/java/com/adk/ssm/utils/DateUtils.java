package com.adk.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String dateToString(Date date,String patt){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(patt);
        String dateString=simpleDateFormat.format(date);
        return dateString;
    }

    public static Date stringToDate(String str,String patt) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(patt);
        Date date=simpleDateFormat.parse(str);
        return date;
    }
}

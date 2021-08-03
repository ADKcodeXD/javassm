package com.adk.ssm.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if (s==null){
            throw new RuntimeException("请你传入数据");
        }
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = df.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("转换出现错误");
        }
        return date;
    }
}

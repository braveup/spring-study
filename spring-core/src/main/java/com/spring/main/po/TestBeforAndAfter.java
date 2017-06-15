package com.spring.main.po;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by braveup on 2017/6/8.
 */
public class TestBeforAndAfter {
    public static void main(String[] args) {
        SimpleDateFormat  format=new SimpleDateFormat("yyyy-MM-dd");
        String  date="2017-05-30";
        try {
            Date  date1=format.parse(date);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

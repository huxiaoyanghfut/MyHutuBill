package com.test;

import com.until.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestMonth {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);// 从一号开始

        for (int i = 0; i < 30; i++, cal.add(Calendar.DATE, 1)) {
            Date d = cal.getTime();
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            String df = simpleDateFormat.format(d);
//            System.out.println(df);
            System.out.println(d);
        }

    }
}

package com.qingwen.basic.day19;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @Author qingwen
 * @Create 2022-10-06 06:58
 */
public class DatetimeTest {

    @Test
    public void testDateformat() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();

        String formatdate = sdf.format(date);

        System.out.println(formatdate);

        String str = "22-10-01 上午10:11";
        try {
            Date newDate = sdf.parse(str);
            System.out.println(newDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test1(){
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localTime);
        System.out.println(localDate);
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.of(2022,10,11, 07, 11, 14);
        System.out.println(localDateTime1);

        //具体操作
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMinute());

        //日期设置，体现不可变性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(10);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);


    }

}

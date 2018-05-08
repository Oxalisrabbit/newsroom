package com.example.newsroom.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ToDate {

    /**
     *
     * 在通过日期搜索中，得到时间段
     * @param date
     * @param standard
     * @return
     */
    public static Map<String,Date> TodateInByDate(Map<String,Object> date, int standard){
        Map<String,Date> map = new HashMap<>();

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        int year1 = (int)date.get("year");
        int year2 = year1;
        int month1,month2;
        if(standard == 12) {
            month1 = (int) date.get("term");
            month2 = (month1 + 1) % 12;
            if (month1 == 12) {
                year2 = year1 + 1;
            }
        }else if(standard == 6){
            month1 = (int) date.get("term") * 2;
            month2 = (month1 + 2) % 12;
            if (month1 == 12 ) {
                year2 = year1 + 1;
            }
        }else{
            month1 = (int) date.get("term") * 3;
            month2 = (month1 + 3) % 12;
            if (month1 == 12) {
                year2 = year1 + 1;
            }
        }
        cal1.set(year1,month1 -1,1,0,0,0);//第二个参数月份是实际值减1
        cal2.set(year2,month2 -1,1,0,0,0);
        Date start = cal1.getTime();
        Date end = cal2.getTime();

        map.put("start", start);
        map.put("end", end);
        return map;
    }


    /**
     * 在关键词搜索中，得到时间段
     * @param key
     * @return
     */
    public static Map<String,Date> TodateInByKey(Map<String,Object> key){
        Map<String,Date> map = new HashMap<>();

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        int year1 = (int)key.get("startyear");
        int year2 = (int)key.get("endyear");
        cal1.set(year1,0,1,0,0,0);//第二个参数月份是实际值减1
        cal2.set(year2,0,1,0,0,0);
        Date start = cal1.getTime();
        Date end = cal2.getTime();

        map.put("start", start);
        map.put("end", end);
        return map;
    }
}

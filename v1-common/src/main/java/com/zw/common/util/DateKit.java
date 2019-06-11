package com.zw.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wang.lin@esstx.cn on 2018/4/20.
 */
public class DateKit {
    public final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_FORMAT = "yyyy-MM-dd";
    public final static String TIME2_FORMAT = "HH:mm:ss";

    /**
     * 通过String类型获得指定时间
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getDate(String date) throws ParseException {
        return getDate(date, TIME_FORMAT);
    }

    public static Date getDate(String date,String pattern) throws ParseException {
        if(StrKit.isBlank(date)){
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(StrKit.isBlank(pattern)?TIME_FORMAT:pattern);
        return dateFormat.parse(date);
    }
    public static String toStr(Date date, String format){
        SimpleDateFormat sdf;
        if(null != format && !"".equals(format)){
            sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        } else{
            sdf = new SimpleDateFormat(DateKit.TIME_FORMAT);
            return sdf.format(date);
        }
    }

    /**
     * 将当前时间格式化为默认格式的字符串
     * @return
     */
    public static String formatCurrentTime() {
        return new SimpleDateFormat(DATE_FORMAT).format(new Date());
    }


    /**
     * 获取默认格式的当前时间
     * @return
     */
    public static String getCurrnetTimeString() {
        return new SimpleDateFormat(TIME_FORMAT).format(new Date());
    }

    /**
     * 判断是否2天内的时间
     * @param addtime
     * @param now
     * @return
     */
    public static boolean isLatest2Day(Date addtime,Date now){
        Calendar calendar = Calendar.getInstance();  //得到日历
        calendar.setTime(now);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -7);  //设置为7天前
        Date before7days = calendar.getTime();   //得到7天前的时间
        if(before7days.getTime() < addtime.getTime()){
            return true;
        }else{
            return false;
        }
    }


    /**
     * 获取过去N天之前的日期
     */
    public static String getLastNDay(int n,String pattern){
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -n);
        date = calendar.getTime();
        SimpleDateFormat dateFormater = new SimpleDateFormat(pattern);
        String lastDay = dateFormater.format(date);
        return  lastDay;
    }


    /**
     * 获取当前月的第一天和最后一天日期字符串
     *
     * @return
     */
    public static SyncParams getCurrMonthParams() {
        // 获取当前年份、月份、日期
        Calendar cale = Calendar.getInstance();
        // 获取当月第一天和最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // 获取前月的第一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        String firstday = format.format(cale.getTime());
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        String lastday = format.format(cale.getTime());
        SyncParams s = new SyncParams();
        s.start = firstday;
        s.end = lastday;
        return s;
    }



    /**
     * 获取指定时间的月的第一天和最后一天日期字符串
     *
     * @return
     */
    public static SyncParams getDateMonthParams(Date date) {
        // 获取指定年份、月份、日期
        Calendar cale = Calendar.getInstance();
        // 获取指定月第一天和最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // 获取指定月的第一天
        cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        String firstday = format.format(cale.getTime());
        // 获取指定月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        String lastday = format.format(cale.getTime());
        SyncParams s = new SyncParams();
        s.start = firstday;
        s.end = lastday;
        return s;
    }





    public static class SyncParams {
        public String start;
        public String end;

        /**
         * @return
         * @see Object#toString()
         */
        @Override
        public String toString() {
            return start + " - " + end;
        }

    }

    /**
     * 过去几天
     */
    public static String getLastDay(int last){
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -last);
        date = calendar.getTime();
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
        String lastDay = dateFormater.format(date);
        return lastDay;
    }
}

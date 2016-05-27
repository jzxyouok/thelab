/**
 * Yixiu.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.yang.thelab.common.utils;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.yang.thelab.common.enums.DateFormatEnum;
import com.yang.thelab.common.exception.DateException;

/**
 * 基于apache common-lang3的日期工具类
 * <ul>几个关键依赖,翻看源码的同学可以重点关注
 * <li>{@link org.apache.commons.lang3.time.DateUtils}.
 * <li>{@link org.apache.commons.lang3.time.DateFormatUtils}.
 * </ul>
 * @author bo.nib
 * @version $Id: DateUtil.java, v 0.1 2015年10月27日 下午11:42:57 bo.nib Exp $
 */
public final class DateUtil {
    private DateUtil() {
    }

    /**一秒的毫秒数*/
    public static final long MILLIS_PER_SECOND = 1000;

    /**一分钟的毫秒数*/
    public static final long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;

    /**一小时的毫秒数*/
    public static final long MILLIS_PER_HOUR   = 60 * MILLIS_PER_MINUTE;

    /**一天的毫秒数*/
    public static final long MILLIS_PER_DAY    = 24 * MILLIS_PER_HOUR;

    /**
     * 将日期字符转化为日期对象
     * @param str
     * @return 日期对象 
     * @throws DateException
     */
    public Date parseDate(String str, DateFormatEnum format) {
        if (str == null) {
            return null;
        }
        try {
            return DateUtils.parseDate(str, format.code());
        } catch (Exception e) {
            throw new DateException("parse date " + str  + " error",e );
        }
    }

    /**
     * 
     * @param date
     * @param format
     * @return
     */
    public static final String dateFormat(Date date, DateFormatEnum format) {
        if (date == null) {
            return "";
        }
        return DateFormatUtils.format(date, format.code());
    }

    /**
     * 计算两个日期间的天数差,计算的时候会去掉时分秒.truncate(date1) - truncate(date2)
     * @param date1
     * @param date2
     * @return 可能会返回小于0的值
     */
    public static long diffDay(Date date1, Date date2) {
        Date d1 = DateUtils.truncate(date1, Calendar.DATE);
        Date d2 = DateUtils.truncate(date2, Calendar.DATE);
        return (d1.getTime() - d2.getTime()) / MILLIS_PER_DAY;
    }

    /**
     * 计算两个日期间的月数差,计算的时候会去掉天时分秒
     * @param date1
     * @param date2
     * @return 月差
     */
    public static int diffMonth(Date date1, Date date2) {
        final Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        final Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return  (cal1.get(Calendar.YEAR) * 12 + cal1.get(Calendar.MONTH))
                - (cal2.get(Calendar.YEAR)* 12 + cal2.get(Calendar.MONTH));
    }
    
    /**
     * 去掉时分秒比较日期
     * @param date1
     * @param date2
     * @return 月差
     */
    public static int compareTruncateDay(Date date1, Date date2) {
        final Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        final Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return DateUtils.truncatedCompareTo(cal1, cal2, Calendar.DATE);
    }
    
    /**
     * point是否在闭区间
     * @param date1
     * @param date2
     * @return 月差
     */
    public static boolean between(Date start, Date end, Date point) {
        if(start == null || end == null || point == null){
            throw new DateException("日期不能为空");
        }
        if(start.compareTo(end) > 0){
            throw new DateException("开始日期大于结束时期,还比较个蛋");
        }
        if(point.compareTo(start) < 0){
            return false;
        }
        
        if(point.compareTo(end) > 0){
            return false;
        }
        return true;
    }
    

    /**
     * 在原有的时间基础上增加或减少年为单位的时间
     * @param date
     * @param amount +为增加,-未减少
     * @return
     */
    public static Date addYears(Date date, int amount) {
        return DateUtils.addYears(date, amount);
    }

    /**
     * 在原有的时间基础上增加或减少月为单位的时间
     * @param date
     * @param amount +为增加,-未减少
     * @return
     */
    public static Date addMonths(Date date, int amount) {
        return DateUtils.addMonths(date, amount);
    }

    /**
     * 在原有的时间基础上增加或减少周为单位的时间
     * @param date
     * @param amount +为增加,-未减少
     * @return
     */
    public static Date addWeeks(Date date, int amount) {
        return DateUtils.addWeeks(date, amount);
    }

    /**
     * 在原有的时间基础上增加或减少天为单位的时间
     * @param date
     * @param amount +为增加,-未减少
     * @return
     */
    public static Date addDays(Date date, int amount) {
        return DateUtils.addDays(date, amount);
    }

    /**
     * 在原有的时间基础上增加或减少小时为单位的时间
     * @param date
     * @param amount +为增加,-未减少
     * @return
     */
    public static Date addHours(Date date, int amount) {
        return DateUtils.addHours(date, amount);
    }

    /**
     * 在原有的时间基础上增加或减少分钟为单位的时间
     * @param date
     * @param amount +为增加,-未减少
     * @return
     */
    public static Date addMinutes(Date date, int amount) {
        return DateUtils.addMinutes(date, amount);
    }

    /**
     * 在原有的时间基础上增加或减少秒为单位的时间
     * @param date
     * @param amount +为增加,-未减少
     * @return
     */
    public static Date addSeconds(Date date, int amount) {
        return DateUtils.addSeconds(date, amount);
    }

    /**
     * 在原有的时间基础上增加或减少毫秒为单位的时间
     * @param date
     * @param amount +为增加,-未减少
     * @return
     */
    public static Date addMilliseconds(Date date, int amount) {
        return DateUtils.addMilliseconds(date, amount);
    }

    /**
     * 是否为同一天 ,年月日的值都必须相同 
     * 例子：<ul>
     * <li>2002-12-08 13:45 对比 2002-12-08 16:30 return true.
     * <li>2002-12-08 13:45 对比 2002-11-05 16:30 return false.
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        return DateUtils.isSameDay(date1, date2);
    }

    /**
     * 是否为同年且同一月 ,年月的值都必须相同 
     * 例子：<ul>
     * <li>2002-12-08 13:45 对比 2002-12-22 16:30 return true.
     * <li>2002-12-08 13:45 对比 2003-12-05 16:30 return false.
     * <li>2002-12-08 13:45 对比 2002-11-05 16:30 return false.
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameMonth(Date date1, Date date2) {
        final Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        final Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA)
                && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2
            .get(Calendar.MONTH));
    }

    private static boolean isSameCalendarXValue(Date date1, Date date2, int x) {
        final Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        final Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) && cal1.get(x) == cal2.get(x);
    }

    /**
     * 是否为同一年 ,年必须相同 
     * 例子：<ul>
     * <li>2002-12-08 13:45 对比 2002-08-08 16:30 return true.
     * <li>2008-12-08 13:45 对比 2002-11-05 16:30 return false.
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameYearValue(Date date1, Date date2) {
        return isSameCalendarXValue(date1, date2, Calendar.YEAR);
    }

    /**
     * 是否为同一月 ,月 必须相同 
     * 例子：<ul>
     * <li>2002-12-08 13:45 对比 2006-12-21 16:30 return true.
     * <li>2002-11-08 13:45 对比 2002-12-05 16:30 return false.
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameMonthValue(Date date1, Date date2) {
        return isSameCalendarXValue(date1, date2, Calendar.MONTH);
    }

    /**
     * 是否为同一月 ,月 必须相同 
     * 例子：<ul>
     * <li>2002-12-08 13:45 对比 2006-12-21 16:30 return true.
     * <li>2002-11-08 13:45 对比 2002-12-05 16:30 return false.
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDayValue(Date date1, Date date2) {
        return isSameCalendarXValue(date1, date2, Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前月的天数
     * 
     * @return
     */
    public static int getCurrentMonthDayAmount() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获取当前年的总天数
     * @return
     */
    public static int getCurrentYearDayAmount() {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.MONTH, Calendar.DECEMBER);
        date.set(Calendar.DAY_OF_MONTH, 31);
        return date.get(Calendar.DAY_OF_YEAR);
    }

}

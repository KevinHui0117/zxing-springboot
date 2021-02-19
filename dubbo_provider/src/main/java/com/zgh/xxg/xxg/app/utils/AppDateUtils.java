package com.zgh.xxg.xxg.app.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Stream;

/**
 * app考勤模块 时间 工具类
 *
 * @author huikai
 * @since 2020-04-08 10:36:36
 */
public class AppDateUtils {

    public static String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";


    public final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public final static DateTimeFormatter DATE_MD_FORMAT = DateTimeFormatter.ofPattern("MM-dd");
    public final static DateTimeFormatter DATE_TIME_Y_FORMAT = DateTimeFormatter.ofPattern("yyyy");
    public final static DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取YYYY格式
     *
     * @return
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }


    /**
     * 获取YYYY格式
     *
     * @return
     */
    public static String getYear(Date date) {
        return formatDate(date, "yyyy");
    }

    /**
     * 获取YYYY-MM-DD格式
     *
     * @return
     */
    public static String getDay() {
        return formatDate(new Date(), "yyyy-MM-dd");
    }

    /**
     * 获取YYYY-MM-DD格式
     *
     * @return
     */
    public static String getDay(Date date) {
        return formatDate(date, "yyyy-MM-dd");
    }

    /**
     * 获取YYYYMMDD格式
     *
     * @return
     */
    public static String getDays() {
        return formatDate(new Date(), "yyyyMMdd");
    }

    /**
     * 获取YYYYMMDD格式
     *
     * @return
     */
    public static String getDays(Date date) {
        return formatDate(date, "yyyyMMdd");
    }

    /**
     * 获取YYYY-MM-DD HH:mm:ss格式
     *
     * @return
     */
    public static String getTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取 yyyy-MM-dd格式
     *
     * @return
     */
    public static String getTimeyyyyMMdd() {
        return formatDate(new Date(), "yyyy-MM-dd");
    }

    /**
     * 获取 HH:mm格式
     *
     * @return
     */
    public static String getTimeHHMM() {
        return formatDate(new Date(), "HH:mm");
    }

    /**
     * 获取 HH:mm格式
     *
     * @return
     */
    public static String getTimeYyyy() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 获取 HH:mm:ss格式
     *
     * @return
     */
    public static String getTimeHHMMSS() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 获取 yyyy-MM-dd格式
     *
     * @return
     */
    public static String getTimeYyyyMmDd() {
        return formatDate(new Date(), "yyyy-MM-dd");
    }

    /**
     * 获取YYYY-MM-DD HH:mm:ss.SSS格式
     *
     * @return
     */
    public static String getMsTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");
    }

    /**
     * 获取YYYYMMDDHHmmss格式
     *
     * @return
     */
    public static String getAllTime() {
        return formatDate(new Date(), "yyyyMMddHHmmss");
    }

    /**
     * 获取YYYY-MM-DD HH:mm:ss格式
     *
     * @return
     */
    public static String getTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String formatDate(Date date, String pattern) {
        String formatDate = null;
        if (StringUtils.isNotBlank(pattern)) {
            formatDate = DateFormatUtils.format(date, pattern);
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * @param s
     * @param e
     * @return boolean
     * @throws
     * @Title: compareDate
     * @Description:(日期比较，如果s>=e 返回true 否则返回false)
     * @author luguosui
     */
    public static boolean compareDate(String s, String e, String pattern) {
        if (parseDate(s, pattern) == null || parseDate(e, pattern) == null) {
            return false;
        }
        return parseDate(s, pattern).getTime() >= parseDate(e, pattern).getTime();
    }

    /**
     * @param s
     * @param e
     * @return boolean
     * @throws
     * @Title: compareDate
     * @Description:(日期比较，如果s>=e 返回true 否则返回false)
     * @author luguosui
     */
    public static boolean compareDate(String s, String e) {
        if (parseDate(s, AppDateUtils.DEFAULT_PATTERN) == null || parseDate(e, AppDateUtils.DEFAULT_PATTERN) == null) {
            return false;
        }
        return parseDate(s, AppDateUtils.DEFAULT_PATTERN).getTime() >= parseDate(e, AppDateUtils.DEFAULT_PATTERN).getTime();
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public static Date parseDate(String date, String pattern) {
        return parse(date, pattern);
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public static Date parseDate(String date) {
        return parse(date, AppDateUtils.DEFAULT_PATTERN);
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public static Date parseTime(String date) {
        return parse(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public static Date parseTime(String date, String pattern) {
        return parse(date, pattern);
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public static Date parse(String date, String pattern) {
        try {
            return DateUtils.parseDate(date, pattern);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public static String format(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 把日期转换为Timestamp
     *
     * @param date
     * @return
     */
    public static Timestamp format(Date date) {
        return new Timestamp(date.getTime());
    }

    /**
     * 校验日期是否合法
     *
     * @return
     */
    public static boolean isValidDate(String s) {
        return parse(s, "yyyy-MM-dd HH:mm:ss") != null;
    }

    /**
     * 校验日期是否合法
     *
     * @return
     */
    public static boolean isValidDate(String s, String pattern) {
        return parse(s, pattern) != null;
    }

    public static int getDiffYear(String startTime, String endTime) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(
                    startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
            return years;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return 0;
        }
    }

    /**
     * <li>功能描述：时间相减得到天数
     *
     * @param beginDateStr
     * @param endDateStr
     * @return long
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {
        long day = 0;
        SimpleDateFormat format = new SimpleDateFormat(
                "yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;

        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        // System.out.println("相隔的天数="+day);

        return day;
    }

    /**
     * <li>功能描述：时间相减得到分钟
     *
     * @param beginDateStr
     * @param endDateStr
     * @return long
     * @author Administrator
     */
    public static long getMinutesSub(String beginDateStr, String endDateStr) {
        long minutes = 0;
        SimpleDateFormat format = new SimpleDateFormat(
                "yyyy-MM-dd hh:mm:ss");
        Date beginDate = null;
        Date endDate = null;

        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        minutes = (endDate.getTime() - beginDate.getTime()) / (60 * 1000);
        return minutes;
    }

    /**
     * 得到n天之后的日期
     *
     * @param days
     * @return
     */
    public static String getAfterDayDateTime(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);

        return dateStr;
    }


    /**
     * 得到n天之后是周几
     *
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);

        return dateStr;
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime   当前时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     * @author jqlin
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取指定日期前后 ±N 天的字符串
     */
    public static String getNextDayStr(String date, String pattern, int amount) {
        DateFormat dft = new SimpleDateFormat(pattern);
        String nextDay = "";
        try {
            Date temp = dft.parse(date);
            Calendar cld = Calendar.getInstance();
            cld.setTime(temp);
            cld.add(Calendar.DATE, amount);
            temp = cld.getTime();
            //获得下一天日期字符串
            nextDay = dft.format(temp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return nextDay;
    }


    /**
     * 格式化当前日期
     *
     * @param pattern 时间格式
     */
    public static Date getNowDate(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String dateStr = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * LocalDate转Date
     *
     * @param localDate
     * @return
     */
    public static Date localDate2Date(LocalDate localDate) {
        if (null == localDate) {
            return null;
        }
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    public static String getHHmmStrFromDate(String dateStr) {
        String a1 = dateStr.substring(dateStr.lastIndexOf(" ") + 1);// hh:mm:ss
        String str2 = a1.substring(0, a1.lastIndexOf(":"));
        return str2;
    }

    /**
     * 判定上午/下午 (0:上午 ； 1：下午)
     */
    public static int isAmOrPm() {
        GregorianCalendar ca = new GregorianCalendar();
        return ca.get(GregorianCalendar.AM_PM);
    }

    /**
     * String转LocalDateTime
     *
     * @param timeStamp
     * @return
     */
    public static LocalDateTime timeStamp2LocalDateTime(String timeStamp) {
        return Timestamp.valueOf(timeStamp).toLocalDateTime();
    }

    /**
     * String转LocalDateTime
     *
     * @param timeStamp
     * @param time
     * @return
     */
    public static LocalDateTime timeStamp2LocalDateTime(String timeStamp, String time) {
        return LocalDateTime.of(timeStamp2LocalDateTime(timeStamp).toLocalDate(), LocalTime.parse(time));
    }

    /**
     * LocalDate转Date
     *
     * @param date
     * @return
     */
    public static LocalDate date2LocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 返回date当天开始时间
     */
    public static Date getDayBegin(Date date) {
        return Date.from(date2LocalDate(date).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 返回date当天结束时间
     */
    public static Date getDayEnd(Date date) {
        return Date.from(date2LocalDate(date).atTime(23, 59, 59).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 返回date所在月份开始时间
     */
    public static Date getMonthBegin(Date date) {
        return Date.from(date2LocalDate(date).with(TemporalAdjusters.firstDayOfMonth()).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 返回date所在月份结束时间
     */
    public static Date getMonthEnd(Date date) {
        return Date.from(date2LocalDate(date).with(TemporalAdjusters.lastDayOfMonth()).atTime(23, 59, 59).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 返回date对应的星期
     */
    public static String getWeekDay(Date date) {
        return date2LocalDate(date).getDayOfWeek().name();
    }

    /**
     * Localdate 与 Date 互转
     */
    // 01. java.util.Date --> java.time.LocalDateTime
    public static void UDateToLocalDateTime() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
    }

    // 02. java.util.Date --> java.time.LocalDate
    public static void UDateToLocalDate() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
    }

    // 03. java.util.Date --> java.time.LocalTime
    public static void UDateToLocalTime() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalTime localTime = localDateTime.toLocalTime();
    }


    // 04. java.time.LocalDateTime --> java.util.Date
    public static void LocalDateTimeToUdate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
    }


    // 05. java.time.LocalDate --> java.util.Date
    public static Date LocalDateToUdate(LocalDate localDate) {
//        localDate = LocalDate.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }

    // 06. java.time.LocalTime --> java.util.Date
    public static void LocalTimeToUdate() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
    }


    /**
     * 返回date步长计算日期
     */
    public static Date getDatePlus(Date date, int interval) {
        LocalDate dateL = date2LocalDate(date);
        return Date.from(dateL.plusDays(interval).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 返回date和time拼接的日期（字符串）
     */
    public static String getDateTimeJoinStr(Date date, String time) {
        return LocalDateTime.of(date2LocalDate(date), LocalTime.parse(time)).format(DATE_TIME_FORMAT);
    }

    /**
     * 返回start到end的日期序列
     */
    public static List<Date> getDateSeries(Date start, Date end) {
        List<Date> dateList = new ArrayList<>();
        LocalDate startLocal = date2LocalDate(start);
        LocalDate endLocal = date2LocalDate(end);
        long days = startLocal.until(endLocal, ChronoUnit.DAYS) + 1;
        Stream.iterate(startLocal, date -> date.plusDays(1)).limit(days).forEach(f -> dateList.add(Date.from(f.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())));
        return dateList;
    }

    /**
     * 获取开始 00:00:00
     */
    public static String getStartZero(Date dateTime, String pattern) {
        String start = AppDateUtils
                .formatDate(dateTime, pattern)
                .substring(0, 10) + "00:00:00";
        return start;
    }

    /**
     * TODO 需要修改
     *
     * @param dateTime
     * @param pattern
     * @return
     */
    public static String getStartZero(String dateTime, String pattern) {
        return dateTime + " 00:00:00";
    }

    /**
     * TODO 需要修改
     *
     * @param dateTime
     * @param pattern
     * @return
     */
    public static String getEndFiftyNine(Date dateTime, String pattern) {
        return dateTime + " 23:59:59";
    }

    public static String getEndFiftyNine(String dateTime, String pattern) {
//        Date dateTime1 = AppDateUtils.parseTime(dateTime);
//        String start = AppDateUtils
//                .formatDate(dateTime1, pattern)
//                .substring(0, 10) + "23:59:59";
        return dateTime + " 23:59:59";
    }

    /**
     * 返回start到end的日期序列（字符串）
     */
    public static List<String> getDateSeriesStr(Date start, Date end) {
        List<String> dateList = new ArrayList<>();
        LocalDate startLocal = date2LocalDate(start);
        LocalDate endLocal = date2LocalDate(end);
        long days = startLocal.until(endLocal, ChronoUnit.DAYS) + 1;
        Stream.iterate(startLocal, date -> date.plusDays(1)).limit(days).forEach(f -> dateList.add(f.toString()));
        return dateList;
    }

    /**
     * 将 yyyy.MM.dd的时间格式转换为 yyyy-MM-dd
     */
    public static String getPunchDate(String date) {
        return date.replace(".", "-");
    }

    /**
     * String转LocalDate
     */
    public static LocalDate String2LocalDate(String dateStr, String pattern) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);
        LocalDate date = LocalDate.parse(dateStr, fmt);
        return date;
    }

    /**
     * String转LocalDateTime
     */
    public static LocalDateTime String2LocalDateTime(String dateStr, String pattern) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime dateTime = LocalDateTime.parse(dateStr, fmt);
        return dateTime;
    }



}

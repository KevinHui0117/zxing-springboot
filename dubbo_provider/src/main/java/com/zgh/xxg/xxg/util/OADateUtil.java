package com.zgh.xxg.xxg.util;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author huikai
 * @ClassName: OADateUtil
 * @Description: 时间相关工具类
 * @date 2019-07-18 11:10:56
 */
public class OADateUtil {

    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_TIME = "HH:mm:ss";
    public static final String FORMAT_MONTH = "yyyy-MM";
    public static final String AREA_YEAR = "yyyy";
    public static final String AREA_MONTH = "MM";
    public static final String AREA_DAY = "dd";
    public static final String AREA_HOUR = "HH";
    public static final String AREA_MINUTE = "mm";
    public static final String AREA_SECOND = "ss";
    public static final String FORMAT_DATETIMENOSEC = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_DATETIMENOCHA = "yyyyMMddHHmmss";
    public static final String FORMAT_DATETIMENOSEC_CHS = "yyyy年MM月dd日 HH时mm分";

    /**
     * 当前时间向前推一个月 yyyy-mm-dd
     *
     * @return
     */
    public static String getDateMonthAgo() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); //得到前一天
        calendar.add(Calendar.MONTH, -1);//得到前一个月
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        String monthString = month < 10 ? "0" + String.valueOf(month) : String.valueOf(month);
        int day = calendar.get(Calendar.DATE) + 1;
        String dayString = day < 10 ? "0" + String.valueOf(day) : String.valueOf(day);
        return String.valueOf(year) + "-" + monthString + "-" + dayString;
    }

    /**
     * 当前时间 yyyy-mm-dd
     *
     * @return
     */
    public static String getDateCurrent() {
        String format = "yyyy-MM-dd";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }


    public static String getFormatDate(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static Date getDateByString(String str, String format) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sf.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException("日期时间格式错误");
        }
        return date;
    }

    public static String getCurrentDateTime() {
        return new SimpleDateFormat(FORMAT_DATETIME).format(new Date());
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat(FORMAT_DATE).format(new Date());
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat(FORMAT_TIME).format(new Date());
    }

    public static String getCurrentMonth() {
        return new SimpleDateFormat(FORMAT_MONTH).format(new Date());
    }


    /**
     * 时间比较
     *
     * @param date_time1
     * @param date_time2
     * @return
     */
    public static int compare(String date_time1, String date_time2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        try {
            cal1.setTime(new SimpleDateFormat(FORMAT_DATETIME).parse(date_time1.length() < 19 ? date_time1 + " 00:00:00" : date_time1));
            cal2.setTime(new SimpleDateFormat(FORMAT_DATETIME).parse(date_time2.length() < 19 ? date_time2 + " 00:00:00" : date_time2));
        } catch (ParseException e) {
            throw new RuntimeException("日期时间格式错误");
        }
        return cal1.compareTo(cal2);
    }

    public static int compare(String date_time1, String date_time2, String format) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        try {
            cal1.setTime(new SimpleDateFormat(format).parse(date_time1));
            cal2.setTime(new SimpleDateFormat(format).parse(date_time2));
        } catch (ParseException e) {
            throw new RuntimeException("日期时间格式错误");
        }
        return cal1.compareTo(cal2);
    }

    /**
     * 计算指定时间加上指定时间区域数量后的结果
     *
     * @param date       指定时间
     * @param part       计算部分
     * @param num        计算数量
     * @param ret_format 返回结果格式
     * @return 计算后的时间
     */
    public static String getDateAdd(String date, String part, int num, String ret_format) {
        Calendar cld = Calendar.getInstance();
        if (StringUtils.isBlank(ret_format)) {
            ret_format = FORMAT_DATETIME;
        }
        try {
            cld.setTime(new SimpleDateFormat(ret_format).parse(date));
            if (StringUtils.isNotBlank(part)) {
                if (part.equals("year") || part.equals("yyyy")) {
                    cld.add(Calendar.YEAR, num);
                } else if (part.equals("month") || part.equals("MM")) {
                    cld.add(Calendar.MONTH, num);
                } else if (part.equals("date") || part.equals("dd")) {
                    cld.add(Calendar.DATE, num);
                } else if (part.equals("hour") || part.equals("HH")) {
                    cld.add(Calendar.HOUR, num);
                } else if (part.equals("minute") || part.equals("mm")) {
                    cld.add(Calendar.MINUTE, num);
                } else if (part.equals("second") || part.equals("ss")) {
                    cld.add(Calendar.SECOND, num);
                }
            }
        } catch (ParseException e) {
            throw new RuntimeException("日期时间格式错误");
        }
        return new SimpleDateFormat(ret_format).format(cld.getTime());
    }

    /**
     * 获取时间相减差距(time1-time2)
     *
     * @param time1
     * @param time2
     * @param part
     * @return 差值
     */
    public static int diff(String time1, String time2, String part) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        try {
            cal1.setTime(new SimpleDateFormat(FORMAT_DATETIME).parse(time1.length() < 19 ? time1 + " 00:00:00" : time1));
            cal2.setTime(new SimpleDateFormat(FORMAT_DATETIME).parse(time2.length() < 19 ? time2 + " 00:00:00" : time2));
        } catch (ParseException e) {
            throw new RuntimeException("日期时间格式错误");
        }
        long s_times = cal1.getTimeInMillis() - cal2.getTimeInMillis();
        if (StringUtils.isNotBlank(part)) {
            if (part.equals("year") || part.equals("yyyy")) {
                return Integer.parseInt(time2.substring(0, 4)) - Integer.parseInt(time1.substring(0, 4));
            } else if (part.equals("month") || part.equals("mm")) {
                return ((Integer.parseInt(time2.substring(0, 4)) - Integer.parseInt(time1.substring(0, 4))) * 12 + (Integer.parseInt(time2.substring(5, 7)) - Integer.parseInt(time1.substring(5, 7))));
            } else if (part.equals("date") || part.equals("dd")) {
                return (int) (s_times / 1000 / 60 / 60 / 24);
            } else if (part.equals("hour") || part.equals("HH")) {
                return (int) (s_times / 1000 / 60 / 60);
            } else if (part.equals("minute") || part.equals("mm")) {
                return (int) (s_times / 1000 / 60);
            } else if (part.equals("second") || part.equals("ss")) {
                return (int) (s_times / 1000);
            }
        }
        return 0;
    }


    /**
     * 获取两个时间的实际天数差,不足1天算1天（例如：2014-03-21 12:00:00 到 2014-03-23 01:00:00 天数差为3天）
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static int dayDiff(String startTime, String endTime) {
        SimpleDateFormat format = new SimpleDateFormat(FORMAT_DATETIME);
        int actual_days = 0;
        startTime = startTime.length() < 19 ? startTime + " 00:00:00" : startTime;
        endTime = endTime.length() < 19 ? endTime + " 00:00:00" : endTime;
        try {
            long end = format.parse(endTime).getTime();
            long start = format.parse(startTime).getTime();
            if (end > start) {
                actual_days = (int) ((end - start + 86400000 - 1) / 86400000);
            }
        } catch (Exception e) {
            throw new RuntimeException("日期时间格式错误");
        }
        return actual_days;
    }

    /**
     * 获取该月的最后一天
     *
     * @param date_time
     * @param rs_format
     * @return 该月的最后一天
     */
    public static String getLastDayOfMonth(String date_time, String rs_format) {
        if (StringUtils.isBlank(rs_format)) {
            rs_format = FORMAT_DATETIME;
        }
        Calendar cld = Calendar.getInstance();
        try {
            cld.setTime(new SimpleDateFormat(rs_format).parse(date_time));
            cld.set(Calendar.DAY_OF_MONTH, cld.getActualMaximum(Calendar.DAY_OF_MONTH));
            cld.set(Calendar.HOUR_OF_DAY, 23);
            cld.set(Calendar.MINUTE, 59);
            cld.set(Calendar.SECOND, 59);
        } catch (Exception e) {
            throw new RuntimeException("日期时间格式错误");
        }
        return new SimpleDateFormat(rs_format).format(cld.getTime());
    }


    /**
     * 获取该月的第一天
     *
     * @param date_time
     * @param rs_format
     * @return
     */
    public static String getFirstDayOfMonth(String date_time, String rs_format) {
        if (StringUtils.isBlank(rs_format)) {
            rs_format = FORMAT_DATETIME;
        }
        Calendar cld = Calendar.getInstance();
        try {
            cld.setTime(new SimpleDateFormat(rs_format).parse(date_time));
            cld.set(Calendar.DAY_OF_MONTH, cld.getActualMinimum(Calendar.DAY_OF_MONTH));
            cld.set(Calendar.HOUR_OF_DAY, 0);
            cld.set(Calendar.MINUTE, 0);
            cld.set(Calendar.SECOND, 0);
        } catch (Exception e) {
            throw new RuntimeException("日期时间格式错误");
        }
        return new SimpleDateFormat(rs_format).format(cld.getTime());
    }

    /**
     * 转换不同格式的日期
     *
     * @param oldDate
     * @param oldFormat
     * @param newFormat
     * @return
     */
    public static String translateFormat(String oldDate, String oldFormat, String newFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(oldFormat);
        String newDate;
        try {
            Date date = sdf.parse(oldDate);
            newDate = new SimpleDateFormat(newFormat).format(date);
        } catch (ParseException e) {
            throw new RuntimeException("日期时间格式错误");
        }

        return newDate;
    }

    /**
     * 获取时间段内的月份列表
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    public static List<String> getMonthsFromTo(String fromDate, String toDate) {
        List<String> listStr = null;
        try {
            int fromYear = Integer.parseInt(fromDate.split("-")[0]);
            int toYear = Integer.parseInt(toDate.split("-")[0]);
            int fromMonth = Integer.parseInt(fromDate.split("-")[1]);
            int toMonth = Integer.parseInt(toDate.split("-")[1]);
            //如果开始日期小于结束日期
            if (fromYear == toYear && fromMonth <= toMonth || fromYear < toYear) {
                int months = (toYear - fromYear) * 12 + (toMonth - fromMonth);
                listStr = new ArrayList<String>();
                for (int i = fromMonth; i <= (fromMonth + months); i++) {
                    listStr.add((fromYear + Integer.parseInt(AccountUtil.formatUp(Double.parseDouble(i + "") / 12.0 + "", "#")) - 1) + "-" + (((i - 1) % 12 + 1) < 10 ? ("0" + ((i - 1) % 12 + 1)) : ((i - 1) % 12 + 1)));
                }
            } else {
                throw new RuntimeException("结束日期不能小于开始日期");
            }
        } catch (Exception e) {
            throw new RuntimeException("日期时间格式错误");
        }
        return listStr;
    }

    public static List<String> getMonthsFromTo(String date, int num) {
        List<String> list = new ArrayList<String>();
        int fromYear = Integer.parseInt(date.split("-")[0]);
        int fromMonth = Integer.parseInt(date.split("-")[1]);
        for (int i = fromMonth; i <= (fromMonth + num); i++) {
            list.add((fromYear + i / 13) + "-" + (((i - 1) % 12 + 1) < 10 ? ("0" + ((i - 1) % 12 + 1)) : ((i - 1) % 12 + 1)));
        }
        return list;
    }

    /**
     * 获取时间段内的日期
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    public static List<String> getDaysFromTo(String fromDate, String toDate) {
        List<String> listStr = new ArrayList<String>();
        listStr.add(fromDate);
        String dayAfter = "";
        Calendar cFrom = Calendar.getInstance();
        Calendar cTo = Calendar.getInstance();
        try {
            cFrom.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(fromDate.substring(0, 10)));
            cTo.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(toDate.substring(0, 10)));
            while (cFrom.compareTo(cTo) < 0) {
                int day = cFrom.get(Calendar.DATE);
                cFrom.set(Calendar.DATE, day + 1);
                dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(cFrom.getTime());
                listStr.add(dayAfter);
            }
        } catch (ParseException e) {
            throw new RuntimeException("日期时间格式错误");
        }

        return listStr;
    }

    @Test
    public void tt() throws Exception {


        System.out.println(this.compare("08:00:00", "08:59:00", FORMAT_TIME));
        System.out.println(this.getDaysFromTo("2019-10-01", "2019-10-05"));
        System.out.println(OADateUtil.getCurrentDate());
    }


    public static List<String> getDayOfWeekWithinDateInterval(String dataBegin, String dataEnd, int weekDays) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> dateResult = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        String[] dateInterval = {dataBegin, dataEnd};
        Date[] dates = new Date[dateInterval.length];
        for (int i = 0; i < dateInterval.length; i++) {
            String[] ymd = dateInterval[i].split("[^\\d]+");
            cal.set(Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1]) - 1, Integer.parseInt(ymd[2]));
            dates[i] = cal.getTime();
        }
        for (Date date = dates[0]; date.compareTo(dates[1]) <= 0; ) {
            cal.setTime(date);
            date = cal.getTime();
            if (cal.get(Calendar.DAY_OF_WEEK) - 1 == weekDays) {
                String format = sdf.format(date);
                dateResult.add(format);
            }
            cal.add(Calendar.DATE, 1);
            date = cal.getTime();
        }

        return dateResult;
    }


    public static List<String> getDayOfMonthWithinDateInterval(
            String dataBegin, String dataEnd, Integer monthDay) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> dateResult = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        String[] dateInterval = {dataBegin, dataEnd};
        Date[] dates = new Date[dateInterval.length];
        for (int i = 0; i < dateInterval.length; i++) {
            String[] ymd = dateInterval[i].split("[^\\d]+");
            cal.set(Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1]) - 1, Integer.parseInt(ymd[2]));
            dates[i] = cal.getTime();
        }
        for (Date date = dates[0]; date.compareTo(dates[1]) <= 0; ) {
            cal.setTime(date);

            if (cal.get(Calendar.DAY_OF_MONTH) == monthDay) {
                String format = sdf.format(date);
                dateResult.add(format);
            }
            cal.add(Calendar.DATE, 1);
            date = cal.getTime();
        }
        return dateResult;
    }

    /**
     * 获取日程管理json月份查询的上个月的第一天 以及下个月的最后一天
     *
     * @param start
     * @throws Exception
     */
    public static String getDateRange(String start) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String reusult = "";
        try {
            Date date = sdf.parse(start);
            Calendar c = Calendar.getInstance();
            //设置为指定日期
            c.setTime(date);
            //指定日期月份减去一
            String ex = "";
            String px = "";
            if (c.get(Calendar.DAY_OF_MONTH) == 1) {
                //System.out.println("2");
                c.add(Calendar.MONTH, -1);
                c.set(Calendar.DATE, 1);
                Date firstDateOfPrevMonth = c.getTime();
                ex = sdf.format(firstDateOfPrevMonth);
                //System.out.println("上月第一天：" + ex);
                c.setTime(date);
                c.add(Calendar.MONTH, 1);
                c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
                Date lastDateOfPrevMonth = c.getTime();
                px = sdf.format(lastDateOfPrevMonth);
                //System.out.println("下个月月最后一天：" + px);
                reusult = ex + "&" + px;
            } else {
                c.set(Calendar.DATE, 1);
                Date firstDateOfPrevMonth = c.getTime();
                ex = sdf.format(firstDateOfPrevMonth);
                //System.out.println("上月第一天：" + ex);
                c.setTime(date);
                c.add(Calendar.MONTH, 2);
                c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
                Date lastDateOfPrevMonth = c.getTime();
                px = sdf.format(lastDateOfPrevMonth);
                //System.out.println("下个月月最后一天：" + px);
                reusult = ex + "&" + px;
            }
        } catch (Exception e) {
        }
        return reusult;

    }

    /**
     * 得到几天后或几天前的时间 ：之后+n，之-n
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    public static String toZeroFormat(String dataNoZero) {
        String[] dataEpic = dataNoZero.split("-");
        String month = dataEpic[1];
        String day = dataEpic[2];
        if (dataEpic[1].length() == 1)
            month = "0" + dataEpic[1];
        else day = dataEpic[1];
        if (dataEpic[2].length() == 1)
            day = "0" + dataEpic[2];
        else day = dataEpic[2];
        return dataEpic[0] + "-" + month + "-" + day;
    }

    public static String toNozeroFormat(String dataOrinal) {
        String[] dataEpic = dataOrinal.split("-");
        String month = "";
        String day = "";
        if (dataEpic[1].indexOf("0") == 0)
            month = dataEpic[1].substring(1, dataEpic[1].length());
        else month = dataEpic[1];
        if (dataEpic[2].indexOf("0") == 0)
            day = dataEpic[1].substring(1, dataEpic[2].length());
        else day = dataEpic[2];
        return dataEpic[0] + "-" + month + "-" + day;
    }

    public static Date parseTimeString2Date(String timeString) {
        if ((timeString == null) || (timeString.equals(""))) {
            return null;
        }
        Date date = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = new Date(dateFormat.parse(timeString).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String convertDate2String(Date date, String pattern) {
        if (date == null)
            return null;
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    public static String getYear(String timeString, String pattern) {
        return timeString.substring(0, 4);
    }

    public static String getMonth(String timeString, String pattern) {
        return timeString.substring(5, 7);
    }

    public static String getDay(String timeString, String pattern) {
        return timeString.substring(8, 10);
    }

    public static String getHour(String timeString, String pattern) {
        return timeString.substring(11, 13);
    }

    public static String getMinute(String timeString, String pattern) {
        return timeString.substring(14, 16);
    }

    public static String getSecond(String timeString, String pattern) {
        return timeString.substring(17, 19);
    }

    /**
     * 取得当月天数
     */
    public static int getCurrentMonthLastDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 得到指定月的天数
     */
    public static int getMonthLastDay(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 功能说明：得到昨天的日期
     *
     * @param date
     * @return
     */
    public static Date getYesterday(Date date) {
        Date yesDate = new Date(date.getTime() - 24 * 60 * 60 * 1000);
        return yesDate;
    }

    /**
     * 功能说明：得到N天前的日期
     *
     * @param date
     * @param day  往前推的天数
     * @return
     */
    public static Date getOldDayByNum(Date date, Long day) {
        Date yesDate = new Date(date.getTime() - day * 24 * 60 * 60 * 1000);
        return yesDate;
    }

    /**
     * 功能说明：得到当前日期字符串
     *
     * @param format 日期格式，默认"yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String getNowDateString(String format) {
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 功能说明：按给定的日期转字符串
     *
     * @param date   给定的日期
     * @param format 日期格式，默认"yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String getDateString(Date date, String format) {
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 功能说明：字符串转Date
     *
     * @param dateStr 日期字符串
     * @param format  日期格式，默认"yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static Date DateFormatString(String dateStr, String format) {
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date;
        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            date = new Date();
        }
        return date;
    }

    public static String getDateDiffStringNostyle(Date date1, Date date2) {

        StringBuffer sb = new StringBuffer();
        long l = date2.getTime() - date1.getTime();
        if (l < 0) {
            sb.append("0天0小时0分0秒");
            return sb.toString();
        }
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        sb.append(day).append("天").append(hour).append("小时")
                .append(min).append("分").append(s).append("秒");
        return sb.toString();
    }

    public static String getDateDiffString(Date date1, Date date2) {

        StringBuffer sb = new StringBuffer();
        long l = date2.getTime() - date1.getTime();
        String s1 = "<font style=\"font-size: 14px;\" color=\"red\">";
        String s2 = "</font>";
        if (l < 0) {
            sb.append(s1).append(0).append(s2).append("天")
                    .append(s1).append(0).append(s2).append("小时")
                    .append(s1).append(0).append(s2).append("分")
                    .append(s1).append(0).append(s2).append("秒");
            return sb.toString();
        }
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        sb.append(s1).append(day).append(s2).append("天")
                .append(s1).append(hour).append(s2).append("小时")
                .append(s1).append(min).append(s2).append("分")
                .append(s1).append(s).append(s2).append("秒");
        return sb.toString();
    }

    public static String getDateDiffString(Date date1, Object obj) {
        StringBuffer sb = new StringBuffer();
        Date date2 = null;
        String s1 = "<font style=\"font-size: 14px;\" color=\"red\">";
        String s2 = "</font>";
        try {
            date2 = (Date) obj;
        } catch (Exception e) {
            sb.append(s1).append(0).append(s2).append("天")
                    .append(s1).append(0).append(s2).append("小时")
                    .append(s1).append(0).append(s2).append("分")
                    .append(s1).append(0).append(s2).append("秒");
            return sb.toString();
        }
        long l = date2.getTime() - date1.getTime();
        if (l < 0) {
            sb.append(s1).append(0).append(s2).append("天")
                    .append(s1).append(0).append(s2).append("小时")
                    .append(s1).append(0).append(s2).append("分")
                    .append(s1).append(0).append(s2).append("秒");
            return sb.toString();
        }
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        sb.append(s1).append(day).append(s2).append("天")
                .append(s1).append(hour).append(s2).append("小时")
                .append(s1).append(min).append(s2).append("分")
                .append(s1).append(s).append(s2).append("秒");
        return sb.toString();
    }

    public static String getDateDiffString2(Date date2) {
        Date date1 = new Date();
        StringBuffer sb = new StringBuffer();
        long l = date2.getTime() - date1.getTime();
        String s1 = "<font style=\"font-size: 14px;\" color=\"red\">";
        String s2 = "</font>";
        if (l < 0) {
            sb.append(s1).append(0).append(s2).append("天")
                    .append(s1).append(0).append(s2).append("小时")
                    .append(s1).append(0).append(s2).append("分")
                    .append(s1).append(0).append(s2).append("秒");
            return sb.toString();
        }
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        sb.append(s1).append(day).append(s2).append("天")
                .append(s1).append(hour).append(s2).append("小时")
                .append(s1).append(min).append(s2).append("分")
                .append(s1).append(s).append(s2).append("秒");
        return sb.toString();
    }

    /**
     * 获取是星期几
     *
     * @return
     * @throws Exception
     */
    public static String getWeekOfDate(String dateString) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateString);
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }

    public static boolean isCurMonth(String yearMonth) {

        String format = "yyyy-MM";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date).equals(yearMonth);
    }

    public static int getToday() {
        return new Date().getDate();
    }

    public static String getTodayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    /**
     * 确定是不是节假日,是节假日返回false ，工作日进行数据抓取返回true
     * 返回    0：工作日, 1：正常休息日, 2：代表是法定节假日休息。
     * dateStr: 20190101
     */
    public static boolean isHoliday(String dateStr) {
        try {
            String url = "http://tool.bitefu.net/jiari/?d=" + dateStr.replace("-", "");
            String result = sendGet(url);
            int code = Integer.valueOf(result.trim());
            System.out.println(result);
            return code == 2;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String sendGet(String httpurl) {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;// 返回结果字符串
        try {
            URL url = new URL(httpurl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(60000);
            connection.connect();
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                }
                result = sbf.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            connection.disconnect();// 关闭远程连接
        }
        return result;
    }
    public static String getYesterday() {
        return getDateString(getYesterday(new Date()), "yyyy-MM-dd");
    }

    public static String getCurrentDateTime(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

    public static String getNextMonth() {
        Calendar cld = Calendar.getInstance();
        cld.setTime(new Date());
        cld.add(Calendar.MONTH, 1);
        return new SimpleDateFormat("yyyy-MM").format(cld.getTime());
    }

    /**
     * 判断开始日期和结束日期是否包含该月份
     * @param sDate 格式：10-12
     * @param eDate
     * @param month
     * @return
     */
    public static boolean isContainMonth(String sDate, String eDate, int month){

        try{
            String ssDate = month+"-01";
            String eeDate = getLastDayOfMonth(ssDate, "MM-dd");
            int c1 = compare(sDate, ssDate, "MM-dd");
            int c2 = compare(eDate, eeDate, "MM-dd");
            return c1<=0 && c2>=0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    
    public static String getWeekTimeInterval(Date date) {  
    	String format = "yyyy-MM-dd";
      
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
        if (1 == dayWeek) {  
           cal.add(Calendar.DAY_OF_MONTH, -1);  
        }  
        // System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期  
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
        cal.setFirstDayOfWeek(Calendar.MONDAY);  
        // 获得当前日期是一个星期的第几天  
        int day = cal.get(Calendar.DAY_OF_WEEK);  
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值  
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);  
        String imptimeBegin = sdf.format(cal.getTime());  
        // System.out.println("所在周星期一的日期：" + imptimeBegin);  
        cal.add(Calendar.DATE, 6);  
        String imptimeEnd = sdf.format(cal.getTime());  
        // System.out.println("所在周星期日的日期：" + imptimeEnd);  
        return imptimeBegin + "," + imptimeEnd;  
   }
    
    public static void main(String[] args) throws Exception {
//        System.out.println(isHoliday("2019-01-01"));
//        System.out.println(getYear());
//        System.out.println(getLastDayOfMonth("1-1", "MM-dd"));
//        System.out.println(isContainDay("2000-7-1", "2001-5-1", "2001-4-02"));
//        System.out.println(isContainMonth("3-1", "4-30", 3));
//        System.out.println(isMinContain("2000-9-1", "2001-5-12", "2000-10-02"));
//        System.out.println(getNextDay("2020-1-01"));
String time ="2019-1-31 12:00:59";
        Date date  = OADateUtil.getDateByString(time,OADateUtil.FORMAT_DATETIMENOSEC);
        String dateStr = OADateUtil.getFormatDate(date,OADateUtil.FORMAT_DATETIMENOSEC_CHS);
        System.out.println(dateStr);

    }


    public static int getYear() {
        return Integer.valueOf(getCurrentDate().substring(0, 4));
    }

    public static int getMonth() {
        return Integer.valueOf(getCurrentDate().substring(5, 7));
    }

    /**
     * 判断开始日期和结束日期是否包含该日期
     * @param sDate 格式：2000-10-12
     * @param eDate
     * @param ymd 格式：2000-10-12
     */
    public static boolean isContainDay(String sDate, String eDate, String ymd) {
        try{
            int c1 = compare(sDate, ymd, "yyyy-MM-dd");
            int c2 = compare(eDate, ymd, "yyyy-MM-dd");
            return c1<=0 && c2>=0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断开始日期和结束日期是否包含或交叉或被包含该月份
     * @param sDate 格式：2000-10-12
     * @param eDate
     * @param ym
     */
    public static boolean isMinContain(String sDate, String eDate, String ym) {
        try{
            String ssDate = ym+"-01";
            String eeDate = getLastDayOfMonth(ssDate, "yyyy-MM-dd");
            int c1 = compare(sDate, eeDate, "yyyy-MM-dd");
            int c2 = compare(eDate, ssDate, "yyyy-MM-dd");
            return !(c1>0 || c2<0);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public static String getNextDay(String zhbDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cld = Calendar.getInstance();
        try {
            cld.setTime(sdf.parse(zhbDate));
            cld.add(Calendar.DAY_OF_MONTH, 1);
            return sdf.format(cld.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return zhbDate;
    }

    public static String getTommorowDate() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cld = Calendar.getInstance();
        cld.setTime(new Date());
        cld.add(Calendar.DAY_OF_MONTH, 1);
        return sdf.format(cld.getTime());
    }

    public static String getNextHourFm() {

        SimpleDateFormat sdf = new SimpleDateFormat("H");
        int h = Integer.valueOf(sdf.format(new Date()));
        h++;

        sdf = new SimpleDateFormat("mm");
        String mm = sdf.format(new Date());
        h = h==24 ? 0 : h;
        String hh = h<10 ? "0"+h : h+"";
        return hh;
    }

}
































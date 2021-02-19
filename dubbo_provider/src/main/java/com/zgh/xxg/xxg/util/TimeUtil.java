package com.zgh.xxg.xxg.util;

import com.zgh.xxg.xxg.exception.BaseException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class TimeUtil {

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
            } else if (part.equals("month") || part.equals(AREA_MONTH)) {
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
    public void tt() {
        String finishTime = "18:00";
        //System.out.println(TimeUtil.getDaysFromTo("2019-07-09","2019-07-10"));
        //System.out.println(TimeUtil.getDayOfMonthWithinDateInterval("2019-10-3","2019-12-3", 3));
        System.out.println(TimeUtil.compare("2019-07-12" + " " + finishTime, TimeUtil.getDateAdd(TimeUtil.getFormatDate(new Date(), TimeUtil.FORMAT_DATETIMENOSEC), "dd", 1, TimeUtil.FORMAT_DATETIMENOSEC), TimeUtil.FORMAT_DATETIMENOSEC) >= 0);


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
        String month = "";
        String day = "";
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
     * 判断 是否在这区间内  （]  只包含右边界
     * @param startLoopTimeTemp
     * @param endLoopTimeTemp
     * @param sendTimeTemp
     * @return
     * @throws Exception
     */
	public static boolean isBetweenLoop(String startLoopTimeTemp,
			String endLoopTimeTemp, String sendTimeTemp) throws Exception {
		if(endLoopTimeTemp.equals(sendTimeTemp))
			return true;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date startLoopTime = sdf.parse(startLoopTimeTemp);
		Date endLoopTime = sdf.parse(endLoopTimeTemp);
		Date sendTime = sdf.parse(sendTimeTemp);
		if (sendTime.after(startLoopTime) && sendTime.before(endLoopTime)) {
            return true;
        } else {
            return false;
        }
	}

    /**
     * 根据时间获取年龄
     * @param birthDay
     * @return
     * @throws ParseException
     */
    public static int getAgeByBirth(Date birthDay) throws BaseException {
        int age = 0;
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
            throw new IllegalArgumentException(
                    "出生时间晚于当前时间，无法计算");
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
            } else {
                age--;//当前月份在生日之前，年龄减一
            }
        }
        return age;
    }
    
   public static int getSeason(String date){
	   if(StringUtils.isBlank(date)){
		   date=TimeUtil.getCurrentDate();
	   }
	   date=date.substring(5,7);
	  if("01".equals(date) || "02".equals(date) || "03".equals(date)){
		  return 1;
	  }else if("04".equals(date) || "05".equals(date) || "06".equals(date)){
		  return 2;
	  }else if("07".equals(date) || "08".equals(date) || "09".equals(date)){
		  return 3;
	  }else{
		  return 4;
	  }
	  
	   
   }
}





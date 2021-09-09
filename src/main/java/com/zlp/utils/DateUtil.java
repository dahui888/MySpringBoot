package com.zlp.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public final static String YYYY_MM_DD = "yyyy-MM-dd";
    public final static String MM_DD = "MM-dd";
    public final static String YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
    public final static String yyyyMMddHHmm = "yyyyMMddHHmm";
    public final static String HHMM = "hh:mm";
    public final static String HH = "HH";
    public final static String STR_SUFFIX = " 00:00:00";
    public final static String END_SUFFIX = " 23:59:59";

    /**
     * 根据生日获取年龄
     *
     * @param birthday
     * @return
     */
    public static Integer getAge(Date birthday) {
        if (birthday == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthday)) { //出生日期晚于当前时间，无法计算
            return 0;
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
            } else {
                age--;//当前月份在生日之前，年龄减一
            }
        }
        return age;
    }

    /**
     * 字符串转日期
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date StringToDate(String dateStr, String format) {
        try {
            SimpleDateFormat sf = new SimpleDateFormat(format);
            return sf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getStringDate(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(data);
    }

    public static String getStringDate(Date data, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(data);
    }

    /**
     * 根据18位身份证获取生日
     *
     * @param certificateNo
     * @return
     */
    public static String getBirthdayStr(String certificateNo) {
        String birthday = "";
        if (certificateNo.length() == 18) {
            birthday = certificateNo.substring(6, 10) + "-" + certificateNo.substring(10, 12) + "-"
                    + certificateNo.substring(12, 14);
        }
        return birthday;
    }

    /**
     * 获取生日
     *
     * @param certificateNo
     * @return
     */
    public static Date getBirthday(String certificateNo) {
        return StringToDate(getBirthdayStr(certificateNo), YYYY_MM_DD);
    }

    /**
     * 根据18位身份证获取性别
     *
     * @param certificateNo
     * @return
     */
    public static String getSex(String certificateNo) {
        String sexCode = "";
        if (certificateNo.length() == 18) {
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 4, certificateNo.length() - 1))
                    % 2 == 0 ? "2" : "1";
        }
        return sexCode;
    }

    /**
     * 获取开始时间+minute大于结束时间的毫秒数
     *
     * @param start
     * @param end
     * @param minute
     * @return
     */
    public static long getDifTime(Date start, Date end, int minute) {
        long between = 0;
        try {
            start = addDateMinute(start, minute);
            between = (start.getTime() - end.getTime());// 得到两者的毫秒数  
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return between;
    }

    /**
     * 给一个时间延长多少天
     *
     * @param date
     * @param day
     * @return
     */
    public static Date addDateDay(Date date, int day) {
        if (date == null) {
            return new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, day);
        date = cal.getTime();
        return date;
    }

    /**
     * 给一个时间延长多少小时
     *
     * @param date
     * @param hours
     * @return
     */
    public static Date addDateHour(Date date, int hours) {
        if (date == null) {
            return new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hours);// 24小时制
        date = cal.getTime();
        return date;
    }

    /**
     * 给一个时间延长多少分钟
     *
     * @param date
     * @param minute
     * @return
     */
    public static Date addDateMinute(Date date, int minute) {
        if (date == null) {
            return new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minute);// 24小时制
        date = cal.getTime();
        return date;
    }

    /**
     * 获取两个时间差(分钟)
     *
     * @param start
     * @param end
     * @return
     */
    public static Integer getDifMinute(Date start, Date end) {
        int minute = 0;
        try {
            long between = (end.getTime() - start.getTime());// 得到两者的毫秒数
            minute = (int) between / 1000 / 60;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return minute;
    }

    /**
     * 获取两个时间差(天)
     *
     * @param start
     * @param end
     * @return
     */
    public static Integer getDifDay(Date start, Date end) {
        Integer minute = 0;
        try {
            long between = (end.getTime() - start.getTime());// 得到两者的毫秒数
            minute = (int) (between / 1000 / 60 / 60 / 24);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return minute;
    }

    /**
     * 获取系统当前时间
     *
     * @param
     * @date: 2020/6/21 12:06
     * @return: java.util.Date
     */
    public static Date getCurrentTime() {
        return new Date();
    }

    /**
     * 获取当前月第一天
     *
     * @date: 2020/7/9 15:00
     * @return: java.util.Date
     */
    public static Date getCurMonthFistDay() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        //将小时、分钟、秒、毫秒域清零
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获取当前月最后一天
     *
     * @date: 2020/7/9 15:00
     * @return: java.util.Date
     */
    public static Date getCurMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        //将小时、分钟、秒、毫秒域清零
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }


    /**
     * 星期日=星期7 此处根据需要灵活改动即可
     *
     * @param date
     * @date: 2020/7/16 11:41
     * @return: java.lang.String
     */
    public static String getWeek(Date date) {

        String[] weekDays = {"日", "一", "二", "三", "四", "五", "六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0) w = 0;
        return weekDays[w];
    }

    /**
     * 获取当前小时
     *
     * @date: 2020/7/16 11:41
     * @return: java.lang.String
     */
    public static String getCurHour() {

        String curHour = DateUtil.getStringDate(DateUtil.getCurrentTime(), "HH");
        return curHour;
    }


    /**
     * 两个时间相差距离小时
     *
     * @param curDate 当前时间
     * @param data    时间参数 2 格式：2009-01-01 12:00:00
     * @return String 返回值为：xx天xx小时xx分xx秒
     */
    public static long getDistanceHour(Date curDate, Date data) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long hour = 0;
        long day = 0;


        long time1 = curDate.getTime();
        long time2 = data.getTime();
        long diff;
        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        day = diff / (24 * 60 * 60 * 1000);
        hour = (diff / (60 * 60 * 1000) - day * 24);
        return hour;
    }


}

package com.ehome.niuyunyang.nyylib.util.dateutil;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class DateUtil {
    public static final long DAY_LONG = 1000 * 60 * 60 * 24;
    public static final long HOUR_LONG = 1000 * 60 * 60;
    public static final long MINUTE_LONG = 1000 * 60;
    private final SimpleDateFormat longHourSdf;
    private final SimpleDateFormat longSdf;

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        System.out.println(1000 * 60 * 60 * 24);
    }

    private DateUtil() {
        throw new Error("不要实例化!");
    }

    public static long getCurrentMonthStartTime() {
        Calendar c = Calendar.getInstance();
        long l = 0;
        try {
            c.set(Calendar.DATE, 1);
            l = c.getTimeInMillis() - getDayOfWeekForint(c.getTimeInMillis()) * DAY_LONG;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    /**
     * @param date
     * @return
     */
    public static Map<String, Long> getFirstday_Lastday_Month(CustomData date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(date.getLongDate()));
        calendar.add(Calendar.MONTH, -1);
        Date theDate = calendar.getTime();

        //上个月第一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        long day_first = gcLast.getTime().getTime() - getDayOfWeekForint(gcLast.getTimeInMillis()) * DAY_LONG;
//        StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
//        day_first = str.toString();

        //上个月最后一天
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);        //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
        long day_last = calendar.getTime().getTime() + (7 - getDayOfWeekForint(calendar.getTimeInMillis())) * DAY_LONG;
//        StringBuffer endStr = new StringBuffer().append(day_last).append(" 23:59:59");
//        day_last = endStr.toString();

        Map<String, Long> map = new HashMap<String, Long>();
        map.put("first", day_first);
        map.put("last", day_last);
        return map;
    }

    public static Map<String, Long> getFirstday_Lastday_Month(long date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(date));
        calendar.add(Calendar.MONTH, -1);
        Date theDate = calendar.getTime();

        //上个月第一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        long day_first = gcLast.getTime().getTime() - getDayOfWeekForint(gcLast.getTimeInMillis()) * DAY_LONG;
//        StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
//        day_first = str.toString();

        //上个月最后一天
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);        //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
        long day_last = calendar.getTime().getTime() + (7 - getDayOfWeekForint(calendar.getTimeInMillis())) * DAY_LONG;
//        StringBuffer endStr = new StringBuffer().append(day_last).append(" 23:59:59");
//        day_last = endStr.toString();

        Map<String, Long> map = new HashMap<String, Long>();
        map.put("first", day_first);
        map.put("last", day_last);
        return map;
    }

    /**
     * @return
     */
    public static long getCurrentMonthEndTime() {
        Calendar c = Calendar.getInstance();
        long l = 0;
        try {
            c.set(Calendar.DATE, 1);
            c.add(Calendar.MONTH, 1);
            c.add(Calendar.DATE, -1);
            l = c.getTimeInMillis() + (7 - getDayOfWeekForint(c.getTimeInMillis())) * DAY_LONG;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    /**
     * 根据long获得当前是周几（例：周一）
     *
     * @param i
     * @return
     */
    public static String getDayOfWeek(long i) {
        String day = "错误";
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(i);
        int dayofweek = c.get(Calendar.DAY_OF_WEEK);
        switch (dayofweek) {
            case Calendar.MONDAY:
                day = "星期一";
                break;
            case Calendar.TUESDAY:
                day = "星期二";
                break;
            case Calendar.WEDNESDAY:
                day = "星期三";
                break;
            case Calendar.THURSDAY:
                day = "星期四";
                break;
            case Calendar.FRIDAY:
                day = "星期五";
                break;
            case Calendar.SATURDAY:
                day = "星期六";
                break;
            case Calendar.SUNDAY:
                day = "星期日";
                break;
            default:
                break;
        }
        return day;
    }

    public static int getDayOfWeekForInt(long i) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(i);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    public static int getDayOfWeekForint(long i) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(i);
        int dayofweek = c.get(Calendar.DAY_OF_WEEK);
        return dayofweek;
    }

    /**
     * 根据long获得当前是几点（24小时制）
     *
     * @param i
     * @return
     */
    public static int getHourOfDay(long i) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(i);
        return c.get(Calendar.HOUR_OF_DAY);
    }


    /**
     * 比较两个时间相差几天
     * <a href="xi.yang@i-jia.net">yangxi</a>
     *
     * @param start
     * @param end
     * @return
     */
    public static int getDiffDay(long start, long end) {
        long diff = end - start;
        if (diff > 0) {
            diff = diff + DAY_LONG - 1;
        }
        int diffDay = (int) ((diff) / DAY_LONG);
        return diffDay;
    }


    /**
     * 获取定时器时间表达式
     *
     * @param i
     * @return
     */
    public static String getConExpression(long i) {
        int y = getYear(i);
        int mo = getMonth(i);
        int d = getDay(i);
        int h = getHour(i);
        int mm = getMinute(i);
        int s = getSecond(i);
        return s + " " + mm + " " + h + " " + d + " " + mo + " " + "?" + " " + y;
    }

    public static int getYear(long i) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(i);
        return c.get(Calendar.YEAR);
    }

    public static int getMonth(long i) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(i);
        return c.get(Calendar.MONTH) + 1;
    }

    public static int getDay(long i) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(i);
        return c.get(Calendar.DATE);
    }

    public static int getHour(long i) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(i);
        return c.get(Calendar.HOUR);
    }

    public static int getMinute(long i) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(i);
        return c.get(Calendar.MINUTE);
    }

    public static int getSecond(long i) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(i);
        return c.get(Calendar.SECOND);
    }

    /**
     * 得到某年某月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static long getFirstDayOfMonth(int year, int month) {

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, year);

        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));


        return cal.getTime().getTime();
    }

    public static long getFirstDayOfYear(int year) {

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        cal.set(Calendar.DAY_OF_YEAR, cal.getMinimum(Calendar.DATE));


        return cal.getTime().getTime();
    }

    public static long getLastDayOfYear(int year) {

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, year);


        cal.set(Calendar.DAY_OF_YEAR, cal.getMinimum(Calendar.DATE));


        return cal.getTime().getTime();
    }

    public static String getFirstDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        //设置该周第一天为星期一
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String firstDayOfWeek = sdf.format(cal.getTime());

        return firstDayOfWeek;
    }

    public static long getFirstDayOfWeek(long l) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(l);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        //设置该周第一天为星期一
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        //格式化日期

        return cal.getTimeInMillis();
    }

    public static long getFirstOfDay(long l) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTimeInMillis();
    }

    public static Long getFirstDayOfWeekForLong() {
        Calendar cal = Calendar.getInstance();
        //设置该周第一天为星期一
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        return cal.getTimeInMillis();
    }

    public static Long getFirstDayOfWeekForLong(long l) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(l);
        //设置该周第一天为星期一
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        return cal.getTimeInMillis();
    }

    // 获取当前时间所在周的结束日期
    public static Long getLastDayOfWeekForLong() {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return c.getTimeInMillis();
    }

    // 获取当前时间所在周的结束日期
    public static String getLastDayOfWeek() {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String endDayOfWeek = sdf.format(c.getTime());
        return endDayOfWeek;
    }

    // 获取当前时间所在周的结束日期
    public static long getLastDayOfWeek(long date) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTimeInMillis(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTimeInMillis();
    }

    /**
     * 获取某年最后一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getCurrYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }

    /**
     * 得到某年某月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static long getLastDayOfMonth(int year, int month) {

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, year);

        cal.set(Calendar.MONTH, month - 1);

        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, value);

        return cal.getTime().getTime();

    }

    /**
     * 格式化long型时间为指定格式的String类型
     *
     * @param time
     * @param datePrex 指定时间格式
     * @return
     */
    public static String fmtLong2String(long time, DatePrex datePrex) {
        if (time==0){
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(datePrex.toString());
        return format.format(new Date(time));
    }

    public static String getCurrentTimeString(DatePrex datePrex) {
        return fmtLong2String(System.currentTimeMillis(), datePrex);
    }

    public static long getLongDate(Long data) {
        return DateUtil.covertString2Long(getYear(data) + "-" + getMonth(data) + "-" + getDay(data));
    }

    /**
     * 将String类型的格式化字符串转为long类型<br/>
     * 支持的String格式：<br/>
     * yyyyMMdd<br/>
     * yyyy-MM-dd<br/>
     * yyMMdd<br/>
     * yyyy-MM-dd HH:mm:ss<br/>
     * yyyyMMddHHmm<br/>
     *
     * @param date
     */
    public static long covertString2Long(String date) {
        Pattern yyyyMMdd = Pattern.compile("\\d{8}");
        Pattern yyyyMMddHHss = Pattern.compile("\\d{12}");
        Pattern yyyy_MM_HH = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}");
        Pattern yyMMdd = Pattern.compile("\\d{6}");
        Pattern yyyy_MM_dd_HH_mm_ss = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}");

        SimpleDateFormat sdf = null;

        if (date.trim().length() == 0) {
            return -1;
        }
        if (yyyyMMdd.matcher(date).matches()) {
            sdf = new SimpleDateFormat("yyyyMMdd");
        } else if (yyyy_MM_HH.matcher(date).matches()) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        } else if (yyMMdd.matcher(date).matches()) {
            sdf = new SimpleDateFormat("yyMMdd");
        } else if (yyyy_MM_dd_HH_mm_ss.matcher(date).matches()) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else if (yyyyMMddHHss.matcher(date).matches()) {
            sdf = new SimpleDateFormat("yyyyMMddHHmm");
        }

        try {
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(sdf.parse(date).getTime());
            return c.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 判断时间是否超出
     *
     * @param cha 传入的时间差
     * @return
     */
    public static TimeAboutHourAndDay getDiffDay(long cha) {
        TimeAboutHourAndDay hourOrDay = new TimeAboutHourAndDay();
        int time = (int) (cha / DAY_LONG);
        if (time == 0) {
            time = (int) (cha / HOUR_LONG);
            hourOrDay.setType(TimeAboutHourAndDay.TYPE_HOUR);
        }
        hourOrDay.setTime(time);
        return hourOrDay;
    }

    /**
     * 根据日期字符串判断当月第几周
     *
     * @param i
     * @return
     * @throws Exception
     */
    public static int getWeek(long i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(i);
        //第几周
        int week = calendar.get(Calendar.WEEK_OF_MONTH);
//        第几天，从周日开始
//        int day = calendar.get(Calendar.DAY_OF_WEEK);
        return week;
    }

    /**
     * 判断是否为同一天
     *
     * @param time
     * @param time1
     * @return
     */
    public static boolean isSameDay(long time, long time1) {
        boolean b = false;
        if (getYear(time) == getYear(time1) && getMonth(time) == getMonth(time1) && getDay(time) == getDay(time1)) {
            b = true;
        }

        return b;
    }

    public static String getRemind(long beforeTime) {
        String Remind = "无";
        if (beforeTime == 5 * DateUtil.MINUTE_LONG) {
            Remind = "开始前 5 分钟";
        } else if (beforeTime == 10 * DateUtil.MINUTE_LONG) {
            Remind = "开始前 10 分钟";
        } else if (beforeTime == 15 * DateUtil.MINUTE_LONG) {
            Remind = "开始前 15 分钟";
        } else if (beforeTime == 30 * DateUtil.MINUTE_LONG) {
            Remind = "开始前 30 分钟";
        } else if (beforeTime == DateUtil.HOUR_LONG) {
            Remind = "开始前 1 小时";
        } else if (beforeTime == DateUtil.DAY_LONG) {
            Remind = "开始前 1 天";
        } else if (beforeTime == 2 * DateUtil.DAY_LONG) {
            Remind = "开始前 2 天";
        } else if (beforeTime == 7 * DateUtil.DAY_LONG) {
            Remind = "开始前 1 周";
        } else if (beforeTime == 1) {
            Remind = "到点提醒";
        }

        return Remind;
    }
}

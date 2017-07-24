package com.ehome.niuyunyang.nyylib.util.dateutil;


import java.io.Serializable;

public class CustomData implements Serializable {
    private static final long serialVersionUID = 1L;
    public int year;
    public int month;
    public int day;
    public int week;

    public int longData;

    public CustomData(int year, int month, int day) {
        if (month > 12) {
            month = 1;
            year++;
        } else if (month < 1) {
            month = 12;
            year--;
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public CustomData() {
        this.year = DataUtil.getYear();
        this.month = DataUtil.getMonth();
        this.day = DataUtil.getCurrentMonthDay();
    }

    public static CustomData modifiDayForObject(CustomData date, int day) {
        CustomData modifiDate = new CustomData(date.year, date.month, day);
        return modifiDate;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public long getLongDate() {
        return DateUtil.covertString2Long(year + "-" + month + "-" + day);
    }
    public void setLongData(long longData){
        year=DateUtil.getYear(longData);
        month=DateUtil.getMonth(longData);
        day=DateUtil.getDay(longData);
    }
}

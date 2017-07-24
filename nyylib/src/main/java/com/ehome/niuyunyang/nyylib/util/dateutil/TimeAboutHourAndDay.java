package com.ehome.niuyunyang.nyylib.util.dateutil;

/**
 * Created by UI2 on 2015/12/25.
 */
public class TimeAboutHourAndDay {
    public static final int TYPE_HOUR = 1;//小时数
    public static final int TYPE_DAY = 2;//天数
    int type;
    int time;
    public TimeAboutHourAndDay(){
        type = TYPE_DAY;
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

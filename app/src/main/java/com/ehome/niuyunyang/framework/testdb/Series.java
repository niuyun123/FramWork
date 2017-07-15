package com.ehome.niuyunyang.framework.testdb;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NewYyoung on 2017/7/14.
 * version 2.8
 */

public class Series extends DataSupport{
    private String name;
    private List<News> newses=new ArrayList<>();

    public Series(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<News> getNewses() {
        return newses;
    }

    public void setNewses(List<News> newses) {
        this.newses = newses;
    }
}

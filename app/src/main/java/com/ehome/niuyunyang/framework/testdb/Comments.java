package com.ehome.niuyunyang.framework.testdb;

import org.litepal.crud.DataSupport;

/**
 * Created by NewYyoung on 2017/7/14.
 * version 2.8
 */

public class Comments extends DataSupport{
    private String name;
    private String content;
    private News news;

    public Comments(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}

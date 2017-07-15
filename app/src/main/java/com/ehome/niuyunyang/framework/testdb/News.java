package com.ehome.niuyunyang.framework.testdb;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NewYyoung on 2017/7/14.
 * version 2.8
 */

public class News extends DataSupport{
    public News(String title,String content) {
        this.title = title;
        this.content=content;
    }

    private String title;
    private String content;
    private Introduction introduction;
    private List<Comments> commentsList=new ArrayList<>();
   private List<Series> series=new ArrayList<>();

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public Introduction getIntroduction() {
        return introduction;
    }

    public void setIntroduction(Introduction introduction) {
        this.introduction = introduction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

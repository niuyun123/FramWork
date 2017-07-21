package com.ehome.niuyunyang.framework.testEventBus;

/**
 * Created by NewYyoung on 2017/7/18.
 * version 2.8
 */

public class MessageInfo {
    private String title;
    private String content;

    public MessageInfo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

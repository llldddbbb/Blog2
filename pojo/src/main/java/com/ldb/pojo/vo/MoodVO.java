package com.ldb.pojo.vo;

import java.util.Date;

/**
 * Created by ldb on 2017/4/19.
 */
public class MoodVO {
    private String title;
    private String content;

    private Date publishTime;

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

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}

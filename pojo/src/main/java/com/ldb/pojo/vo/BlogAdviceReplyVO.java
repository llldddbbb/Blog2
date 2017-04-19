package com.ldb.pojo.vo;

import java.util.Date;

/**
 * Created by ldb on 2017/4/19.
 */
public class BlogAdviceReplyVO {

    private String content;
    private Date publishTime;
    private Boolean role;

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

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }
}

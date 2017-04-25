package com.ldb.pojo.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BlogAdviceReplyPO {
    private Integer id;

    private String content;

    private String userIP;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date publishTime;

    private Integer blogAdviceId;

    private Boolean role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP == null ? null : userIP.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getBlogAdviceId() {
        return blogAdviceId;
    }

    public void setBlogAdviceId(Integer blogAdviceId) {
        this.blogAdviceId = blogAdviceId;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }
}
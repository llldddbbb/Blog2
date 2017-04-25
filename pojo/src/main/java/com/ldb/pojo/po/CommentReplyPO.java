package com.ldb.pojo.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CommentReplyPO {
    private Integer id;

    private String content;

    private String userIP;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date publishTime;

    private Integer commentId;

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
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    public CommentReplyPO() {
    }

    public CommentReplyPO(String content, Date publishTime, Integer commentId, Boolean role) {
        this.content = content;
        this.publishTime = publishTime;
        this.commentId = commentId;
        this.role = role;
    }
}
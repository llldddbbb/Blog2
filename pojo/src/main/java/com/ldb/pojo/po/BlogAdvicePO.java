package com.ldb.pojo.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ldb.pojo.vo.BlogAdviceReplyVO;

import java.util.Date;
import java.util.List;

public class BlogAdvicePO {
    private Integer id;

    private String nickName;

    private String userIP;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishTime;

    private List<BlogAdviceReplyVO> blogAdviceReplyVOList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
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

    public List<BlogAdviceReplyVO> getBlogAdviceReplyVOList() {
        return blogAdviceReplyVOList;
    }

    public void setBlogAdviceReplyVOList(List<BlogAdviceReplyVO> blogAdviceReplyVOList) {
        this.blogAdviceReplyVOList = blogAdviceReplyVOList;
    }
}
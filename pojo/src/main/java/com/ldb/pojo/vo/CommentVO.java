package com.ldb.pojo.vo;

import java.util.Date;

/**
 * Created by ldb on 2017/4/17.
 */
public class CommentVO {
    private String nickName;
    private Date publishTime;
    private String content;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}

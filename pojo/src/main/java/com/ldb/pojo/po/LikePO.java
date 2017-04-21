package com.ldb.pojo.po;

import java.util.Date;

public class LikePO {

    private Integer id;

    private String userIP;

    private Date clickTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    public Date getClickTime() {
        return clickTime;
    }

    public void setClickTime(Date clickTime) {
        this.clickTime = clickTime;
    }
}
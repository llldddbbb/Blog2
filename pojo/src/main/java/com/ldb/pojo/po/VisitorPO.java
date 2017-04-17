package com.ldb.pojo.po;

import java.util.Date;

/**
 * Created by ldb on 2017/4/17.
 */
public class VisitorPO {
    private Integer id;

    private String userIP;

    private String userBrowser;

    private String userOS;

    private Date readTime;

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

    public String getUserBrowser() {
        return userBrowser;
    }

    public void setUserBrowser(String userBrowser) {
        this.userBrowser = userBrowser;
    }

    public String getUserOS() {
        return userOS;
    }

    public void setUserOS(String userOS) {
        this.userOS = userOS;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public VisitorPO() {
    }

    public VisitorPO(String userIP, String userBrowser, String userOS) {
        this.userIP = userIP;
        this.userBrowser = userBrowser;
        this.userOS = userOS;
    }
}

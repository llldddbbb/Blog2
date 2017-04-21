package com.ldb.pojo.po;

import java.util.Date;

/**
 * Created by ldb on 2017/4/21.
 */
public class LoginHistoryPO {
    private Integer id;
    private String ip;
    private String ipName;
    private Date loginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpName() {
        return ipName;
    }

    public void setIpName(String ipName) {
        this.ipName = ipName;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}

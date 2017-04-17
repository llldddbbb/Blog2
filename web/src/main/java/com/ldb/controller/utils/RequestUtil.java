package com.ldb.controller.utils;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ldb on 2017/4/17.
 */
public class RequestUtil {

    public static String getUserIP(HttpServletRequest request){
        String ip = request.getHeader("X-Real-IP");
        if (ip!= null && !"".equals(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (ip!= null && !"".equals(ip)  && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }

    //获得浏览器信息
    public static String getUserBrowser(HttpServletRequest request){
        String agentStr = request.getHeader("user-agent");
        UserAgent agent = UserAgent.parseUserAgentString(agentStr);
        Browser browser = agent.getBrowser();
        return "{\"类型\":\""+browser.getBrowserType()+
                "\",\"名称\":\""+browser.getName()+
                "\",\"厂商\":\""+browser.getManufacturer()+
                "\",\"产品系列\":\""+browser.getGroup()+
                "\",\"引擎\":\""+browser.getRenderingEngine()+"\"}";
    }


    //得到用户的操作系统
    public static String getUserOS(HttpServletRequest request){
        String agentStr = request.getHeader("user-agent");
        UserAgent agent = UserAgent.parseUserAgentString(agentStr);
        OperatingSystem os = agent.getOperatingSystem();
        return "{\"名称\":\""+os.getName()+
                "\",\"设备类型\":\""+os.getDeviceType()+
                "\",\"产品系列\":\""+os.getGroup()+
                "\",\"生成厂商\":\""+os.getManufacturer()+"\"}";
    }



}

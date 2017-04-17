package com.ldb.controller;

import com.ldb.pojo.po.VisitorPO;
import com.ldb.service.LikeService;
import com.ldb.service.VisitorService;
import com.ldb.utils.ConfigStrUtil;
import com.ldb.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ldb on 2017/4/17.
 */
@Controller
public class IndexController {

    @Autowired
    private LikeService likeService;

    @Autowired
    private VisitorService visitorService;

    @RequestMapping(value = {"/","/index"})
    public ModelAndView goIndex(HttpServletRequest request){
        ModelAndView mav=new ModelAndView("foreground/index");
        mav.addObject("likeCount",likeService.getLikeCount());
        //获取游客浏览器、操作系统、IP信息
        String userBrowser=RequestUtil.getUserBrowser(request);
        String userOS=RequestUtil.getUserOS(request);
        String userIP=RequestUtil.getUserIP(request);
        VisitorPO visitorPO=new VisitorPO(userIP,userBrowser,userOS);
        visitorService.addVisitor(visitorPO);
        return mav;
    }

    @RequestMapping(value="/like",method = RequestMethod.POST)
    @ResponseBody
    public String clickLike(HttpServletRequest request){
        //获取用户真实IP
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        int resultNum=likeService.addLike(ip);
        if(resultNum>0){
            return ConfigStrUtil.SUCCESS;
        }else{
            return ConfigStrUtil.ERROR;
        }

    }
}

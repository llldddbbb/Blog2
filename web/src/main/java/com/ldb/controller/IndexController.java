package com.ldb.controller;

import com.ldb.service.LikeService;
import com.ldb.utils.ConfigStrUtil;
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

    @RequestMapping(value = {"/","/index"})
    public ModelAndView goIndex(){
        ModelAndView mav=new ModelAndView("foreground/index");
        mav.addObject("likeCount",likeService.getLikeCount());
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

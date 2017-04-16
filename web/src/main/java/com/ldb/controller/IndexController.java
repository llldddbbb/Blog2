package com.ldb.controller;

import com.ldb.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}

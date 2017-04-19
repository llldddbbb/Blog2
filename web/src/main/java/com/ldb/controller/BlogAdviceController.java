package com.ldb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ldb on 2017/4/19.
 */
@Controller
public class BlogAdviceController {

    @RequestMapping("/blogAdvice")
    public ModelAndView blogAdvice(){
        ModelAndView mav=new ModelAndView("/foreground/blogAdvice");
        return mav;
    }

}

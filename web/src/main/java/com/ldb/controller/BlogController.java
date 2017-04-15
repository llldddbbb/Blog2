package com.ldb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ldb on 2017/4/15.
 */
@Controller
public class BlogController {

    @RequestMapping("/")
    public String goIndex(){
        return "foreground/index";
    }
}

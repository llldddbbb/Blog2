package com.ldb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ldb on 2017/4/17.
 */
@Controller
public class SinglePageController {

    @RequestMapping("/singlePage")
    public String singlePage(){
       return "/foreground/singlePage";
    }
}

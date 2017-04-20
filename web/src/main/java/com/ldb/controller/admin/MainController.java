package com.ldb.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ldb on 2017/4/20.
 */
@Controller
@RequestMapping("/admin")
public class MainController {

    @RequestMapping("/main")
    public String goMain(){
        return "background/main";
    }
}

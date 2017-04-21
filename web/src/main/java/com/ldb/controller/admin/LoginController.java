package com.ldb.controller.admin;

import com.ldb.pojo.po.AdminPO;
import com.ldb.pojo.po.LoginHistoryPO;
import com.ldb.service.AdminService;
import com.ldb.utils.ConfigStrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by ldb on 2017/4/20.
 */
@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;



    @RequestMapping(value="/background",method = RequestMethod.GET)
    public String goBackground(){
       return "background/index";
    }

    @RequestMapping(value ="/login",method = RequestMethod.GET)
    @ResponseBody
    public String checkLogin(AdminPO adminPO, LoginHistoryPO loginHistoryPO, HttpSession session){
        AdminPO currentAdmin = adminService.checkLogin(adminPO);
        if(currentAdmin==null){
            return ConfigStrUtil.ERROR;
        }else{

            //存储登录信息
            int result=adminService.addLoginHistory(loginHistoryPO);
            if(result>0){
                session.setAttribute("currentAdmin",currentAdmin);
                return ConfigStrUtil.SUCCESS;
            }else{
                return ConfigStrUtil.ERROR;
            }
        }

    }

}

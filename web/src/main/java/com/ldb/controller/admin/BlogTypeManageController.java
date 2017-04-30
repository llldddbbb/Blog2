package com.ldb.controller.admin;

import com.ldb.pojo.po.BlogTypePO;
import com.ldb.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ldb on 2017/4/30.
 */
@Controller
@RequestMapping("/admin")
public class BlogTypeManageController {

    @Autowired
    private BlogTypeService blogTypeService;

    @RequestMapping("/blogTypeManage")
    public ModelAndView blogTypeManage(){
        ModelAndView mav=new ModelAndView("background/blogTypeManage");
        return mav;
    }

    @RequestMapping(value="/blogTypeManage/list",method = RequestMethod.GET)
    @ResponseBody
    public List<BlogTypePO> blogTypeManagePage(){
        List<BlogTypePO> blogTypeList = blogTypeService.listBlogType();
        return blogTypeList;
    }
}

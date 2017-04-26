package com.ldb.controller.admin;

import com.ldb.pojo.bo.PageBeanBO;
import com.ldb.pojo.po.BlogAdvicePO;
import com.ldb.service.BlogAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/26.
 */
@Controller
@RequestMapping("/admin")
public class BlogAdviceManageController {

    @Autowired
    private BlogAdviceService blogAdviceService;

    @RequestMapping("/blogAdviceManage")
    public String blogAdviceManage( HttpSession session){
        Long blogAdviceNum = blogAdviceService.getBlogAdviceCount();
        session.setAttribute("blogAdviceNum",blogAdviceNum);
        return "/background/blogAdviceManage";
    }

    @RequestMapping("blogAdviceManage/list/{page}")
    @ResponseBody
    public List<BlogAdvicePO> blogAdviceManagePage(@PathVariable String page, String pageSize){
        //获取评论列表
        PageBeanBO pageBeanBO=new PageBeanBO(Integer.parseInt(page), Integer.parseInt(pageSize));
        HashMap<String,Integer> param=new HashMap<>();
        param.put("start",pageBeanBO.getStart());
        param.put("pageSize",pageBeanBO.getPageSize());

        List<BlogAdvicePO> blogAdviceList = blogAdviceService.listBlogAdvice(pageBeanBO);

        return blogAdviceList;
    }

}

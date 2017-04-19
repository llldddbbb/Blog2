package com.ldb.controller;

import com.ldb.controller.utils.PageUtil;
import com.ldb.controller.utils.RequestUtil;
import com.ldb.pojo.bo.PageBeanBO;
import com.ldb.pojo.po.BlogAdvicePO;
import com.ldb.service.BlogAdviceService;
import com.ldb.utils.ConfigStrUtil;
import com.ldb.utils.JacksonUtil;
import com.ldb.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by ldb on 2017/4/19.
 */
@Controller
public class BlogAdviceController {

    @Autowired
    private BlogAdviceService blogAdviceService;

   @RequestMapping(value="/blogAdvice",method = RequestMethod.GET)
    public ModelAndView blogAdvice(){
        ModelAndView mav=new ModelAndView("/foreground/blogAdvice");
        PageBeanBO pageBeanBO=new PageBeanBO(1, ConfigStrUtil.pageSize);
        List<BlogAdvicePO> blogAdviceList = blogAdviceService.listBlogAdvice(pageBeanBO);
        //获取分页代码
        Long count=blogAdviceService.getBlogAdviceCount();
        String pageNation = PageUtil.genPageNation(count, pageBeanBO.getPage(), pageBeanBO.getPageSize());
        mav.addObject("blogAdviceList",blogAdviceList);
        mav.addObject("pageNation",pageNation);
        return mav;
    }

    @RequestMapping(value = {"/blogAdvice/{page}","/blogAdvice/list/{page}"},method = RequestMethod.GET)
    public ModelAndView blogAdvice(@PathVariable String page){
        ModelAndView mav=new ModelAndView("/foreground/blogAdvice");
        if(StringUtil.isEmpty(page)){
            page="1";
        }
        PageBeanBO pageBeanBO=new PageBeanBO(Integer.parseInt(page), ConfigStrUtil.pageSize);
        List<BlogAdvicePO> blogAdviceList = blogAdviceService.listBlogAdvice(pageBeanBO);
        //获取分页代码
        Long count=blogAdviceService.getBlogAdviceCount();
        String pageNation = PageUtil.genPageNation(count, pageBeanBO.getPage(), pageBeanBO.getPageSize());
        mav.addObject("blogAdviceList",blogAdviceList);
        mav.addObject("pageNation",pageNation);
        return mav;
    }

    @RequestMapping(value = "/blogAdvice",method = RequestMethod.POST)
    @ResponseBody
    public String addBlogAdvice(BlogAdvicePO blogAdvicePO, HttpServletRequest request){
        //设置userIP
        String userIP= RequestUtil.getUserIP(request);
        blogAdvicePO.setUserIP(userIP);
        //设置publishTime
        blogAdvicePO.setPublishTime(new Date());
        int result = blogAdviceService.addBlogAdvice(blogAdvicePO);
        if(result>0){
            return JacksonUtil.toJSon(blogAdvicePO);
        }else{
            return ConfigStrUtil.ERROR;
        }
    }



}

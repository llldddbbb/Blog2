package com.ldb.controller;

import com.ldb.controller.utils.PageUtil;
import com.ldb.controller.utils.RequestUtil;
import com.ldb.pojo.bo.PageBeanBO;
import com.ldb.pojo.po.BlogAdvicePO;
import com.ldb.pojo.po.BlogAdviceReplyPO;
import com.ldb.service.BlogAdviceReplyService;
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

    @Autowired
    private BlogAdviceReplyService blogAdviceReplyService;

   @RequestMapping(value="/blogAdvice",method = RequestMethod.GET)
    public ModelAndView blogAdvice(){
        ModelAndView mav=new ModelAndView("foreground/blogAdvice");
        PageBeanBO pageBeanBO=new PageBeanBO(1, ConfigStrUtil.BLOGADVICEPAGESIZE);
        List<BlogAdvicePO> blogAdviceList = blogAdviceService.listBlogAdvice(pageBeanBO);
        //获取分页代码
        Long count=blogAdviceService.getBlogAdviceCount();
        String targetUrl="/blogAdvice/list";
        String pageNation = PageUtil.getPageNation(count,targetUrl, pageBeanBO.getPage(), pageBeanBO.getPageSize());
        mav.addObject("blogAdviceList",blogAdviceList);
        mav.addObject("pageNation",pageNation);
        return mav;
    }

    @RequestMapping(value = "/blogAdvice/list/{page}",method = RequestMethod.GET)
    public ModelAndView blogAdvice(@PathVariable String page){
        ModelAndView mav=new ModelAndView("foreground/blogAdvice");
        if(StringUtil.isEmpty(page)){
            page="1";
        }
        PageBeanBO pageBeanBO=new PageBeanBO(Integer.parseInt(page), ConfigStrUtil.BLOGADVICEPAGESIZE);
        List<BlogAdvicePO> blogAdviceList = blogAdviceService.listBlogAdvice(pageBeanBO);
        //获取分页代码
        Long count=blogAdviceService.getBlogAdviceCount();
        String targetUrl="/blogAdvice/list";
        String pageNation = PageUtil.getPageNation(count,targetUrl, pageBeanBO.getPage(), pageBeanBO.getPageSize());
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

    @RequestMapping(value = "/blogAdvice/reply",method = RequestMethod.POST)
    @ResponseBody
    public String addBlogAdviceReply(BlogAdviceReplyPO blogAdviceReplyPO, HttpServletRequest request){
        String userIP=RequestUtil.getUserIP(request);
        blogAdviceReplyPO.setUserIP(userIP);
        blogAdviceReplyPO.setPublishTime(new Date());
        blogAdviceReplyPO.setRole(false);
        int result = blogAdviceReplyService.addBlogAdviceReply(blogAdviceReplyPO);
        if(result>0){
            return JacksonUtil.toJSon(blogAdviceReplyPO);
        }else{
            return ConfigStrUtil.ERROR;
        }
    }



}

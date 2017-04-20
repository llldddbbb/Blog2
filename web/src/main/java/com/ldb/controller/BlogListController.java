package com.ldb.controller;

import com.ldb.controller.utils.PageUtil;
import com.ldb.pojo.bo.PageBeanBO;
import com.ldb.pojo.vo.BlogVO;
import com.ldb.service.BlogService;
import com.ldb.utils.ConfigStrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/20.
 */
@Controller
public class BlogListController {

    @Autowired
    private BlogService blogService;


    @RequestMapping(value="/blog/category/{blogTypeId}",method = RequestMethod.GET)
    public ModelAndView blogType(@PathVariable String blogTypeId){
        ModelAndView mav=new ModelAndView("foreground/blogList");
        HashMap<String,Integer> param=new HashMap<>();
        //拼装分页参数
        PageBeanBO pageBean=new PageBeanBO(1, ConfigStrUtil.BLOGLISTPAGESIZE);
        param.put("start",pageBean.getStart());
        param.put("pageSize",pageBean.getPageSize());
        //拼装筛选参数
        param.put("blogTypeId",Integer.parseInt(blogTypeId));
        List<BlogVO> blogList = blogService.listBlog(param);

        //获取总记录数
        Long count=blogService.getBlogCount(param);
        //拼装分页代码
        String targetUrl="/blog/category/"+blogTypeId+"/list";
        String pageNation= PageUtil.getPageNation(count,targetUrl,pageBean.getPage(),pageBean.getPageSize());

        mav.addObject("blogList",blogList);
        mav.addObject("pageNation",pageNation);
        return mav;
    }

    @RequestMapping(value="/blog/tag/{blogTagId}",method = RequestMethod.GET)
    public ModelAndView blogTag(@PathVariable String blogTagId){
        ModelAndView mav=new ModelAndView("foreground/blogList");
        HashMap<String,Integer> param=new HashMap<>();
        //拼装分页参数
        PageBeanBO pageBean=new PageBeanBO(1, ConfigStrUtil.BLOGLISTPAGESIZE);
        param.put("start",pageBean.getStart());
        param.put("pageSize",pageBean.getPageSize());
        //拼装筛选参数
        param.put("blogTagId",Integer.parseInt(blogTagId));
        List<BlogVO> blogList = blogService.listBlog(param);

        //获取总记录数
        Long count=blogService.getBlogCount(param);
        //拼装分页代码
        String targetUrl="/blog/tag/"+blogTagId+"/list";
        String pageNation= PageUtil.getPageNation(count,targetUrl,pageBean.getPage(),pageBean.getPageSize());

        mav.addObject("blogList",blogList);
        mav.addObject("pageNation",pageNation);
        return mav;
    }

    @RequestMapping(value="/blog/category/{blogTypeId}/list/{page}",method = RequestMethod.GET)
    public ModelAndView blogTypeList(@PathVariable String blogTypeId,@PathVariable String page){
        ModelAndView mav=new ModelAndView("foreground/blogList");
        HashMap<String,Integer> param=new HashMap<>();
        //拼装分页参数
        PageBeanBO pageBean=new PageBeanBO(Integer.parseInt(page), ConfigStrUtil.BLOGLISTPAGESIZE);
        param.put("start",pageBean.getStart());
        param.put("pageSize",pageBean.getPageSize());
        //拼装筛选参数
        param.put("blogTypeId",Integer.parseInt(blogTypeId));
        List<BlogVO> blogList = blogService.listBlog(param);

        //获取总记录数
        Long count=blogService.getBlogCount(param);
        //拼装分页代码
        String targetUrl="/blog/tag/"+blogTypeId+"/list";
        String pageNation= PageUtil.getPageNation(count,targetUrl,pageBean.getPage(),pageBean.getPageSize());

        mav.addObject("blogList",blogList);
        mav.addObject("pageNation",pageNation);
        return mav;
    }

    @RequestMapping(value="/blog/tag/{blogTagId}/list/{page}",method = RequestMethod.GET)
    public ModelAndView blogTagList(@PathVariable String blogTagId,@PathVariable String page){
        ModelAndView mav=new ModelAndView("foreground/blogList");
        HashMap<String,Integer> param=new HashMap<>();
        //拼装分页参数
        PageBeanBO pageBean=new PageBeanBO(Integer.parseInt(page), ConfigStrUtil.BLOGLISTPAGESIZE);
        param.put("start",pageBean.getStart());
        param.put("pageSize",pageBean.getPageSize());
        //拼装筛选参数
        param.put("blogTagId",Integer.parseInt(blogTagId));
        List<BlogVO> blogList = blogService.listBlog(param);

        //获取总记录数
        Long count=blogService.getBlogCount(param);
        //拼装分页代码
        String targetUrl="/blog/tag/"+blogTagId+"/list";
        String pageNation= PageUtil.getPageNation(count,targetUrl,pageBean.getPage(),pageBean.getPageSize());

        mav.addObject("blogList",blogList);
        mav.addObject("pageNation",pageNation);
        return mav;
    }

}

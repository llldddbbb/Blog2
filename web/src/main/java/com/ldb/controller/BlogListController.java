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
    public String blogType(@PathVariable String blogTypeId){
        return "redirect:/blog/category/"+blogTypeId+"/list/1";
    }

    @RequestMapping(value="/blog/tag/{blogTagId}",method = RequestMethod.GET)
    public String blogTag(@PathVariable String blogTagId){
        return "redirect:/blog/tag/"+blogTagId+"/list/1";
    }

    @RequestMapping(value="/blog/dateArchive/{dateArchive}",method = RequestMethod.GET)
    public String dateArchive(@PathVariable String dateArchive){
        return "redirect:/blog/dateArchive/"+dateArchive+"/list/1";
    }

    @RequestMapping(value="/blog/list",method = RequestMethod.GET)
    public String blogList(){
        return "redirect:/blog/list/1";
    }

    @RequestMapping(value="/blog/category/{blogTypeId}/list/{page}",method = RequestMethod.GET)
    public ModelAndView blogTypeList(@PathVariable String blogTypeId,@PathVariable String page){
        ModelAndView mav=new ModelAndView("foreground/blogList");
        HashMap<String,Object> param=new HashMap<>();
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
        String targetUrl="/blog/category/"+blogTypeId+"/list";
        String pageNation= PageUtil.getPageNation(count,targetUrl,pageBean.getPage(),pageBean.getPageSize());

        mav.addObject("blogList",blogList);
        mav.addObject("pageNation",pageNation);
        return mav;
    }

    @RequestMapping(value="/blog/tag/{blogTagId}/list/{page}",method = RequestMethod.GET)
    public ModelAndView blogTagList(@PathVariable String blogTagId,@PathVariable String page){
        ModelAndView mav=new ModelAndView("foreground/blogList");
        HashMap<String,Object> param=new HashMap<>();
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

    @RequestMapping(value="/blog/dateArchive/{dateArchive}/list/{page}",method = RequestMethod.GET)
    public ModelAndView dateArchiveList(@PathVariable String dateArchive,@PathVariable String page){
        ModelAndView mav=new ModelAndView("foreground/blogList");
        HashMap<String,Object> param=new HashMap<>();
        //拼装分页参数
        PageBeanBO pageBean=new PageBeanBO(Integer.parseInt(page), ConfigStrUtil.BLOGLISTPAGESIZE);
        param.put("start",pageBean.getStart());
        param.put("pageSize",pageBean.getPageSize());
        //拼装筛选参数
        param.put("dateArchive",dateArchive+"%");
        List<BlogVO> blogList = blogService.listBlog(param);

        //获取总记录数
        Long count=blogService.getBlogCount(param);
        //拼装分页代码
        String targetUrl="/blog/dateArchive/"+dateArchive+"/list";
        String pageNation= PageUtil.getPageNation(count,targetUrl,pageBean.getPage(),pageBean.getPageSize());

        mav.addObject("blogList",blogList);
        mav.addObject("pageNation",pageNation);
        return mav;
    }


    @RequestMapping(value="/blog/list/{page}",method = RequestMethod.GET)
    public ModelAndView blogList(@PathVariable String page){
        ModelAndView mav=new ModelAndView("foreground/blogList");
        HashMap<String,Object> param=new HashMap<>();
        //拼装分页参数
        PageBeanBO pageBean=new PageBeanBO(Integer.parseInt(page), ConfigStrUtil.BLOGLISTPAGESIZE);
        param.put("start",pageBean.getStart());
        param.put("pageSize",pageBean.getPageSize());
        //拼装筛选参数
        List<BlogVO> blogList = blogService.listBlog(param);

        //获取总记录数
        Long count=blogService.getBlogCount(param);
        //拼装分页代码
        String targetUrl="/blog/list/";
        String pageNation= PageUtil.getPageNation(count,targetUrl,pageBean.getPage(),pageBean.getPageSize());

        mav.addObject("blogList",blogList);
        mav.addObject("pageNation",pageNation);
        return mav;
    }

}

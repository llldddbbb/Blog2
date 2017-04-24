package com.ldb.controller.admin;

import com.ldb.pojo.bo.PageBeanBO;
import com.ldb.pojo.po.BlogPO;
import com.ldb.pojo.po.BlogTagPO;
import com.ldb.pojo.po.BlogTypePO;
import com.ldb.service.BlogService;
import com.ldb.service.BlogTagService;
import com.ldb.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/21.
 */
@Controller
@RequestMapping("/admin")
public class BlogManageController {

    @Autowired
    private BlogTagService blogTagService;

    @Autowired
    private BlogTypeService blogTypeService;

    @Autowired
    private BlogService blogService;

    @RequestMapping("/blogManage")
    public ModelAndView blogManage(){
        ModelAndView mav=new ModelAndView("/background/blogManage");
        //获取下拉框
        List<BlogTagPO> blogTagList = blogTagService.listBlogTag();
        List<BlogTypePO> blogTypeList = blogTypeService.listBlogType();


        mav.addObject("blogTagList",blogTagList);
        mav.addObject("blogTypeList",blogTypeList);
        return mav;
    }

    @RequestMapping(value="/blogManage/list/{page}",method = RequestMethod.GET)
    @ResponseBody
    public List<BlogPO> blogManagePage(@PathVariable String page, String pageSize, HttpSession session){
        //获取博文列表
        PageBeanBO pageBeanBO=new PageBeanBO(Integer.parseInt(page), Integer.parseInt(pageSize));
        HashMap<String,Integer> param=new HashMap<>();
        param.put("start",pageBeanBO.getStart());
        param.put("pageSize",pageBeanBO.getPageSize());

        Long blogCount = blogService.getBlogCount(new HashMap<>());

        //获取总页数
        long totalPage=blogCount%pageBeanBO.getPageSize()==0?blogCount/pageBeanBO.getPageSize():blogCount/pageBeanBO.getPageSize()+1;
        session.setAttribute("totalPage",totalPage);

        List<BlogPO> blogList=blogService.listBlogPO(param);
        return blogList;
    }

    @RequestMapping("/writeBlog")
    public ModelAndView writeBlog(){
        ModelAndView mav=new ModelAndView("/background/writeBlog");
        //获取下拉框
        List<BlogTagPO> blogTagList = blogTagService.listBlogTag();
        List<BlogTypePO> blogTypeList = blogTypeService.listBlogType();


        mav.addObject("blogTagList",blogTagList);
        mav.addObject("blogTypeList",blogTypeList);
        return mav;
    }

    @RequestMapping("/addBlog")
    public String addBlog(BlogPO blogPO){
        int result = blogService.addBlog(blogPO);
        if(result>0){
            return "redirect:/admin/blogManage";
        }else{
            return null;
        }
    }



}

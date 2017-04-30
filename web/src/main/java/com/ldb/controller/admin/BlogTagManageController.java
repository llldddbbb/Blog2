package com.ldb.controller.admin;

import com.ldb.pojo.bo.PageBeanBO;
import com.ldb.pojo.po.BlogTagPO;
import com.ldb.service.BlogTagService;
import com.ldb.utils.ConfigStrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/30.
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes(value = {"blogTagNum"})
public class BlogTagManageController {

    @Autowired
    private BlogTagService blogTagService;

    @RequestMapping("/blogTagManage")
    public ModelAndView blogTagManage(){
        ModelAndView mav=new ModelAndView("background/blogTagManage");
        Long blogTagNum=blogTagService.getBlogTagCount();
        mav.addObject("blogTagNum",blogTagNum);
        return mav;
    }

    @RequestMapping(value="/blogTagManage/list/{page}",method = RequestMethod.GET)
    @ResponseBody
    public List<BlogTagPO> blogTagManagePage(@PathVariable String page, String pageSize){
        PageBeanBO pageBeanBO=new PageBeanBO(Integer.parseInt(page), Integer.parseInt(pageSize));
        HashMap<String,Integer> param=new HashMap<>();
        param.put("start",pageBeanBO.getStart());
        param.put("pageSize",pageBeanBO.getPageSize());

        List<BlogTagPO> blogTagList = blogTagService.listBlogTag(param);

        return blogTagList;
    }

    @RequestMapping(value = "blogTag",method = RequestMethod.PUT)
    public String updateBlogTag(BlogTagPO blogTagPO){
        int result=blogTagService.updateBlogTag(blogTagPO);
        if(result>0){
            return "redirect:/admin/blogTagManage";
        }else{
            return null;
        }
    }

    @RequestMapping(value = "blogTag/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteBlogTag(@PathVariable Integer id){
        int result=blogTagService.deleteBlogTag(id);
        if(result>0){
            return ConfigStrUtil.SUCCESS;
        }else{
            return  ConfigStrUtil.ERROR;
        }
    }

    @RequestMapping(value = "blogTag",method = RequestMethod.POST)
    public String addBlogTag(BlogTagPO blogTagPO){
        int result=blogTagService.addBlogTag(blogTagPO);
        if(result>0){
            return "redirect:/admin/blogTagManage";
        }else{
            return null;
        }
    }

}

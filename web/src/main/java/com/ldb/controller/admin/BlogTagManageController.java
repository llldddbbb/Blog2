package com.ldb.controller.admin;

import com.ldb.pojo.po.BlogTagPO;
import com.ldb.service.BlogTagService;
import com.ldb.utils.ConfigStrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
public class BlogTagManageController {

    @Autowired
    private BlogTagService blogTagService;

    @RequestMapping("/blogTagManage")
    public ModelAndView blogTagManage(){
        ModelAndView mav=new ModelAndView("background/blogTagManage");
        return mav;
    }

    @RequestMapping(value="/blogTagManage/list",method = RequestMethod.GET)
    @ResponseBody
    public List<BlogTagPO> blogTagManagePage(){
        List<BlogTagPO> blogTagList = blogTagService.listBlogTag();
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

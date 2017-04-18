package com.ldb.controller;

import com.ldb.pojo.po.BlogPO;
import com.ldb.pojo.po.CommentPO;
import com.ldb.service.BlogService;
import com.ldb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ldb on 2017/4/17.
 */
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/blog/{id}",method = RequestMethod.GET)
    public ModelAndView singlePage(@PathVariable Integer id){
        ModelAndView mav=new ModelAndView("foreground/blog");
        //获取Blog
        BlogPO blog=blogService.getBlog(id);
        if(blog==null){
            mav.setViewName("redirect:/errorPage/404.html");
            return mav;

        }
        //获取该Blog下的评论
        List<CommentPO> commentList = commentService.listComment(blog.getId());
        mav.addObject("commentList",commentList);
        //更新阅读数量
        blogService.updateBlogReadNum(id);
        mav.addObject("blog",blog);


        return mav;
    }
}

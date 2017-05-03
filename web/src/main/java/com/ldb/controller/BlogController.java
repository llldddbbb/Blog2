package com.ldb.controller;

import com.ldb.controller.utils.RequestUtil;
import com.ldb.pojo.po.BlogPO;
import com.ldb.pojo.po.CommentPO;
import com.ldb.pojo.po.CommentReplyPO;
import com.ldb.service.BlogService;
import com.ldb.service.CommentReplyService;
import com.ldb.service.CommentService;
import com.ldb.utils.ConfigStrUtil;
import com.ldb.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
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

    @Autowired
    private CommentReplyService commentReplyService;

    @RequestMapping(value = "/blog/{id}",method = RequestMethod.GET)
    public ModelAndView blogPage(@PathVariable Integer id){
        ModelAndView mav=new ModelAndView("foreground/blog");
        //获取Blog
        BlogPO blog=blogService.getBlog(id);
        if(blog==null){
            mav.setViewName("redirect:/errorPage/404.html");
            return mav;

        }
        //获取该Blog下的评论
        HashMap<String,Integer> param=new HashMap<>();
        param.put("blogId",blog.getId());
        List<CommentPO> commentList = commentService.listComment(param);
        mav.addObject("commentList",commentList);
        //更新阅读数量
        blogService.updateBlogReadNum(id);
        mav.addObject("blog",blog);

        return mav;
    }

    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    @ResponseBody
    public String addComment(CommentPO commentPO, HttpServletRequest request){
        //获取留言IP
        String userIP= RequestUtil.getUserIP(request);
        commentPO.setUserIP(userIP);
        //设置时间
        commentPO.setPublishTime(new Date());
        int result=commentService.addComment(commentPO);
        if(result>0){
            return JacksonUtil.toJSon(commentPO);
        }else{
            return ConfigStrUtil.ERROR;
        }
    }

    @RequestMapping(value = "/comment/reply",method = RequestMethod.POST)
    @ResponseBody
    public String addCommentReply(CommentReplyPO commentReplyPO,HttpServletRequest request){
        //获取留言IP
        String userIP= RequestUtil.getUserIP(request);
        commentReplyPO.setUserIP(userIP);
        //设置时间
        commentReplyPO.setPublishTime(new Date());
        //设置角色
        commentReplyPO.setRole(false);
        int result = commentReplyService.addCommentReply(commentReplyPO);
        if(result>0){
            return JacksonUtil.toJSon(commentReplyPO);
        }else{
            return ConfigStrUtil.ERROR;
        }
    }





}

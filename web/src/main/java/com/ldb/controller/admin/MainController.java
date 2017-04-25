package com.ldb.controller.admin;

import com.ldb.pojo.po.LoginHistoryPO;
import com.ldb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * Created by ldb on 2017/4/20.
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes(value = {"blogNum","commentNum"})
public class MainController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private VisitorService visitorService;

    @Autowired
    private LikeService likeService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogAdviceService blogAdviceService;

    @Autowired
    private BlogService blogService;

    @RequestMapping("/main")
    public ModelAndView goMain(){
        ModelAndView mav=new ModelAndView("background/main");
        //获取上一条登录信息
        LoginHistoryPO loginHistory = adminService.getLoginHistory();
        //获取今日访客数量
        Long todayReadNum=visitorService.getTodayReadNum();
        //获取今日点赞量
        Long todayLike=likeService.getTodayLike();
        //访问总数
        Long readNum=visitorService.getReadNum();
        //点赞总数
        Long likeNum=likeService.getLikeCount();
        //获取评论总数
        Long commentNum=commentService.getCommentCount();
        //获取未回复留言总数
        Long notReplyNum=blogAdviceService.getNotReplyCount();
        //获取文章总数
        Long blogNum=blogService.getBlogCount(new HashMap<>());

        mav.addObject("loginHistory",loginHistory);
        mav.addObject("todayReadNum",todayReadNum);
        mav.addObject("todayLike",todayLike);
        mav.addObject("readNum",readNum);
        mav.addObject("likeNum",likeNum);
        mav.addObject("commentNum",commentNum);
        mav.addObject("notReplyNum",notReplyNum);
        mav.addObject("blogNum",blogNum);
        return mav;
    }
}

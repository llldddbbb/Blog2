package com.ldb.controller;

import com.ldb.pojo.po.VisitorPO;
import com.ldb.pojo.vo.BlogVO;
import com.ldb.service.BlogService;
import com.ldb.service.LikeService;
import com.ldb.service.VisitorService;
import com.ldb.controller.utils.ConfigStrUtil;
import com.ldb.controller.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ldb on 2017/4/17.
 */
@Controller
@SessionAttributes(value = {"readNum","hotBlogList"})
public class IndexController {

    @Autowired
    private LikeService likeService;

    @Autowired
    private VisitorService visitorService;

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = {"/","/index"})
    public ModelAndView goIndex(HttpServletRequest request){
        ModelAndView mav=new ModelAndView("foreground/index");
        mav.addObject("likeCount",likeService.getLikeCount());
        //获取游客浏览器、操作系统、IP信息
        String userBrowser=RequestUtil.getUserBrowser(request);
        String userOS=RequestUtil.getUserOS(request);
        String userIP=RequestUtil.getUserIP(request);
        VisitorPO visitorPO=new VisitorPO(userIP,userBrowser,userOS);
        visitorService.addVisitor(visitorPO);

        //获取游客浏览数量
        Long readNum=visitorService.getReadNum();
        mav.addObject("readNum",readNum);

        //获取最新5篇博文
        List<BlogVO> newBlogList = blogService.listNewBlog();
        mav.addObject("newBlogList",newBlogList);

        //获取热门5篇博文
        List<BlogVO> hotBlogList = blogService.listHotBlog();
        mav.addObject("hotBlogList",hotBlogList);
        return mav;
    }

    @RequestMapping(value="/like",method = RequestMethod.POST)
    @ResponseBody
    public String clickLike(HttpServletRequest request){
        String ip=RequestUtil.getUserIP(request);
        int resultNum=likeService.addLike(ip);
        if(resultNum>0){
            return ConfigStrUtil.SUCCESS;
        }else{
            return ConfigStrUtil.ERROR;
        }

    }
}

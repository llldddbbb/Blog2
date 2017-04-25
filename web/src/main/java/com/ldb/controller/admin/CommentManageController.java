package com.ldb.controller.admin;

import com.ldb.pojo.bo.PageBeanBO;
import com.ldb.pojo.po.CommentPO;
import com.ldb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/25.
 */
@Controller
@RequestMapping("/admin")
public class CommentManageController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/commentManage")
    public ModelAndView commentManage(){
        ModelAndView mav=new ModelAndView("/background/commentManage");
        return mav;
    }

    @RequestMapping(value="/commentManage/list/{page}",method = RequestMethod.GET)
    public ModelAndView commentManagePage(@PathVariable String page,String pageSize){
        ModelAndView mav=new ModelAndView("/background/commentManage");
        //获取博文列表
        PageBeanBO pageBeanBO=new PageBeanBO(Integer.parseInt(page), Integer.parseInt(pageSize));
        HashMap<String,Integer> param=new HashMap<>();
        param.put("start",pageBeanBO.getStart());
        param.put("pageSize",pageBeanBO.getPageSize());

        List<CommentPO> commentList = commentService.listComment(null);
        mav.addObject("commentList",commentList);
        return mav;
    }
}

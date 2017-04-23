package com.ldb.controller.admin;

import com.ldb.pojo.po.BlogTagPO;
import com.ldb.pojo.po.BlogTypePO;
import com.ldb.pojo.vo.BlogVO;
import com.ldb.service.BlogService;
import com.ldb.service.BlogTagService;
import com.ldb.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView dataList(){
        ModelAndView mav=new ModelAndView("/background/blogManage");
        List<BlogTagPO> blogTagList = blogTagService.listBlogTag();
        List<BlogTypePO> blogTypeList = blogTypeService.listBlogType();
        List<BlogVO> blogList=blogService.listBlog(new HashMap<>());
        mav.addObject("blogTagList",blogTagList);
        mav.addObject("blogTypeList",blogTypeList);
        mav.addObject("blogList",blogList);
        return mav;
    }
}

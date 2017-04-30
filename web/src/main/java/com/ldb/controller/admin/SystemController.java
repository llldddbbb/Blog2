package com.ldb.controller.admin;

import com.ldb.pojo.po.*;
import com.ldb.pojo.vo.BlogDateArchiveVO;
import com.ldb.pojo.vo.BlogVO;
import com.ldb.service.*;
import com.ldb.utils.ConfigStrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/5/1.
 */
@Controller
@RequestMapping("/admin")
public class SystemController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogTypeService blogTypeService;

    @Autowired
    private BlogTagService blogTagService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private MottoService mottoService;

    @Autowired
    private SignatureService signatureService;

    @RequestMapping(value = "adminManage")
    public String adminManage(){
        return "background/adminManage";
    }

    @RequestMapping(value = "admin",method = RequestMethod.PUT)
    public String updateAdmin(AdminPO adminPO){
        int result=adminService.updateAdmin(adminPO);
        if(result>0){
            return "redirect:/background";
        }else{
            return null;
        }
    }

    @RequestMapping("refreshSystem")
    @ResponseBody
    public String refreshSystem(HttpServletRequest request){
        ServletContext application=request.getServletContext();

        //调用service方法，取得数据
        List<LinkPO> linkList=linkService.listLink(new HashMap<>());
        List<BlogTypePO> blogTypeList=blogTypeService.listBlogType();
        List<BlogTagPO> blogTagList=blogTagService.listBlogTag(new HashMap<>());
        List<BlogDateArchiveVO> blogDateArchiveList=blogService.listBlogDateArchive();
        MottoPO motto=mottoService.getMotto();
        SignaturePO signature = signatureService.getSignature();
        BlogVO recommendBlog=blogService.getRecommendBlog();

        //将数据塞进application
        application.setAttribute("linkList",linkList);//友情链接;
        application.setAttribute("blogTypeList",blogTypeList);//博客类别;
        application.setAttribute("blogTagList",blogTagList);//博客列表;
        application.setAttribute("blogDateArchiveList",blogDateArchiveList);//博客日期归档;
        application.setAttribute("motto",motto);//博客座右铭;
        application.setAttribute("signature",signature);//博客签名;
        application.setAttribute("recommendBlog",recommendBlog);//推荐博客;

        return ConfigStrUtil.SUCCESS;
    }
}

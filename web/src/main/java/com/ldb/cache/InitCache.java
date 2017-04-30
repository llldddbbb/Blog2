package com.ldb.cache;

import com.ldb.pojo.po.BlogTagPO;
import com.ldb.pojo.po.BlogTypePO;
import com.ldb.pojo.po.LinkPO;
import com.ldb.pojo.vo.BlogDateArchiveVO;
import com.ldb.pojo.vo.BlogVO;
import com.ldb.pojo.po.MottoPO;
import com.ldb.pojo.po.SignaturePO;
import com.ldb.service.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.List;

/**
 * 项目启动时就加载此类，将不常变的数据存进application，相当于缓存
 */
@Component
public class InitCache implements ServletContextListener,ApplicationContextAware{

    private static ApplicationContext applicationContext;


    @SuppressWarnings("static-access")
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application=servletContextEvent.getServletContext();

        //获取service实例
        LinkService linkService=(LinkService)applicationContext.getBean("linkService");
        BlogTypeService blogTypeService=(BlogTypeService)applicationContext.getBean("blogTypeService");
        BlogTagService blogTagService=(BlogTagService)applicationContext.getBean("blogTagService");
        BlogService blogService=(BlogService)applicationContext.getBean("blogService");
        MottoService mottoService=(MottoService)applicationContext.getBean("mottoService");
        SignatureService signatureService=(SignatureService)applicationContext.getBean("signatureService");

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

    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }


}

package com.ldb.cache;

import com.ldb.pojo.po.BlogTagPO;
import com.ldb.pojo.po.BlogTypePO;
import com.ldb.pojo.vo.BlogDateArchiveVO;
import com.ldb.pojo.vo.LinkVO;
import com.ldb.service.BlogService;
import com.ldb.service.BlogTagService;
import com.ldb.service.BlogTypeService;
import com.ldb.service.LinkService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
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

        //调用service方法，取得数据
        List<LinkVO> linkList=linkService.listLink();
        List<BlogTypePO> blogTypeList=blogTypeService.listBlogType();
        List<BlogTagPO> blogTagList=blogTagService.listBlogTag();
        List<BlogDateArchiveVO> blogDateArchiveList=blogService.listBlogDateArchive();

        //将数据塞进application
        application.setAttribute("linkList",linkList);//友情链接
        application.setAttribute("blogTypeList",blogTypeList);//博客类比
        application.setAttribute("blogTagList",blogTagList);//博客列表
        application.setAttribute("blogDateArchiveList",blogDateArchiveList);//博客日期归档;

    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }


}

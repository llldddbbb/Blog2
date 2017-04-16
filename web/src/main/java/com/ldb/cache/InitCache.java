package com.ldb.cache;

import com.ldb.pojo.po.BlogTagPO;
import com.ldb.pojo.po.BlogTypePO;
import com.ldb.pojo.vo.LinkVO;
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

        LinkService linkService=(LinkService)applicationContext.getBean("linkService");
        BlogTypeService blogTypeService=(BlogTypeService)applicationContext.getBean("blogTypeService");
        BlogTagService blogTagService=(BlogTagService)applicationContext.getBean("blogTagService");

        List<LinkVO> linkList=linkService.listLink();
        List<BlogTypePO> blogTypeList=blogTypeService.listBlogType();
        List<BlogTagPO> blogTagList=blogTagService.listBlogTag();

        application.setAttribute("linkList",linkList);
        application.setAttribute("blogTypeList",blogTypeList);
        application.setAttribute("blogTagList",blogTagList);

    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }


}

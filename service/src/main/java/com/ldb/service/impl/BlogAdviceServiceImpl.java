package com.ldb.service.impl;

import com.ldb.dao.BlogAdviceDAO;
import com.ldb.dao.BlogAdviceReplyDAO;
import com.ldb.pojo.bo.PageBeanBO;
import com.ldb.pojo.po.BlogAdvicePO;
import com.ldb.service.BlogAdviceService;
import com.ldb.service.utils.BlogAdviceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ldb on 2017/4/19.
 */
@Service("blogAdviceService")
public class BlogAdviceServiceImpl implements BlogAdviceService {

    @Autowired
    private BlogAdviceDAO blogAdviceDAO;

    @Autowired
    private BlogAdviceReplyDAO blogAdviceReplyDAO;

    @Override
    public List<BlogAdvicePO> listBlogAdvice(PageBeanBO pageBeanBO) {
        List<BlogAdvicePO> blogAdviceList = blogAdviceDAO.listBlogAdvicePO(pageBeanBO);
        BlogAdviceUtil.setBlogAdvice(blogAdviceList,blogAdviceReplyDAO);
        return blogAdviceList;
    }

    @Override
    public Long getBlogAdviceCount() {
        return blogAdviceDAO.getBlogAdviceCount();
    }

    @Override
    public int addBlogAdvice(BlogAdvicePO blogAdvicePO) {
        return blogAdviceDAO.addBlogAdvice(blogAdvicePO);
    }

    @Override
    public Long getNotReplyCount() {
        return blogAdviceDAO.getNotReplyCount();
    }

    @Override
    public int deleteBlogAdvice(Integer id) {
        blogAdviceReplyDAO.deleteBlogAdviceReply(id);
        return blogAdviceDAO.deleteBlogAdvice(id);
    }
}

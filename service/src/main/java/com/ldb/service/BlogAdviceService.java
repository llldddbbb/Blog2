package com.ldb.service;

import com.ldb.pojo.bo.PageBeanBO;
import com.ldb.pojo.po.BlogAdvicePO;

import java.util.List;

/**
 * Created by ldb on 2017/4/19.
 */
public interface BlogAdviceService {

    List<BlogAdvicePO> listBlogAdvice(PageBeanBO pageBeanBO);

    Long getBlogAdviceCount();

    int addBlogAdvice(BlogAdvicePO blogAdvicePO);

    Long getNotReplyCount();

    int deleteBlogAdvice(Integer id);
}

package com.ldb.dao;

import com.ldb.pojo.bo.PageBeanBO;
import com.ldb.pojo.po.BlogAdvicePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ldb on 2017/4/19.
 */
public interface BlogAdviceDAO {

    List<BlogAdvicePO> listBlogAdvicePO(PageBeanBO pageBeanBO);

    Long getBlogAdviceCount();

    int addBlogAdvice(BlogAdvicePO blogAdvicePO);

    Long getNotReplyCount();

    int deleteBlogAdvice(@Param("id")Integer id);


}

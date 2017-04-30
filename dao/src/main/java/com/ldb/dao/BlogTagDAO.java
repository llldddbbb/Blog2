package com.ldb.dao;

import com.ldb.pojo.po.BlogTagPO;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
public interface BlogTagDAO {

    List<BlogTagPO> listBlogTagPO(HashMap<String,Integer> param);

    BlogTagPO getBlogTag(@Param("blogTagId")Integer blogTagId);

    int updateBlogTag(BlogTagPO blogTagPO);

    int deleteBlogTag(@Param("id") Integer id);

    int addBlogTag(BlogTagPO blogTagPO);

    Long getBlogTagCount();

}

package com.ldb.dao;

import com.ldb.pojo.po.BlogTagPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
public interface BlogTagDAO {

    List<BlogTagPO> listBlogTagPO();

    BlogTagPO getBlogTag(@Param("blogTagId")Integer blogTagId);

}

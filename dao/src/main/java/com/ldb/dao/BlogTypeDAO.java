package com.ldb.dao;

import com.ldb.pojo.po.BlogTypePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
public interface BlogTypeDAO {

    List<BlogTypePO> listBlogTypePO();

    BlogTypePO getBlogType(@Param("blogTypeId")Integer blogTypeId);

    int updateBlogType(BlogTypePO blogTypePO);

    int deleteBlogType(@Param("id") Integer id);

    int addBlogType(BlogTypePO blogTypePO);

}

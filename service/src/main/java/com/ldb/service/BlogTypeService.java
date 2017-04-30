package com.ldb.service;

import com.ldb.pojo.po.BlogTypePO;

import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
public interface BlogTypeService {

    List<BlogTypePO> listBlogType();

    int updateBlogType(BlogTypePO blogTypePO);

    int deleteBlogType(Integer id);

    int addBlogType(BlogTypePO blogTypePO);
}
